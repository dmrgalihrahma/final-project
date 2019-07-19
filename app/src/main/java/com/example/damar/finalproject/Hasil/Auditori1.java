package com.example.damar.finalproject.Hasil;

import android.content.Context;
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
import android.widget.Toast;

import com.example.damar.finalproject.HasilActivity;
import com.example.damar.finalproject.HistoryActivity;
import com.example.damar.finalproject.MainActivity;
import com.example.damar.finalproject.R;
import com.example.damar.finalproject.database.SQLiteDatabaseHandler;
import com.example.damar.finalproject.model.History;

import java.util.Date;

public class Auditori1 extends AppCompatActivity {
    public TextView metode1, metode2, metode3, metode4, metode5, keterangan1, keterangan2, keterangan3, keterangan4, keterangan5;
    String hasil1 = "Metode Ceramah";
    String ket1 = "Metode pembelajaran ceramah adalah penerangan secara lisan atas bahan pembelajaran kepada sekelompok pendengar untuk mencapai tujuan pembelajaran tertentu dalam jumlah yang relatif besar.\n";
    String hasil2 = "Metode Tanya Jawab";
    String ket2 = "Metode tanya jawab adalah suatu cara penyampaian pelajaran oleh guru dengan jalan mengajukan pertanyaan dan murid menjawab.\n";
    String hasil3 = "Metode Curah Pendapat";
    String ket3 = "Metode Brainstorming adalah suatu teknik atau mengajar yang dilaksanakan oleh guru di dalam kelas. Ialah dengan melontarkan suatu masalah ke kelas oleh guru, kemudian siswa menjawab atau menyatakan pendapat, atau komentar sehingga mungkin masalah tersebut berkembang menjadi masalah baru, atau dapat diartikan pula sebagai satu cara untuk mendapatkan banyak ide dari sekelompok manusia dalam waktu yang singkat.\n";
    String hasil4 = "Metode Sumbang Saran";
    String ket4 = "Metode sumbang saran adalah suatu bentuk diskusi dalam rangka menghimpun gagasan, pendapat, informasi, pengetahuan, pengalaman dari semua peserta. Berbeda dengan diskusi, dimana gagasan dari seseorang ditanggapi (didukung, dilengkapi, dikurangi, atau tidak disepakati) oleh peserta lain, pada penggunaan metode curah pendapat orang lain tidak untuk ditanggapi.\n";
    String hasil5 = "Metode Share Your Information";
    String ket5 = "Share Your Information merupakan suatu metode pembelajaran yang bertujuan menyampaikan materi/informasi yang relevan dengan cara yang menyenangkan bagi peserta didik dan pengajar yang melibatkan semua orang di dalam proses pembelajaran.\n";

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
        this.setTitle("Auditori");

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
                History player1 = new History(1, nama, "Auditori", "metodebelajar");
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
