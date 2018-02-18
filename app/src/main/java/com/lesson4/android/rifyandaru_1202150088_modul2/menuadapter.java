package com.lesson4.android.rifyandaru_1202150088_modul2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
/**
 * Created by User on 18/02/2018.
 */

public class menuadapter extends
        RecyclerView.Adapter<menuadapter.WordViewHolder> {

    // membuat array, kontainer gambar dan kontex aktivitas untuk konstruktor
    private GradientDrawable mGradientDrawable;
    private ArrayList<Menu> mArray;
    private Context mContext;

    menuadapter(Context mContext, ArrayList<Menu> mArray) {
        this.mArray = mArray;
        this.mContext = mContext;
//        set conatainer untuk gambar
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setSize(70,70);
    }


    // mengemmbalikan menuviewholder
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WordViewHolder(mContext, LayoutInflater.from(mContext)
                .inflate(R.layout.wordlist_item,parent,false), mGradientDrawable);
    }

    //    mengisi item recycler view
    @Override
    public void onBindViewHolder(menuadapter.WordViewHolder holder, int position) {
        Menu current = mArray.get(position);
        holder.bindTo(current);

    }

    @Override
    public int getItemCount() {
        return mArray.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mNama;
        private TextView mHarga;
        private ImageView mMenuImage;
        private Context mContext;
        private Menu mCurrentMenu;
        private GradientDrawable mGradientDrawable;

        // mencari id pada layout worldlist_item
        WordViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);
            mNama = (TextView)itemView.findViewById(R.id.menu_gambar);
            mHarga = (TextView)itemView.findViewById(R.id.harga_gambar);
            mMenuImage = (ImageView)itemView.findViewById(R.id.gambar);
            mContext = context;
            mGradientDrawable = gradientDrawable;

            itemView.setOnClickListener(this);
        }

        //        set semua layout dengan nilai string dan gambar dari objek menu
        public void bindTo(Menu current) {
            mNama.setText(current.getNamaMakanan());
            mHarga.setText(current.getHargaMenuMakanan());
            mCurrentMenu = current;
//            load gambar dengan glide menggunkan id gambar ke layout
            Glide.with(mContext).load(current.
                    getImageMenuMakanan()).placeholder(mGradientDrawable).into(mMenuImage);

        }

        // membuka menu kepilih dengan intent dari menu.
        @Override
        public void onClick(View view) {
            Intent detailIntent = Menu.starter(mContext, mCurrentMenu.getNamaMakanan(),
                    mCurrentMenu.getHargaMenuMakanan(), mCurrentMenu.getKomposisiMakanan(),
                    mCurrentMenu.getImageMenuMakanan());

            mContext.startActivity(detailIntent);
        }
    }
}
