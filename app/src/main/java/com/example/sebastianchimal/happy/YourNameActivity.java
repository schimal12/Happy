package com.example.sebastianchimal.happy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class YourNameActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_name);
        editText = (EditText)findViewById(R.id.editText);
    }
    public void siguienteActividad(View view){
        Intent it = new Intent(this,WelcomeActivity.class);
        if(editText.getText().toString().length()>0){
            String name = editText.getText().toString();
            it.putExtra("name",name);
            startActivity(it);
        }else{
            Toast.makeText(this, R.string.falta_texto,Toast.LENGTH_LONG).show();
        }
    }
}
