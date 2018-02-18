package com.lesson4.android.rifyandaru_1202150088_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class dinein extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinein);

        Intent coba = getIntent();
        Toast tampil = Toast.makeText(this, coba.getStringExtra("toast"), Toast.LENGTH_SHORT);
        tampil.show();
        spinner = (Spinner) findViewById(R.id.label_spinner);
        if (spinner != null) {spinner.setOnItemSelectedListener(this);}
        // membuat adapter untuk spinner dengan string array label meja
        adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // menggunakan adapater pada spinner
        if (spinner != null) spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void pesanandine(View view) {
        Intent intent = new Intent(this, menumakan.class);
        startActivity(intent);
    }
}
