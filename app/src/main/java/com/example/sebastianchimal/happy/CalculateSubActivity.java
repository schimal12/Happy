package com.example.sebastianchimal.happy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalculateSubActivity extends AppCompatActivity {

    private TextView cantidadTextView, dolaresTextView;
    private Double cantidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_sub);
        cantidadTextView = (TextView)findViewById(R.id.textView5);
        dolaresTextView =  (TextView)findViewById(R.id.textView6);

        cantidad = getIntent().getDoubleExtra("cantidad",-1.0);

        cantidadTextView.setText(cantidad.toString());
    }

    public void cierra(View view){
        Intent it = new Intent();
        it.putExtra("dolares",cantidad);
        setResult(RESULT_OK,it);
        finish();
    }

    public void calcula(View view){
        cantidad *= 18.30;
        dolaresTextView.setText(cantidad.toString());
    }
}
