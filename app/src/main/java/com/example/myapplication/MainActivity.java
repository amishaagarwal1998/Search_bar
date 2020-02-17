package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    ListView l1;
    String[] items;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.edit);
        l1 = (ListView) findViewById(R.id.listView);
        items = new String[]{"Cappuccino", "Expresso", "Mocha", "Latte", "Irish Coffee", "Mochaccino", "Macchiato","Coffee Latte" };
        arrayList = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.textView, arrayList);
        l1.setTextFilterEnabled(true);
        l1.setAdapter(adapter);

        e1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainActivity.this.adapter.getFilter().filter(charSequence);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}