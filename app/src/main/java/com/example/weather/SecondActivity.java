package com.example.weather;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.example.weather.MainActivity.EXTRA_STATE;
import static com.example.weather.MainActivity.TEXT;


public class SecondActivity extends AppCompatActivity {


    private ListView countriesList;
    private Object State;

    private State state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView cityText = findViewById(R.id.city);

        String tow = getResources().getString(R.string.typeOfWear);

        TextView textView = findViewById(R.id.typeOfWeather);
        textView.setText(tow);

        TextView textViewDate = findViewById(R.id.textViewDate);
        TextView textViewWind = findViewById(R.id.typeOfWind);

        ImageView imageView = findViewById(R.id.flag);

        TextView textViewState = findViewById(R.id.name_State);
        TextView textViewCapital = findViewById(R.id.capital);

        Date currentDate = new Date();
        // Форматирование времени как "день.месяц.год"
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);
        textViewDate.setText(dateText);


        Send send = (Send) getIntent().getExtras().getSerializable(TEXT);
        cityText.setText(send.textCity);
        textViewWind.setText(send.windText);

        Intent intent = getIntent();

        state = (State) intent.getSerializableExtra(EXTRA_STATE);
        if (state != null) {
            Toast.makeText(this, state.getName(), Toast.LENGTH_SHORT).show();
        }

        imageView.setImageResource(state.getFlagResource());
        textViewState.setText(state.getName());
        textViewCapital.setText(state.getCapital());


    }


}



