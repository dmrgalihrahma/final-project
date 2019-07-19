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
    String ket1 = "     Metode belajar ini memiliki kelebihan untuk melatih siswa untuk bersikap kritis terhadap semua teori yang telah diberikan.\n" +
            "dan melatih siswa untuk berani mengemukakan pendapat.\n        a. Guru membagi 2 kelompok peserta debat yang satu pro dan yang lainya kontra. \n       b. Guru memberikan tugas untuk membaca materi yang akan didebatkan oleh kedua kelompok diatas.\n       c. Setelah selesai membaca materi, guru menunjuk salah satu anggotanya. Kelompok pro untuk berbicara saat itu ditanggapi atau dibahas oleh kelompok kontra demikian seterusnya sampai sebagian besar siswa bisa mengemukakan pendapatnya.\n      d. Sementara siswa menyampaikan gagasannya guru menulis inti/ide-ide dari setiap pembicaraan di papan tulis. Sampai sejumlah ide yang diharapkan guru terpenuhi.\n      e. Guru menambahkan konsep/ide yang belum terungkap.\n      f. Dari data-data di papan tersebut, guru mengajak siswa membuat kesimpulan/rangkuman yang mengacu pada topik yang ingin dicapai.\n";
    String hasil2 = "Metode Active Learning";
    String ket2 = "     Pembelajaran aktif (active learning) adalah suatu proses pembelajaran untuk memberdayakan peserta didik agar belajar dengan menggunakan berbagai cara/strategi secara aktif. Model pembelajaran aktif (active learning) menggunakan beragam media dan alat pembelajaran untuk membuat siswa berkegiatan secara aktif di kelas sementara model pembelajaran konvensional/tradisional umumnya tanpa atau hanya menggunakan satu atau sedikit media pembelajaran.\n";
    String hasil3 = "Metode Pair Checks";
    String ket3 = "     Model ini menerapkan pembelajaran kooperatif yang menuntut kemandirian dan kemampuan siswa dalam menyelesaikan persoalan. Model ini juga melatih tanggung jawab sosial siswa, kerja sama, dan kemampuan memberi penilaian.\n    Sedangkan, model cooperative learning tipe paircheck adalah modifikasi dari tipe think pairs share, dimana penekanan pembelajaran ada pada saat mereka diminta untuk saling cek jawaban atau tanggapan terhadap pertanyaan guru saat berada dalam pasangan.\n";
    String hasil4 = "Metode Talking Sticks";
    String ket4 = "     Model pembelajaran Talking Stik adalah suatu model pembelajaran kelompok dengan bantuan tongkat, kelompok yang memegang tongkat terlebih dahulu wajib menjawab pertanyaan dari guru setelah siswa mempelajari materi pokoknya, selanjutnya kegiatan tersebut diulang terus-menerus sampai semua kelompok mendapat giliran untuk menjawab pertanyaan dari guru.\n    Dalam penerapan model pembelajaran Kooperatif Tipe Talking Stik ini, guru membagi kelas menjadi kelompok-kelompok dengan anggota 5 atau 6 orang yang heterogen. Kelompok dibentuk dengan mempertimbangkan keakraban, persahabatan atau minat, yang dalam topik selanjutnya menyiapkan dan mempersentasekan laporannya kepada seluruh kelas.\n";
    String hasil5 = "Metode Two Way Two Stray";
    String ket5 = "     Memberikan kesempatan kepada kelompok untuk membagikan hasil dan informasi dengan kelompok lainnya.\n   Ciri-cirinya antara lain:\n     a. Siswa bekerja dalam kelompok secara kooperatif untuk menuntaskan materi belajarnya.\n      b. Kelompok dibentuk dari siswa yang memiliki kemampuan tinggi, sedang dan rendah.\n      c. Bila mungkin anggota kelompok berasal dari ras, budaya, suku, jenis kelamin yang berbeda.\n      d. Penghargaan lebih berorientasi pada kelompok dari pada individu.\n";
    String hasil6 = "Metode Inside Outside Circle";
    String ket6 = "     Model Pembelajaran IOC (Inside Outside Circle) adalah model pembelajaran dengan sistem lingkaran kecil dan lingkaran besar di mana siswa saling membagi informasi pada saat yang bersamaan dengan pasangan yang berbeda dengan singkat dan teratur.\n   Pendekatan ini bisa digunakan dalam beberapa mata pelajaran, seperti: ilmu pengetahuan sosial, agama, matematika, dan bahasa. Bahan pelajaran yang paling cocok digunakan dengan teknik IOC ini adalah bahan yang membutuhkan pertukaran pikiran dan informasi antar siswa.\n";

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

//        Log.d("", "onClick: klik");
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
