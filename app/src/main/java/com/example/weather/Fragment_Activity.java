package com.example.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.weather.MainActivity.EXTRA_STATE;


public class Fragment_Activity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        ImageView  imageView = findViewById (R.id.flag);
        TextView textViewState = findViewById (R.id.capital);


        Intent intent = getIntent();

        State state = (State) intent.getSerializableExtra(EXTRA_STATE);
        if (state != null) {
            Toast.makeText(this, state.getName(), Toast.LENGTH_SHORT).show();
        }

        imageView.setImageResource(state.getFlagResource());
        textViewState.setText(state.getName());
        //textViewCapital.setText(state.getCapital());

    }
}
