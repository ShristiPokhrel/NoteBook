package com.example.notebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton btnAddNote;
    ArrayList<Notes> notes;
    NotesAdaptar adaptar;
    NotebookDbHelper dbHelper;

ActivityResultLauncher<Intent> resultIntent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
    @Override
    public void onActivityResult(ActivityResult result) {
       if (result.getResultCode() == Activity.RESULT_OK){
           Intent data = result.getData();
           String title = data.getExtras().getString("note_title");
           Log.d("TAG","title:"+title);
           String description = data.getExtras().getString("note_description");
           Log.d("TAG","description:"+description);
           String category = data.getExtras().getString("note_category");
           Toast.makeText(MainActivity.this, "Title:" + title + ", Description:" +description, Toast.LENGTH_SHORT).show();
       Notes note = new Notes(title,description,category);
               dbHelper.addNote(note);
       }
    }
});
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddNote = findViewById(R.id.btnAddNote);
        dbHelper = new NotebookDbHelper(getApplicationContext());

        notes = new ArrayList<>();
        notes.addAll(dbHelper.getAllNotes());
        // notes.add(new Notes ("Note1","Desc 1", "Cat1"));

        RecyclerView  rv= findViewById(R.id.rvNotes);
        rv.setAdapter(new NotesAdaptar(notes, new NoteListner() {
            @Override
            public void onNoteClick(Notes note) {
                Intent intent = new Intent(MainActivity.this, DetailView.class);
                intent.putExtra("title", note.getTitle());
                intent.putExtra("description", note.getDis());
                intent.putExtra("category", note.getCategory());
                startActivity(intent);
            }

            @Override
            public void onNoteEditPress(Notes note) {

            }

            @Override
            public void onDeletePress(Notes note) {

            }
        }));
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                resultIntent.launch(intent);
            }
        });


    }
}

