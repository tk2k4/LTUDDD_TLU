package com.example.ltuddd_tlu.tuan3.tuan32_Java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ltuddd_tlu.R;

import java.util.ArrayList;

public class T32Adapter extends BaseAdapter {

    private ArrayList<T32Contact> ls;
    private Context context;

    public T32Adapter(ArrayList<T32Contact> ls, Context context) {
        this.ls = ls;
        this.context = context;
    }

    //lay ve so luong item
    @Override
    public int getCount() {
        return ls.size();
    }

    //lay ve item
    @Override
    public Object getItem(int position) {
        return ls.get(position);
    }

    //lay ve id
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //b1 - tao view
        ViewAX vax;
        if(convertView == null){
            vax = new ViewAX();
            convertView = LayoutInflater.from(context).inflate(R.layout.tuan32_listview_item, null);
            vax.img_hinh = convertView.findViewById(R.id.t32ItemHinh);
            vax.tv_ten = convertView.findViewById(R.id.T32ItemTen);
            vax.tv_tuoi = convertView.findViewById(R.id.T32ItemTuoi);

            convertView.setTag(vax);

        }
        else {
            vax = (ViewAX) convertView.getTag();

        }

        //gan du lieu cho layout
        vax.img_hinh.setImageResource(ls.get(position).getHinh());
        vax.tv_ten.setText(ls.get(position).getTen());
        vax.tv_tuoi.setText(ls.get(position).getTuoi());

        return convertView;
    }

    //dinh nghia view
    class ViewAX{
        ImageView img_hinh;
        TextView tv_ten, tv_tuoi;
    }

}
