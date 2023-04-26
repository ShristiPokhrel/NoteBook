package com.example.notebook;

public interface NoteListner {
        void onNoteClick(Notes note);
        void onNoteEditPress(Notes note);
        void onDeletePress(Notes note);
    }

