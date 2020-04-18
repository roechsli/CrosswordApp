package com.example.crosswordapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private GridView crosswordGrid;
    private List<Cell> cells;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        crosswordGrid = findViewById(R.id.crosswordGrid);

        Random rd = new Random();
        for (int i = 0; i < 40; i++){
            String orientation;
            if (rd.nextBoolean()) orientation = "right";
            else orientation = "down";
            Cell cell = new Cell("", rd.nextBoolean(), rd.nextBoolean(), orientation);
            cells.add(cell);
        }
        updateGridView();
    }

    private void updateGridView(){
        GridAdapter gridAdapter = new GridAdapter(this, cells);
        crosswordGrid.setAdapter(gridAdapter);
    }
}
