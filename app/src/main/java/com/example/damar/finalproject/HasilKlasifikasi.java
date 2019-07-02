package com.example.damar.finalproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.damar.finalproject.Menu.AuditoriActivity;

public class HasilKlasifikasi extends AppCompatActivity {

    private static final String TAG = "Hasil Act";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_klasifikasi);
        TextView textView = (TextView) findViewById(R.id.hasil_klasifikasi);
        Button button = (Button) findViewById(R.id.btn_metodebelajar);
        Intent intent = getIntent();
        final String pesan = intent.getStringExtra("pesan");
        Log.d(TAG, "pesan : "+pesan);
        final String cekA = "Auditori";
        textView.setText("Hasilnya anak anda " + pesan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pesan.equals(cekA)){
                    Intent i = new Intent(HasilKlasifikasi.this, AuditoriActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(HasilKlasifikasi.this,"GAGAL",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
