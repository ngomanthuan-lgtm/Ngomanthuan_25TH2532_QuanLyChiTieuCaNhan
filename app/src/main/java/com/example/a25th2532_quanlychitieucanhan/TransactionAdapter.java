package com.example.a25th2532_quanlychitieucanhan;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class TransactionAdapter extends BaseAdapter {
    private Context context;
    private List<Transaction> transactionList;
    private DecimalFormat currencyFormat = new DecimalFormat("#,### đ");

    public TransactionAdapter(Context context, List<Transaction> transactionList) {
        this.context = context;
        this.transactionList = transactionList;
    }

    @Override
    public int getCount() {
        return transactionList.size();
    }

    @Override
    public Object getItem(int position) {
        return transactionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return transactionList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_transaction, parent, false);
        }

        Transaction t = transactionList.get(position);

        TextView tvTitle = convertView.findViewById(R.id.tvItemTitle);
        TextView tvCategoryDate = convertView.findViewById(R.id.tvItemCategoryDate);
        TextView tvAmount = convertView.findViewById(R.id.tvItemAmount);
        TextView tvNote = convertView.findViewById(R.id.tvItemNote);

        tvTitle.setText(t.getTitle());
        tvCategoryDate.setText(t.getCategory() + " | " + t.getDate());

        if (t.getNote() != null && !t.getNote().trim().isEmpty()) {
            tvNote.setText("Ghi chú: " + t.getNote());
            tvNote.setVisibility(View.VISIBLE);
        } else {
            tvNote.setVisibility(View.GONE);
        }

        if ("THU".equalsIgnoreCase(t.getType())) {
            tvAmount.setText("+" + currencyFormat.format(t.getAmount()));
            tvAmount.setTextColor(Color.parseColor("#2E7D32"));
        } else {
            tvAmount.setText("-" + currencyFormat.format(t.getAmount()));
            tvAmount.setTextColor(Color.parseColor("#C62828"));
        }

        return convertView;
    }
}