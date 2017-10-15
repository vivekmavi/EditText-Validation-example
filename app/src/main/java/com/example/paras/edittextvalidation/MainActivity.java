package com.example.paras.edittextvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher{

    EditText ed1;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.edtitText);
        btn1= (Button) findViewById(R.id.btn1);
        ed1.addTextChangedListener(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(view.getId()==R.id.btn1)
                {
                    try {

                        String oldtext = ed1.getText().toString();
                        int num = Integer.parseInt(oldtext);
                        ed1.setText(String.valueOf(num+1));

                    } catch (NumberFormatException exception)
                    {
                        Toast.makeText(MainActivity.this, "number format exception", Toast.LENGTH_SHORT).show();
                        ed1.setText("1");
                    }

                }
            }
        });
        ed1.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        try{
            int i = Integer.parseInt(editable.toString()); // creates no format exception for empty string
            if(i>100)
        {
            Toast.makeText(this,"% cannot be greater then 100",Toast.LENGTH_LONG).show();
            editable.replace(0,editable.length(),"100");
        }}catch (NumberFormatException e)
        {
            Toast.makeText(this," numberformatexception",Toast.LENGTH_LONG).show();
        }
    }
}
