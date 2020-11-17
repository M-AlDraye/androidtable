package com.example.androidtable;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText productQuantity, productName;
    TextView productID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bttnAdd = (Button) findViewById(R.id.bttnAdd);
        Button bttnFind = (Button) findViewById(R.id.bttnFind);
        Button bttnDelete = (Button) findViewById(R.id.bttnDelete);

        myDB = new DatabaseHelper(this);
        productID = (TextView) findViewById(R.id.productID);
        productQuantity = (EditText) findViewById(R.id.productQuantity);
        productName = (EditText) findViewById(R.id.productName);


        bttnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pname = productName.getText().toString();
                String pquantity = productQuantity.getText().toString();
                if (pname.length() != 0 || pquantity.length() != 0) {
                    myDB.addData(pname, pquantity);
                } else {
                    Toast.makeText(MainActivity.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bttnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = myDB.structuredQuery(int id);
                String cID = cursor.getString(0);
                String cName = cursor.getString(1);
                String cPrQuant = cursor.getString(2);
                Toast.makeText(MainActivity.this, cID +","+cName+","+cPrQuant, Toast.LENGTH_LONG).show();

            }
        });
        bttnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
    }