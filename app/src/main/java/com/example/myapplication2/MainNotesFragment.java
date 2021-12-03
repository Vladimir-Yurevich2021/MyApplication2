  package com.example.myapplication2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


  public class MainNotesFragment extends Fragment {


    public static MainNotesFragment newInstance(String param1, String param2) {
        MainNotesFragment fragment = new MainNotesFragment();
        Bundle args = new Bundle();

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
        return inflater.inflate(R.layout.fragment_notes_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Note note = new Note();
        LinearLayout linearLayout= (LinearLayout) view;
        TextView tv = new TextView(getContext());
        tv.setText(String.valueOf(note.nameNote + " " + note.dataNote));
        tv.setTextSize(22);
        linearLayout.addView(tv);

        TextView tv2 = new TextView(getContext());
        tv2.setText(String.valueOf(note.nameNote2 + " " + note.dataNote2));
        tv2.setTextSize(22);
        linearLayout.addView(tv2);

        TextView tv3 = new TextView(getContext());
        tv3.setText(String.valueOf(note.nameNote3 + " " + note.dataNote3));
        tv3.setTextSize(22);
        linearLayout.addView(tv3);
        Button btnCreate=view.findViewById(R.id.btn_create);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                NotesResultFragment notesResultFragment=new NotesResultFragment();
                fragmentTransaction.replace(R.id.container_fragment,notesResultFragment).commit();
            }
        });

    }
}