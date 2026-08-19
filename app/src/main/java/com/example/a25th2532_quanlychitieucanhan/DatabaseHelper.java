package com.example.a25th2532_quanlychitieucanhan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "QuanLyChiTieu_25TH2532.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_TRANSACTIONS = "transactions";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_NOTE = "note";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_TRANSACTIONS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT NOT NULL, " +
                COLUMN_AMOUNT + " REAL NOT NULL, " +
                COLUMN_CATEGORY + " TEXT, " +
                COLUMN_TYPE + " TEXT NOT NULL, " +
                COLUMN_DATE + " TEXT NOT NULL, " +
                COLUMN_NOTE + " TEXT);";
        db.execSQL(CREATE_TABLE);

        // Chèn dữ liệu mẫu ban đầu
        db.execSQL("INSERT INTO " + TABLE_TRANSACTIONS + " (title, amount, category, type, date, note) VALUES ('Lương tháng 8', 15000000, 'Lương', 'THU', '01/08/2026', 'Lương hàng tháng');");
        db.execSQL("INSERT INTO " + TABLE_TRANSACTIONS + " (title, amount, category, type, date, note) VALUES ('Ăn sáng', 35000, 'Ăn uống', 'CHI', '15/08/2026', 'Phở bò');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTIONS);
        onCreate(db);
    }

    public long addTransaction(Transaction t) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, t.getTitle());
        values.put(COLUMN_AMOUNT, t.getAmount());
        values.put(COLUMN_CATEGORY, t.getCategory());
        values.put(COLUMN_TYPE, t.getType());
        values.put(COLUMN_DATE, t.getDate());
        values.put(COLUMN_NOTE, t.getNote());
        long id = db.insert(TABLE_TRANSACTIONS, null, values);
        db.close();
        return id;
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_TRANSACTIONS + " ORDER BY " + COLUMN_ID + " DESC", null);
        if (cursor.moveToFirst()) {
            do {
                Transaction t = new Transaction();
                t.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)));
                t.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE)));
                t.setAmount(cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_AMOUNT)));
                t.setCategory(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CATEGORY)));
                t.setType(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TYPE)));
                t.setDate(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE)));
                t.setNote(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOTE)));
                list.add(t);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public int updateTransaction(Transaction t) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, t.getTitle());
        values.put(COLUMN_AMOUNT, t.getAmount());
        values.put(COLUMN_CATEGORY, t.getCategory());
        values.put(COLUMN_TYPE, t.getType());
        values.put(COLUMN_DATE, t.getDate());
        values.put(COLUMN_NOTE, t.getNote());
        int res = db.update(TABLE_TRANSACTIONS, values, COLUMN_ID + " = ?", new String[]{String.valueOf(t.getId())});
        db.close();
        return res;
    }

    public void deleteTransaction(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TRANSACTIONS, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public double getTotalIncome() {
        double total = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT SUM(" + COLUMN_AMOUNT + ") FROM " + TABLE_TRANSACTIONS + " WHERE " + COLUMN_TYPE + " = 'THU'", null);
        if (cursor.moveToFirst()) total = cursor.getDouble(0);
        cursor.close();
        db.close();
        return total;
    }

    public double getTotalExpense() {
        double total = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT SUM(" + COLUMN_AMOUNT + ") FROM " + TABLE_TRANSACTIONS + " WHERE " + COLUMN_TYPE + " = 'CHI'", null);
        if (cursor.moveToFirst()) total = cursor.getDouble(0);
        cursor.close();
        db.close();
        return total;
    }
}