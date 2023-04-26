package com.example.notebook;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailView extends AppCompatActivity {

    TextView tvTitle, tvDes, tvCatagory;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        String title = getIntent().getExtras().getString("title");
        String description = getIntent().getExtras().getString("description");
        String category = getIntent().getExtras().getString("category");

        setContentView(R.layout.detail_view);

        tvTitle = findViewById(R.id.viewdDesc);
        tvDes = findViewById(R.id.viewCategory);
        tvCatagory = findViewById(R.id.viewTitle);


        tvTitle.setText("Title is: "+ title);
        tvDes.setText("Description is: "+ description);
        tvCatagory.setText("Category is: "+ category);
    }


}
