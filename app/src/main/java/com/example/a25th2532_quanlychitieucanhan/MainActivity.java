package com.example.a25th2532_quanlychitieucanhan;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvTotalBalance, tvTotalIncome, tvTotalExpense, tvEmptyState;
    private ListView lvTransactions;
    private FloatingActionButton fabAdd;
    private DatabaseHelper dbHelper;
    private List<Transaction> transactionList;
    private TransactionAdapter adapter;
    private DecimalFormat currencyFormat = new DecimalFormat("#,### đ");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTotalBalance = findViewById(R.id.tvTotalBalance);
        tvTotalIncome = findViewById(R.id.tvTotalIncome);
        tvTotalExpense = findViewById(R.id.tvTotalExpense);
        tvEmptyState = findViewById(R.id.tvEmptyState);
        lvTransactions = findViewById(R.id.lvTransactions);
        fabAdd = findViewById(R.id.fabAdd);

        dbHelper = new DatabaseHelper(this);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEditTransactionActivity.class);
                startActivity(intent);
            }
        });

        lvTransactions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Transaction selected = transactionList.get(position);
                Intent intent = new Intent(MainActivity.this, AddEditTransactionActivity.class);
                intent.putExtra("TRANSACTION_ID", selected.getId());
                intent.putExtra("TITLE", selected.getTitle());
                intent.putExtra("AMOUNT", selected.getAmount());
                intent.putExtra("CATEGORY", selected.getCategory());
                intent.putExtra("TYPE", selected.getType());
                intent.putExtra("DATE", selected.getDate());
                intent.putExtra("NOTE", selected.getNote());
                startActivity(intent);
            }
        });

        lvTransactions.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Transaction selected = transactionList.get(position);
                showDeleteDialog(selected);
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        transactionList = dbHelper.getAllTransactions();

        if (transactionList.isEmpty()) {
            tvEmptyState.setVisibility(View.VISIBLE);
            lvTransactions.setVisibility(View.GONE);
        } else {
            tvEmptyState.setVisibility(View.GONE);
            lvTransactions.setVisibility(View.VISIBLE);
            adapter = new TransactionAdapter(this, transactionList);
            lvTransactions.setAdapter(adapter);
        }

        double income = dbHelper.getTotalIncome();
        double expense = dbHelper.getTotalExpense();
        double balance = income - expense;

        tvTotalIncome.setText("Thu: " + currencyFormat.format(income));
        tvTotalExpense.setText("Chi: " + currencyFormat.format(expense));
        tvTotalBalance.setText(currencyFormat.format(balance));
    }

    private void showDeleteDialog(final Transaction transaction) {
        new AlertDialog.Builder(this)
                .setTitle("Xóa giao dịch")
                .setMessage("Bạn có chắc muốn xóa '" + transaction.getTitle() + "'?")
                .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHelper.deleteTransaction(transaction.getId());
                        Toast.makeText(MainActivity.this, "Đã xóa thành công!", Toast.LENGTH_SHORT).show();
                        loadData();
                    }
                })
                .setNegativeButton("Hủy", null)
                .show();
    }
}