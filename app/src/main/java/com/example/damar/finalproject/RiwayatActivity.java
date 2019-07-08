package com.example.damar.finalproject;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.damar.finalproject.database.SQLiteDatabaseHandler;
import com.example.damar.finalproject.model.History;

import java.util.List;

public class RiwayatActivity extends AppCompatActivity {

    private static final String TAG = "as";
    private SQLiteDatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        List<History> histories = db.allPlayers();
        Log.d(TAG, "onCreate: " +histories.get(0).getNama());
        Toast.makeText(this,histories.get(0).getNama(),Toast.LENGTH_SHORT).show();
    }
}
