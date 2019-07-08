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

public class AudioVisual1 extends AppCompatActivity {
    public TextView metode1, metode2, metode3, metode4, metode5, keterangan1, keterangan2, keterangan3, keterangan4, keterangan5;
    String hasil1 = "Metode Roundtable";
    String ket1 = "Pembelajaran kooperatif tipe round/ rally table merupakan teknik menulis yang menerapkan pembelajaran dengan menunjuk tiap-tiap anggota kelompok untuk berpartisipasi secara bergiliran dalam kelompoknya dengan membentuk meja bundar atau duduk melingkar.\n";
    String hasil2 = "Metode Time Token Arends";
    String ket2 = "Model pembelajaran Time Token Arends merupakan salah satu contoh kecil dari penerapan pembelajaran yang demokratis di sekolah. Proses pembelajaran yang demokratis adalah proses belajar yang menempatkan siswa sebagai subyek. Mereka harus mengalami sebuah perubahan ke arah yang lebih positif.\n";
    String hasil3 = "Metode Studi Kasus";
    String ket3 = "Metode Studi Kasus yaitu cara penelaahan suatu kasus nyata dilapangan melalui kegiatan penelitian, yang diakhiri dengan kegiatan penyampaian laporan.\n";
    String hasil4 = "Metode DIAD";
    String ket4 = "Metode DIAD yaitu cara komunikasi diantara dua orang baik secara lisan maupun tertulis terutama menyangkut identitas dari masing–masing pribadi.\n";
    String hasil5 = "Metode Complete Sentence";
    String ket5 = "Model Pembelajaran Complete Sentence merupakan rangkaian proses pembelajaran yang diawali dengan menyampaikan materi ajar oleh guru, atau dengan penganalisaan terhadap modul yang telah dipersiapkan, pembagian kelompok yang tidak boleh lebih dari tiga orang dengan kemampuan yang heterogen, pemberian  lembar kerja yang berisi paragraf yang belum lengkap, lalu diberikan kesempatan kepada siswa untuk berdiskusi dan diakhiri dengan pengambilan kesimpulan.\n";

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
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Form Nama");

        txt_nama = (EditText) dialogView.findViewById(R.id.input_nama);

        dialog.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                nama = txt_nama.getText().toString();

                Date tanggal = new Date();
                History player1 = new History(1, nama, "Audio-Visual", "metodebelajar");
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
