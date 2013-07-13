package com.appathon.letsgo;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by mphox on 7/13/13.
 */
public class EventListAdapter extends ArrayAdapter {

    Context mContext;
    int mResourceID;
    ArrayList<Event> eventList = new ArrayList<Event>();
    LayoutInflater inflater;

    public EventListAdapter(Context context, int layoutResourceId, ArrayList<Event>  data){
        super(context, layoutResourceId);

        mContext = context;
        mResourceID = layoutResourceId;
        eventList = data;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;/*
        ViewHolder holder;

        if(row == null) {
            row = inflater.inflate(mResourceID, parent, false);

            holder = new ViewHolder();
            holder.textName = (TextView)row.findViewById(R.id.textView1);
            holder.imageDeal = (ImageView)row.findViewById(R.id.imageView1);
            holder.progressBar = (ProgressBar)row.findViewById(R.id.progressDownload);

            row.setTag(holder);
        } else {
            holder = (ViewHolder)row.getTag();
        }

        DealSubItem item = mData.get(position);
        holder.textName.setText(item.Name);

        if(item.ImageBitmap == null) {
            new DownloadImageAsync(holder.imageDeal, holder.progressBar, item).execute(item.Image);
        } else {
            holder.progressBar.setVisibility(View.GONE);
            holder.imageDeal.setImageBitmap(item.ImageBitmap);
        }
*/
        return row;
    }
}
