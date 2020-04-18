package com.example.crosswordapp;

import java.util.UUID;

public class Cell {
    private long id;
    private String content;
    private boolean isClickable;
    private boolean isWritable;
    private String orientation;
    private int backgroundRes;

    public Cell(String content, boolean isClickable, boolean isWritable, String orientation) {
        this.id = Long.parseLong(UUID.randomUUID().toString());
        this.content = content;
        this.isClickable = isClickable;
        this.isWritable = isWritable;
        this.orientation = orientation;

        if (isClickable) {
            if (isWritable) {
                this.backgroundRes = R.drawable.letter;
            } else {
                if (orientation.equals("right"))
                    this.backgroundRes = R.drawable.description_right;
                else
                    this.backgroundRes = R.drawable.description_down;
            }
        } else {
            this.backgroundRes = R.drawable.greyed_out;
        }
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (this.isWritable())
            this.content = content;
    }

    public boolean isClickable() {
        return isClickable;
    }

    public boolean isWritable() {
        return isWritable;
    }

    public String getOrientation() {
        return orientation;
    }

    public int getBackgroundRes() {
        return backgroundRes;
    }
}
