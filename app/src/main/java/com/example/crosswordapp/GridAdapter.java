package com.example.crosswordapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private final List<Cell> cells;
    private View view;

    public GridAdapter(Context context, List<Cell> cells) {
        this.context = context;
        this.cells = cells;
    }

    @Override
    public int getCount() {
        return cells.size();
    }

    @Override
    public Object getItem(int position) {
        if (cells.size() > position)
            return cells.get(position);
        else
            return null;
    }

    @Override
    public long getItemId(int position) {
        if (cells.size() > position)
            return cells.get(position).getId();
        else
            return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            view = new View(context);
            view = layoutInflater.inflate(R.layout.cell, null);
            ImageView cellBackground = (ImageView) view.findViewById(R.id.cellBackground);
            TextView cellText = (TextView) view.findViewById(R.id.cellText);
            Cell cell = cells.get(position);
            cellBackground.setImageResource(cell.getBackgroundRes());
            cellText.setText(cell.getContent());
        }
        return view;
    }
}
