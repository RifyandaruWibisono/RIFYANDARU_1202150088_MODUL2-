package com.lesson4.android.rifyandaru_1202150088_modul2;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class menumakan extends AppCompatActivity {

    private RecyclerView mdaftarmakan;
    private ArrayList<Menu> Mmenu;
    private menuadapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menumakan);

//        mangambil id recycler view dari layout menumakan
        mdaftarmakan = (RecyclerView) findViewById(R.id.daftar_makan);
//      set manjadi linear layout
        mdaftarmakan.setLayoutManager(new LinearLayoutManager(this));
        // membuat array list objek menu untuk menyimpan String dan image
        Mmenu = new ArrayList<>();
//      membuat adapter untuk recycler view
        mAdapter = new menuadapter(this, Mmenu);

        initializeData();
    }

    private void initializeData() {
        //Get the resources from the XML file
//        mengambil array yang berada pada list string
        String[] menuList = getResources().getStringArray(R.array.nama_menu);
        String[] menuHarga = getResources().getStringArray(R.array.harga_menu);
        String[] menuKomposisi = getResources().getStringArray(R.array.komposisi);
        TypedArray menuImageResources = getResources().obtainTypedArray(R.array.images);
        //Clear the existing data (to avoid duplication)

        Mmenu.clear();

        //memasukkan String dan Image id ke Array list Menu objek

        for(int i=0; i<menuList.length; i++){
            Mmenu.add(new Menu(menuList[i], menuHarga[i], menuKomposisi[i],
                    menuImageResources.getResourceId(i,0)));
        }
        //Recycle the typed array
        menuImageResources.recycle();

        //notifkasi perubahan ppada adapter dan menggunakan adaptr pada recycler view
        mAdapter.notifyDataSetChanged();
        mdaftarmakan.setAdapter(mAdapter);
    }
}
