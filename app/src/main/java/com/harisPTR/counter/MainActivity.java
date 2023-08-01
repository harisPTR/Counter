package com.harisPTR.counter;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout parentLayout;
    private Button addButton;
    private float boxHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);
        ////////////////////////////////////////////////////////////////////////////////////////////////////

        parentLayout = findViewById(R.id.parent_layout);
        addButton = findViewById(R.id.buttonAddField);
        boxHeight = getResources().getDisplayMetrics().heightPixels * 0.15f;

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new LinearLayout to hold the "box"
                LinearLayout newBoxLayout = new LinearLayout(MainActivity.this);
                newBoxLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        (int) boxHeight));
                newBoxLayout.setOrientation(LinearLayout.VERTICAL);

                // Create the smaller EditText
                EditText newEditText = new EditText(MainActivity.this);
                newEditText.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                newEditText.setHint("Enter text here");
                newEditText.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_FLAG_CAP_SENTENCES | android.text.InputType.TYPE_TEXT_FLAG_MULTI_LINE);
                newEditText.setSingleLine(true);

                // Create the Button
                Button newButton = new Button(MainActivity.this);
                newButton.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                newButton.setText("Button");

                // Add the smaller EditText and Button to the new LinearLayout (box)
                newBoxLayout.addView(newEditText);
                newBoxLayout.addView(newButton);

                // Add the new "box" to the parent LinearLayout
                parentLayout.addView(newBoxLayout);
            }
        });
    }
}

