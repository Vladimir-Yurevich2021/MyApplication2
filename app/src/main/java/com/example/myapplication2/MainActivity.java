package com.example.myapplication2;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavigationView();

        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.txt_note_result,
                            NotesFragment.newInstance(0)).commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_fragment, new
                            MainNotesFragment()).commit();
        }


    }

    private void initNavigationView() {

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.drawer_about:
                        openAboutFragment();
                        return true;
                    case R.id.drawer_exit:
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Предупреждение!")
                                .setMessage("Вы собираетесь выйти из программы?")
                                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        showToast();
                                        finish();
                                    }
                                }).setNeutralButton("Отмена", null).show();


                        return true;

                }
                return false;
            }
        });
    }

    private void showToast() {
        Toast.makeText(this, "Спасибо, что пользуетесь нашим приложением!", Toast.LENGTH_SHORT).show();

    }

    private void openAboutFragment() {
        AboutFragment aboutFragment = new AboutFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("")
                .replace(R.id.container_fragment, aboutFragment)
                .commit();
    }
}