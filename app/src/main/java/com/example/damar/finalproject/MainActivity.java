package com.example.damar.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.damar.finalproject.database.SQLiteDatabaseHandler;
import com.example.damar.finalproject.model.History;
import com.example.damar.finalproject.model.Klasifikasi;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageButton btn_konsulMetode, btn_konsultasi, btn_metode, btn_history, btn_help;

    private SQLiteDatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Menu Utama");

        btn_konsultasi = (ImageButton) findViewById(R.id.btn_konsultasi);
        btn_konsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openKonsultasi();
            }
        });
        btn_metode = (ImageButton) findViewById(R.id.btn_metode);
        btn_metode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMetode();
            }
        });
        btn_history = (ImageButton) findViewById(R.id.btn_history);
        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHistory();
            }
        });
        btn_help = (ImageButton) findViewById(R.id.btn_help);
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHelp();
            }
        });
        btn_konsulMetode = (ImageButton) findViewById(R.id.btn_konsulMetode);
        btn_konsulMetode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openKonsulMetode();
            }
        });

        db = new SQLiteDatabaseHandler(this);

//        History player1 = new History(1, "Lebron James", "F", "jagd");
//        History player2 = new History(2, "Kevin Durant", "F", "da");
//        History player3 = new History(3, "Rudy Gobert", "C", "da");
//
//        db.addHistory(player1);
//        db.addHistory(player2);
//        db.addHistory(player3);


    }
    public void openKonsultasi(){
        Intent intent = new Intent(this, KlasifikasiActivity.class);
        startActivity(intent);
    }
    public void openMetode(){
        Intent intent = new Intent(this, MetodeActivity.class);
        startActivity(intent);
    }
    public void openHistory(){
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
    public void openHelp(){
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
    public void openKonsulMetode(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

}
