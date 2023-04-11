package com.example.notebook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdaptar extends RecyclerView.Adapter<NotesAdaptar.NotesViewHolder> {
    ArrayList<Notes> notes;
    public  NotesAdaptar(ArrayList<Notes>notes){
        this.notes = notes;
    }
    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note,parent,false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

        holder.bindView(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class   NotesViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView category;
        TextView description;

        public NotesViewHolder(@NonNull View itemView){

            super(itemView);
            title = itemView.findViewById(R.id.title);
            category = itemView.findViewById(R.id.category);
            description = itemView.findViewById(R.id.desc);
        }

        public void bindView(Notes note){
            title.setText(note.getTitle());
            category.setText(note.category);
            description.setText(note.dis);
        }
    }
}
