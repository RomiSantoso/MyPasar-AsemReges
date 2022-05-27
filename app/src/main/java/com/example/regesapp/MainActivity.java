package com.example.regesapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.regesapp.laporan.LaporanActivity;
import com.example.regesapp.logsheet.LogsheetActivity;
import com.example.regesapp.peralatan.PeralatanActivity;
import com.example.regesapp.tu.TuActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //#QUICK ACCESS====================================================
        //tu
        findViewById(R.id.quick_access_tu).setOnClickListener(view -> startActivity(new Intent(this, TuActivity.class)));

        //peralatan
        findViewById(R.id.quick_access_perlatan).setOnClickListener(view -> startActivity(new Intent(this, PeralatanActivity.class)));

        //input amr
        findViewById(R.id.quick_access_input_amr).setOnClickListener(view -> { toastCustomDewek(); });

        //laporan
        findViewById(R.id.quick_access_laporan).setOnClickListener(view -> { startActivity(new Intent(this, LaporanActivity.class)); });

        //pengaturan
        findViewById(R.id.quick_access_pengaturan).setOnClickListener(view -> { toastCustomDewek(); });


        //#ICON MENU MASTER====================================================
        //tu
        findViewById(R.id.tu).setOnClickListener(view -> startActivity(new Intent(this, TuActivity.class)));
        //peralatan
        findViewById(R.id.peralatan).setOnClickListener(view -> { toastCustomDewek(); });

        //bpp
        findViewById(R.id.bpp).setOnClickListener(view -> { toastCustomDewek(); });

        //siptu
        findViewById(R.id.siptu).setOnClickListener(view -> { toastCustomDewek(); });

        //shptu
        findViewById(R.id.shptu).setOnClickListener(view -> { toastCustomDewek(); });

        //listrik
        findViewById(R.id.listrik).setOnClickListener(view -> { toastCustomDewek(); });


        //#ICON MENU AKTIFITAS====================================================
        //absensi
        findViewById(R.id.absensi).setOnClickListener(view -> { toastCustomDewek(); });

        //lembur
        findViewById(R.id.lembur).setOnClickListener(view -> { toastCustomDewek(); });

        //kunjungan
        findViewById(R.id.kunjungan).setOnClickListener(view -> { toastCustomDewek(); });

        //surat masuk
        findViewById(R.id.surat_masuk).setOnClickListener(view -> { toastCustomDewek(); });

        //surat keluar
        findViewById(R.id.surat_keluar).setOnClickListener(view -> { toastCustomDewek(); });

        //lainnya
        findViewById(R.id.logout).setOnClickListener(view -> {toastCustomDewek();});

        //input amr
        findViewById(R.id.input_amr).setOnClickListener(view -> { toastCustomDewek(); });

        //logsheet
        findViewById(R.id.logsheet).setOnClickListener(view -> { startActivity(new Intent(this, LogsheetActivity.class)); });

        //pengaturan
        findViewById(R.id.pengaturan).setOnClickListener(view -> { toastCustomDewek(); });
    }

    //TOAST
    public void toastCustomDewek(){
        Toast.makeText(this, "Sedang dikembangkan", Toast.LENGTH_LONG).show();
    }


    //BACK PRESSED ALERT
    @Override
    public void onBackPressed(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.exit);
        builder.setTitle("Konfirmasi :");
        builder.setMessage("Yakin akan keluar ?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("Batal", null);

        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}