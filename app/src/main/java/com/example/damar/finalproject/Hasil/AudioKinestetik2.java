package com.example.damar.finalproject.Hasil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.damar.finalproject.HistoryActivity;
import com.example.damar.finalproject.MainActivity;
import com.example.damar.finalproject.R;
import com.example.damar.finalproject.database.SQLiteDatabaseHandler;
import com.example.damar.finalproject.model.History;

import java.util.Date;

public class AudioKinestetik2 extends AppCompatActivity {
    public TextView metode1, metode2, keterangan1, keterangan2;
    String hasil1 = "Metode Debat Aktif";
    String ket1 = "Metode debat merupakan salah satu metode pembelajaran yang sangat penting untuk meningkatkan kemampuan akademik siswa. Materi ajar dipilih dan disusun menjadi paket pro dan kontra.\n";
    String hasil2 = "Metode Pair Checks";
    String ket2 = "Model ini menerapkan pembelajaran kooperatif yang menuntut kemandirian dan kemampuan siswa dalam menyelesaikan persoalan. Model ini juga melatih tanggung jawab sosial siswa, kerja sama, dan kemampuan memberi penilaian.\n    Sedangkan, model cooperative learning tipe paircheck adalah modifikasi dari tipe think pairs share, dimana penekanan pembelajaran ada pada saat mereka diminta untuk saling cek jawaban atau tanggapan terhadap pertanyaan guru saat berada dalam pasangan.\n";

    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    EditText txt_nama;
    TextView txt_hasil;
    String nama;
    Button btn_simpan;

    private SQLiteDatabaseHandler db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        this.setTitle("Audio-Kinestetik");

        metode1 = (TextView) findViewById(R.id.txt_metode1);
        keterangan1 = (TextView) findViewById(R.id.txt_ket1);
        metode2 = (TextView) findViewById(R.id.txt_metode2);
        keterangan2 = (TextView) findViewById(R.id.txt_ket2);

        metode1.setText("1. "+hasil1);
        keterangan1.setText(""+ket1);
        metode2.setText("2. "+hasil2);
        keterangan2.setText(""+ket2);

        db = new SQLiteDatabaseHandler(this);

        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogForm();
            }
        });
    }

    private void dialogForm () {

        Log.d("mbarang", "onClick: klik");
        dialog = new AlertDialog.Builder(this, R.style.myDialog);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_template, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.drawable.logo);
        dialog.setTitle("Simpan");

        txt_nama = (EditText) dialogView.findViewById(R.id.input_nama);

        dialog.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                nama = txt_nama.getText().toString();

                Date tanggal = new Date();
                History player1 = new History(1, nama, "Audio-Kinestetik", "metodebelajar");
                db.addHistory(player1);

                dialogInterface.dismiss();

                Intent intent = new Intent(getApplicationContext(),HistoryActivity.class);
                startActivity(intent);
            }
        }).create();

        dialog.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();

            }
        });

        dialog.show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
