package com.lesson4.android.rifyandaru_1202150088_modul2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by User on 18/02/2018.
 */

// class untuk menu yang akan menjadi objek untuk menempatkan string dan gambar
public class Menu {
    private final String namaMenu;
    private final String hargaMenu;
    private final String komposisi;
    private final int imageMenu;

    public Menu(String nama, String hargaMenu, String komposisi,int imageMenu) {
        this.namaMenu = nama;
        this.hargaMenu = hargaMenu;
        this.imageMenu = imageMenu;
        this.komposisi = komposisi;
    }

    String getNamaMakanan(){
        return namaMenu;
    }
    String getHargaMenuMakanan(){
        return hargaMenu;
    }
    String getKomposisiMakanan(){return komposisi;}
    int getImageMenuMakanan(){ return imageMenu;}

    // method untuk menjalankan aktivitas yang memuncuklkan detail menu.
    static Intent starter(Context context, String namaMenu, String hargaMenu,
                          String komposisi, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, MenuKepilih.class);
        detailIntent.putExtra("namamakanan", namaMenu);
        detailIntent.putExtra("hargamakanan", hargaMenu);
        detailIntent.putExtra("komposisimakanan", komposisi);
        detailIntent.putExtra("imagemakanan", imageResId);
        return detailIntent;
    }
}
