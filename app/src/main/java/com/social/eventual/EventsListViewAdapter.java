package com.social.eventual;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 5/13/2016.
 */
public class EventsListViewAdapter extends ArrayAdapter<Event> {

private final Activity context;
private final List<Event> list;

public EventsListViewAdapter(Activity context, List<Event> list) {
        super(context, R.layout.events_list_layout, list);
        this.context = context;
        this.list = list;
        }

static class ViewHolder {
    protected TextView title;
    protected TextView location;
  //  protected ProgressBar pb;
}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            LayoutInflater inflator = context.getLayoutInflater();
            view = inflator.inflate(R.layout.events_list_layout, null);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.title = (TextView) view.findViewById(R.id.event_title);
            viewHolder.location= (TextView) view.findViewById(R.id.event_location);

         //   viewHolder.pb = (ProgressBar) view.findViewById(R.id.progressBar1);
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.location.setText(list.get(position).getLocation());
        holder.title.setTag(list.get(position).getTitle());

        return view;
    }
}
