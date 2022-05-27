package com.example.regesapp.logsheet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.regesapp.MainActivity;
import com.example.regesapp.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class LogsheetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logsheet);

        //BACK TO MAIN
        findViewById(R.id.back_to_main).setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));

        //SCANNING
        findViewById(R.id.next).setOnClickListener(view -> {
            IntentIntegrator intentIntegrator = new IntentIntegrator(LogsheetActivity.this);
            intentIntegrator.setPrompt("Tekan Vol + untuk menyalakan flash");
            intentIntegrator.setBeepEnabled(true);
            intentIntegrator.setOrientationLocked(true);
            intentIntegrator.setCaptureActivity(Capture.class);
            intentIntegrator.initiateScan();
        });
    }

    //RESULT FROM SCANNING
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(intentResult.getContents() != null){
            AlertDialog.Builder builder = new AlertDialog.Builder(LogsheetActivity.this);
            builder.setTitle("ID Unit");
            builder.setMessage(intentResult.getContents());
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        } else{
            Toast.makeText(getApplicationContext(), "Tidak dapat diproses  !", Toast.LENGTH_LONG).show();
        }
    }
}