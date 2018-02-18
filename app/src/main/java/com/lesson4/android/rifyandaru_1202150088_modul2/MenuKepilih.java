package com.lesson4.android.rifyandaru_1202150088_modul2;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MenuKepilih extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_kepilih);
//        mengaambil id layout .
        TextView namaMenu = (TextView) findViewById(R.id.namaMenuMakanan);
        TextView hargamenu = (TextView) findViewById(R.id.hargaMenuMakanan);
        TextView komposisi = (TextView) findViewById(R.id.komposisi);
        ImageView Imagemenu = (ImageView) findViewById(R.id.menuImageMakanan);

        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);
        gradientDrawable.setSize(100,100);

//        set layout dengan id
        namaMenu.setText(getIntent().getStringExtra("namamakanan"));
        hargamenu.setText(getIntent().getStringExtra("hargamakanan"));
        komposisi.setText(getIntent().getStringExtra("komposisimakanan"));
        Glide.with(this).load(getIntent().getIntExtra("imagemakanan",0))
                .placeholder(gradientDrawable).into(Imagemenu);
    }
}
