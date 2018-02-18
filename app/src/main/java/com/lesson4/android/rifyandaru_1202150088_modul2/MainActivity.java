package com.lesson4.android.rifyandaru_1202150088_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radiogroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent B = getIntent();
        Toast tampilnama = Toast.makeText(this, B.getStringExtra("toast"), Toast.LENGTH_SHORT);
        tampilnama.show();
        radiogroup = (RadioGroup) findViewById(R.id.radio);

    }


    public void pesanan(View view) {
        Intent intent;
//      mengecek radio radio button yang mana yang dipilih
        int selectedjenis = radiogroup.getCheckedRadioButtonId();
        switch (selectedjenis) {
//            apabila dine in akan ke aktiivtas Dine In
            case R.id.dine:
                intent = new Intent(this, dinein.class);
                intent.putExtra("toast", "Dine In");
                startActivity(intent);
                break;
//            sebaliknya apabvila Take away akan ke Aktivitas DIne.
            case R.id.take:
                intent = new Intent(this, takeaway.class);
                intent.putExtra("toast", "Take Away");
                startActivity(intent);
                break;

        }
    }
}
