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

public class Kinestetik2 extends AppCompatActivity {
    public TextView metode1, metode2, metode3, metode4, metode5, keterangan1, keterangan2, keterangan3, keterangan4, keterangan5;
    String hasil1 = "Metode Latihan";
    String ket1 = "Metode latihan keterampilan (drill method) adalah suatu metode mengajar dengan memberikan pelatihan keterampilan secara berulang kepada peserta didik, dan mengajaknya langsung ketempat latihan keterampilan untuk melihat proses tujuan, fungsi, kegunaan dan manfaat sesuatu (misal: membuat tas dari mute)\n";
    String hasil2 = "Metode Permainan";
    String ket2 = "Metode permainan adalah cara mengajar yang dilaksanakan dalam untuk permainan.\n";
    String hasil3 = "Metode Karya Wisata (Field Trip)";
    String ket3 = "Metode karya wisata adalah suatu metode mengajar yang dirancang terlebih dahulu oleh pendidik dan diharapkan siswa membuat laporan dan didiskusikan bersama dengan peserta didik yang lain serta didampingi oleh pendidik, yang kemudian dibukukan.\n";
    String hasil4 = "Metode Kubus Pecah";
    String ket4 = "Metode Broken Square yaitu cara penyusunan pecahan–pecahan Bujur sangkar yang dilakukan oleh empat atau lima kelompok menjadi bentuk bujur sangkar.\n";
    String hasil5 = "Metode Snowball Throwing";
    String ket5 = "Menurut Suprijono, Snowball Throwing adalah suatu cara penyajian bahan pelajaran dimana murid dibentuk dalam beberapa kelompok yang heterogen kemudian masing-masing kelompok dipilih ketua kelompoknya untuk mendapat tugas dari guru lalu masing-masing murid membuat pertanyaan yang dibentuk seperti bola (kertas pertanyaan) kemudian dilempar ke murid lain yang masing-masing murid menjawab pertanyaan dari bola yang diperoleh.\n";

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
        this.setTitle("Kinestetik");

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
                History player1 = new History(1, nama, "Kinestetik", "metodebelajar");
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
