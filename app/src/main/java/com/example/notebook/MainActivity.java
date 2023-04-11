package com.example.notebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton btnAddNote;
    ArrayList<Notes> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddNote = findViewById(R.id.btnAddNote);

        notes = new ArrayList<>();
        notes.add(new Notes ("Note1","Desc 1", "Cat1"));
        notes.add(new Notes ("Note2","Desc 2", "Cat2"));
        notes.add(new Notes ("Note3","Desc 3", "Cat3"));
        notes.add(new Notes ("Note4","Desc 4", "Cat4"));
        notes.add(new Notes ("Note5","Desc 5", "Cat5"));
        notes.add(new Notes ("Note6","Desc 6", "Cat6"));


        RecyclerView  rv= findViewById(R.id.rvNotes);
        rv.setAdapter(new NotesAdaptar(notes));

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                startActivity(intent);
            }
        });


    }
}

