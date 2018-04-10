package com.sillystudio.homemadesoundboard;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Editor extends Activity {

    private GridLayout gridLayout;
    private Integer buttonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        setPrivateValues();
        populateBoard();
    }

    private void populateBoard() {
        for (int i = 0; i < 25; i++){
            final Button addButton = new Button(this);

            addButton.setBackground(getResources().getDrawable(R.drawable.buttonadd));

            addButton.setLayoutParams(getGridLayoutParams());

            addButton.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addButton.setBackgroundResource(0);
                    addButton.setText(getString(R.string.b_newButton) + " " + buttonCount);
                    buttonCount++;
                }
            });

            gridLayout.addView(addButton);
        }
    }

    private GridLayout.LayoutParams getGridLayoutParams(){
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f),
                GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f));

        layoutParams.height = 0;
        layoutParams.width = 0;
        layoutParams.setMargins(5,5,5,5);
        
        return layoutParams;
    }

    private void setPrivateValues() {
        gridLayout = findViewById(R.id.mainGrid);
        buttonCount = 1;
    }
}
