package com.example.login;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

    public class DatabaseHelper extends SQLiteOpenHelper {
        ArrayList<Cart> carts=new ArrayList<>();
        // Database Version
        private static final int DATABASE_VERSION = 1;
        // Database Name
        private static final String DATABASE_NAME = "UserManager.db";
        // User table name
        private static final String TABLE_USER = "user";
        // User Table Columns names
        private static final String COLUMN_USER_ID = "user_id";
        private static final String COLUMN_USER_NAME = "user_name";
        private static final String COLUMN_USER_EMAIL = "user_email";
        private static final String COLUMN_USER_PASSWORD = "user_password";

        private static final String TABLE_CART="cart";
        private static final String CART_ITEMID="cartdish_id";
        private static final String CART_DISHNAME="cartdish_name";
        private static final String CART_PRICE="cart_price";
        private static final String CART_QUANTITY="cart_quantity";

        // create table sql query
        private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
                + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

        private String CREATE_CART_TABLE ="CREATE TABLE " + TABLE_CART + "("
                + CART_ITEMID + " INTEGER PRIMARY KEY AUTOINCREMENT," + CART_DISHNAME + " TEXT,"
                + CART_PRICE + " INTEGER," + CART_QUANTITY + " INTEGER" + ")";

        // drop table sql query
        private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
        private String DROP_CART_TABLE = "DROP TABLE IF EXISTS " + TABLE_CART;

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_USER_TABLE);
            db.execSQL(CREATE_CART_TABLE);
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            //Drop User Table if exist
            db.execSQL(DROP_USER_TABLE);
            db.execSQL(DROP_CART_TABLE);
            // Create tables again
            onCreate(db);

        }

        public void addUser(Users user) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(COLUMN_USER_NAME, user.getName());
            values.put(COLUMN_USER_EMAIL, user.getEmail());
            values.put(COLUMN_USER_PASSWORD, user.getPassword());

            // Inserting Row
            db.insert(TABLE_USER, null, values);
            db.close();
        }




        public boolean checkUser(String email) {

            // array of columns to fetch
            String[] columns = {
                    COLUMN_USER_ID
            };
            SQLiteDatabase db = this.getReadableDatabase();

            // selection criteria
            String selection = COLUMN_USER_EMAIL + " = ?";
            // selection argument
            String[] selectionArgs = {email};

            Cursor cursor = db.query(TABLE_USER, //Table to query
                    columns,                    //columns to return
                    selection,                  //columns for the WHERE clause
                    selectionArgs,              //The values for the WHERE clause
                    null,                       //group the rows
                    null,                      //filter by row groups
                    null);                      //The sort order
            int cursorCount = cursor.getCount();
            cursor.close();
            db.close();

            if (cursorCount > 0) {
                return true;
            }

            return false;
        }

        public boolean checkUser(String email, String password) {

            // array of columns to fetch
            String[] columns = {COLUMN_USER_ID};
            SQLiteDatabase db = this.getReadableDatabase();
            String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

            String[] selectionArgs = {email, password};


            Cursor cursor = db.query(TABLE_USER, //Table to query
                    columns,                    //columns to return
                    selection,                  //columns for the WHERE clause
                    selectionArgs,              //The values for the WHERE clause
                    null,                       //group the rows
                    null,                       //filter by row groups
                    null);                      //The sort order

            int cursorCount = cursor.getCount();

            cursor.close();
            db.close();
            if (cursorCount > 0) {
                return true;
            }

            return false;
        }
        public void addtocart(Cart cart)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(CART_DISHNAME,cart.getDish_name());
            values.put(CART_PRICE, cart.getDish_price());
            values.put(CART_QUANTITY, cart.getQuantity());

            // Inserting Row
            long rowid=db.insert(TABLE_CART, null, values);
            Log.d("cartrow",rowid+"");
            db.close();
        }
        Cart c1=new Cart();
        Cart c2=new Cart();
        Cart c3=new Cart();
        Cart cc[]={c1,c2,c3};
        public void showcart()
        {
            SQLiteDatabase db=this.getReadableDatabase();
            Cursor c=db.query(TABLE_CART,null,null,null,null,null,null);
            int count=c.getCount();
            for (int i=0;i<count;i++)
            {c.moveToPosition(i);
                long id=c.getLong(0);
                String dn=c.getString(1);
                String dishprice=c.getString(2);
                int q=c.getInt(3);
               /* cc[i].dish_name=dn;
                cc[i].dish_price=dishprice;
                cc[i].quantity=q;*/
                carts.add(new Cart(dn,dishprice));
            }
            c.close();
            db.close();
        }
}
