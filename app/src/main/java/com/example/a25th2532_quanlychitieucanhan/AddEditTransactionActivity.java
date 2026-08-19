package com.example.a25th2532_quanlychitieucanhan;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddEditTransactionActivity extends AppCompatActivity {

    private EditText edtTitle, edtAmount, edtDate, edtNote;
    private Spinner spinnerCategory;
    private RadioGroup rgType;
    private RadioButton rbChi, rbThu;
    private Button btnSave, btnCancel;
    private DatabaseHelper dbHelper;
    private int transactionId = -1;

    private String[] categories = {"Ăn uống", "Mua sắm", "Di chuyển", "Học tập", "Lương", "Thưởng", "Giải trí", "Khác"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_transaction);

        edtTitle = findViewById(R.id.edtTitle);
        edtAmount = findViewById(R.id.edtAmount);
        edtDate = findViewById(R.id.edtDate);
        edtNote = findViewById(R.id.edtNote);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        rgType = findViewById(R.id.rgType);
        rbChi = findViewById(R.id.rbChi);
        rbThu = findViewById(R.id.rbThu);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        dbHelper = new DatabaseHelper(this);

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        spinnerCategory.setAdapter(categoryAdapter);

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        Intent intent = getIntent();
        if (intent.hasExtra("TRANSACTION_ID")) {
            setTitle("Sửa Giao Dịch");
            transactionId = intent.getIntExtra("TRANSACTION_ID", -1);
            edtTitle.setText(intent.getStringExtra("TITLE"));
            edtAmount.setText(String.valueOf(intent.getDoubleExtra("AMOUNT", 0)));
            edtDate.setText(intent.getStringExtra("DATE"));
            edtNote.setText(intent.getStringExtra("NOTE"));

            String type = intent.getStringExtra("TYPE");
            if ("THU".equalsIgnoreCase(type)) {
                rbThu.setChecked(true);
            } else {
                rbChi.setChecked(true);
            }

            String category = intent.getStringExtra("CATEGORY");
            for (int i = 0; i < categories.length; i++) {
                if (categories[i].equalsIgnoreCase(category)) {
                    spinnerCategory.setSelection(i);
                    break;
                }
            }
        } else {
            setTitle("Thêm Giao Dịch Mới");
            Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH) + 1;
            int year = calendar.get(Calendar.YEAR);
            edtDate.setText(String.format("%02d/%02d/%d", day, month, year));
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTransaction();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                edtDate.setText(String.format("%02d/%02d/%d", dayOfMonth, monthOfYear + 1, year));
            }
        }, year, month, day);
        dialog.show();
    }

    private void saveTransaction() {
        String title = edtTitle.getText().toString().trim();
        String amountStr = edtAmount.getText().toString().trim();
        String date = edtDate.getText().toString().trim();
        String note = edtNote.getText().toString().trim();
        String category = spinnerCategory.getSelectedItem().toString();
        String type = rbThu.isChecked() ? "THU" : "CHI";

        if (title.isEmpty()) {
            edtTitle.setError("Vui lòng nhập tên giao dịch!");
            return;
        }

        if (amountStr.isEmpty()) {
            edtAmount.setError("Vui lòng nhập số tiền!");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            edtAmount.setError("Số tiền không hợp lệ!");
            return;
        }

        Transaction transaction = new Transaction(transactionId, title, amount, category, type, date, note);

        if (transactionId == -1) {
            dbHelper.addTransaction(transaction);
            Toast.makeText(this, "Thêm giao dịch thành công!", Toast.LENGTH_SHORT).show();
        } else {
            dbHelper.updateTransaction(transaction);
            Toast.makeText(this, "Cập nhật thành công!", Toast.LENGTH_SHORT).show();
        }

        finish();
    }
}