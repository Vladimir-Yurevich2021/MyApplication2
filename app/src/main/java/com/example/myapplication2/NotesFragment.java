package com.example.myapplication2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NotesFragment extends Fragment {
    static final String ARG_INDEX="index";



    public static NotesFragment newInstance(String param1, String param2) {
        NotesFragment fragment = new NotesFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    public static Fragment newInstance(int index) {
        NotesFragment fragment=new NotesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX,index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Note note=new Note();
        TextView tv=view.findViewById(R.id.txt_note_result);
        tv.setText(note.contentNote);
    }
}