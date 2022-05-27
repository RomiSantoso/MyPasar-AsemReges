package com.example.regesapp.tu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.regesapp.MainActivity;
import com.example.regesapp.R;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TuActivity extends AppCompatActivity {
    ListView master_tu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu);

        //BACK TO MAIN
        findViewById(R.id.back_to_main).setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));

        master_tu = findViewById(R.id.master_tu);

        //RUN
        APIMasterTU();



    }

    //GET API FROM GOOGLE SHEETS
    private void APIMasterTU() {
        Call<List<Results>> call = RetrofitClient.getInstance().getMyApi().getAPIMasterTU();
        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                List<Results> data = response.body();
                String[] row = new String[data.size()];

                for (int i = 0; i < data.size(); i++) {
                    row[i] = data.get(i).getName();
                }
                master_tu.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, row));
            }

            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Terjadi Kesalahan ! : ", Toast.LENGTH_LONG).show();
            }

        });
    }
}