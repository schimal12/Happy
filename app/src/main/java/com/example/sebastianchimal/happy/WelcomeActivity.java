package com.example.sebastianchimal.happy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class WelcomeActivity extends AppCompatActivity {

    private TextView yourNarcName, dolaresTextView, narcLevelTextView;
    private EditText moneyEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        yourNarcName = (TextView)findViewById(R.id.textView22);
        String name = getIntent().getStringExtra("name");
        yourNarcName.setText(name);
        moneyEditText = (EditText)findViewById(R.id.editText2);
        dolaresTextView = (TextView)findViewById(R.id.textView2);
        narcLevelTextView = (TextView)findViewById(R.id.textView4);
    }
    public void abreBrowser(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://mexico.cnn.com/")));
    }

    private int VALOR_SUBACTIVIDAD = 5007;

    public void convierteDolares(View view){
        Intent it = new Intent(this,CalculateSubActivity.class);
        Double cantidad = Double.parseDouble(moneyEditText.getText().toString());

        it.putExtra("Cantidad", cantidad);
        startActivityForResult(it, VALOR_SUBACTIVIDAD);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == VALOR_SUBACTIVIDAD && resultCode == RESULT_OK){
            Double dolares = data.getDoubleExtra("dolares", -1.0);
            dolaresTextView.setText(dolares.toString());
            if(dolares>999999.99){
                narcLevelTextView.setText("Darth Sidious Level");

            }else{
                narcLevelTextView.setText("Apprentice Level");
            }

        }else if(resultCode == RESULT_CANCELED){
            Toast.makeText(this,"No Hubo conversion",Toast.LENGTH_LONG).show();
        }
    }
}
