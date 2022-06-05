package umar.a.kidszone;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.zip.Inflater;

public class ListViewAdapter extends BaseAdapter {
    Context context;
    int [] images;
    LayoutInflater inflater;
    public  ListViewAdapter(Context cox,int[] images ){
        this.context= cox;
        this.images=images;
        inflater=LayoutInflater.from(cox);
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView =inflater.inflate(R.layout.mylist,null);
        ImageView imageView= convertView.findViewById(R.id.imageView3);
        imageView.setImageResource(images[position]);
        return convertView;
    }
}
