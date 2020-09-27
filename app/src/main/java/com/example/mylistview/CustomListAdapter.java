package com.example.mylistview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    ArrayList<ListItem> listData;
    LayoutInflater layoutInflater;
    Context context;
    public CustomListAdapter(Context aContext, ArrayList<ListItem> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
        this.context=aContext;
    }
    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View v, ViewGroup vg ) {
        ViewHolder holder;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();
            holder.mWord = (TextView) v.findViewById(R.id.word);
            holder.mNum = (TextView) v.findViewById(R.id.num);
            holder.mpic=(ImageView)v.findViewById(R.id.imageView);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.mWord.setText(listData.get(position).getWord());
        holder.mNum.setText(listData.get(position).getNum());
        holder.mpic.setImageBitmap(decodeSampleBitmapFromResource(context.getResources(),R.drawable.pic,40,40));
        return v;
    }
    static class ViewHolder {
        TextView mWord;
        TextView mNum;
        ImageView mpic;
    }
    public static Bitmap decodeSampleBitmapFromResource(Resources res,int resId,int reqWidth,int reqHeight){
        final BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeResource(res,resId,options);
        options.inSampleSize = calculateInSampleSize(options,reqWidth,reqHeight);
        options.inJustDecodeBounds=false;
        return BitmapFactory.decodeResource(res,resId,options);
    }
    public static int calculateInSampleSize(BitmapFactory.Options options,int reqWidth,int reqHeight){
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if(height>reqHeight||width>reqWidth){
            final int halfHeight=height/2;
            final int halfWidth=width/2;
            while ((halfHeight/inSampleSize)>reqHeight&&(halfWidth/inSampleSize)>reqWidth){
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}