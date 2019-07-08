package com.example.damar.finalproject.Hasil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
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

public class AudioKinestetik1 extends AppCompatActivity {
    public TextView metode1, metode2, metode3, metode4, metode5, metode6, keterangan1, keterangan2, keterangan3, keterangan4, keterangan5, keterangan6;
    String hasil1 = "Metode Forum Debat";
    String ket1 = "Forum adalah suatu gelanggang terbuka, dimana seseorang mendapat kesempatan berbicara tentang masalah apapun. Pembicara dapat datang dari kelompok massa, dan segera setelah selesai pembicaraannya ia harus kembali ke tempat semula. Jadi dalam forum tidak ada anggota tertentu yang duduk terpisah dari pendengar, tetapi ditekankan pada pemberian kesempatan bagi setiap orang untuk mengemukakan pikiran dan perasaan di depan khalayak. Metode belajar ini memiliki kelebihan untuk melatih siswa untuk bersikap kritis terhadap semua teori yang telah diberikan.\n" +
            "dan melatih siswa untuk berani mengemukakan pendapat.\n";
    String hasil2 = "Metode Active Learning";
    String ket2 = "Pembelajaran aktif (active learning) adalah suatu proses pembelajaran untuk memberdayakan peserta didik agar belajar dengan menggunakan berbagai cara/strategi secara aktif.\n";
    String hasil3 = "Metode Pair Checks";
    String ket3 = "Pair check (pasangan mengecek) adalah model pembelajaran berkelompok atau berpasangan yang dipopulerkan oleh Spencer Kagen tahun 1993.\n";
    String hasil4 = "Metode Talking Sticks";
    String ket4 = "Talking stick termasuk salah satu model pembelajaran. Model pembelajaran talking stick ini dilakukan dengan bantuan tongkat, siapa yang memegang tongkat wajib menjawab pertanyaan dari guru setelah siswa mempelajari materi pokoknya.\n";
    String hasil5 = "Metode Two Way Two Stray";
    String ket5 = "Memberikan kesempatan kepada kelompok untuk membagikan hasil dan informasi dengan kelompok lainnya.\n";
    String hasil6 = "Metode Inside Outside Circle";
    String ket6 = "Model Pembelajaran IOC (Inside Outside Circle) adalah model pembelajaran dengan sistem lingkaran kecil dan lingkaran besar (Spencer Kagan, 1993) di mana siswa saling membagi informasi pada saat yang bersamaan dengan pasangan yang berbeda dengan singkat dan teratur.\n";

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
        metode1 = (TextView) findViewById(R.id.txt_metode1);
        keterangan1 = (TextView) findViewById(R.id.txt_ket1);
        metode2 = (TextView) findViewById(R.id.txt_metode2);
        keterangan2 = (TextView) findViewById(R.id.txt_ket2);
        metode3 = (TextView) findViewById(R.id.txt_metode3);
        keterangan3 = (TextView) findViewById(R.id.txt_ket3);
        metode4 = (TextView) findViewById(R.id.txt_metode4);
        keterangan4 = (TextView) findViewById(R.id.txt_ket4);
        metode5 = (TextView) findViewById(R.id.txt_metode5);
        keterangan5 = (TextView) findViewById(R.id.txt_ket5);
        metode6 = (TextView) findViewById(R.id.txt_metode6);
        keterangan6 = (TextView) findViewById(R.id.txt_ket6);

        metode1.setText("1. "+hasil1);
        keterangan1.setText(""+ket1);
        metode2.setText("2. "+hasil2);
        keterangan2.setText(""+ket2);
        metode3.setText("3. "+hasil3);
        keterangan3.setText(""+ket3);
        metode4.setText("4. "+hasil4);
        keterangan4.setText(""+ket4);
        metode5.setText("5. "+hasil5);
        keterangan5.setText(""+ket5);
        metode6.setText("6. "+hasil6);
        keterangan6.setText(""+ket6);

        db = new SQLiteDatabaseHandler(this);

        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogForm();
            }
        });
    }

    private void dialogForm() {

        Log.d("mbarang", "onClick: klik");
        dialog = new AlertDialog.Builder(this, R.style.myDialog);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_template, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Form Nama");

        txt_nama = (EditText) dialogView.findViewById(R.id.input_nama);

        dialog.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                nama = txt_nama.getText().toString();

                Date tanggal = new Date();
                History player1 = new History(1, nama, "Audio-Kinestetik", "metodebelajar");
                db.addHistory(player1);

                dialogInterface.dismiss();

                Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
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
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
