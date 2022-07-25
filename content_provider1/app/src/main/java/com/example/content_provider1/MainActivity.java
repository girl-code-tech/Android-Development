package com.example.content_provider1;
import java.io.ByteArrayOutputStream;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    MyDataBase mdb;
    SQLiteDatabase db;
    Cursor c;
    ImageView iv;
    byte[] img, img1;
    Bitmap b;
    String name, age, getname;
    TextView textView3, textView4;
    EditText editText1, editText2;
    private static final String table_name = "Image_table";
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Create the database by calling and ing all the parameters to the constructor of MyDataBase class*/

        mdb = new MyDataBase(getApplicationContext(), "imagedata", null, 1);
        //this.deleteDatabase("imagedata");
        iv = (ImageView) findViewById(R.id.myimage);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                name = editText1.getText().toString();
                /* In this i have used BitMap class which is used to put the image in a variable. Bitmapfactory class is used to get the image from the drawable folder by calling decodeResource() method. */
                age = editText2.getText().toString();
                Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.img);
                /*create the object of ByteArrayoutputStream class. Now break the image into the byte parts by calling toByteArray() of ByteOutputStream class and store it in a array */
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                b.compress(Bitmap.CompressFormat.PNG, 100, bos);
                byte[] img = bos.toByteArray();
                /*to write in a database call the getWritableDatabase method */
                db = mdb.getWritableDatabase();
                ContentValues cv = new ContentValues();

                cv.put("image", img);
                cv.put("name", name);
                cv.put("age", age);
                db.insert(table_name, null, cv);
                String selectQuery = "SELECT * FROM "+table_name;
                c = db.rawQuery(selectQuery, null);
                if (c != null)
                {
                    c.moveToFirst();
                    do
                    {
                        img1 = c.getBlob(2);
                        String getname = c.getString(0);
                        String age = c.getString(1);
                    } while (c.moveToNext());
                }
                Bitmap b1 = BitmapFactory.decodeByteArray(img1, 0, img1.length);
                iv.setImageBitmap(b1);
                textView3.setText(name);
                textView4.setText(age);
            }
        });
    }
}
