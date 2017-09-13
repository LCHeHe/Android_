package com.example.administrator.text_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    TextView l;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ask_A = (Button) this.findViewById(R.id.button_askA);
        ask_A.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText IdA = (EditText) findViewById(R.id.editText_ask);
                String u = IdA.getText().toString();
                Intent intent = new Intent(MainActivity.this, answer_1.class);
                intent.putExtra("qe", u);
                startActivityForResult(intent,0);
            }
        });

        Button ask_B = (Button) this.findViewById(R.id.button_askB);
        ask_B.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText IdB = (EditText) findViewById(R.id.editText_ask);
                String u = IdB.getText().toString();
                Intent intent = new Intent(MainActivity.this, answer_2.class);
                intent.putExtra("qe",u);
                startActivityForResult(intent,1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==0 && resultCode==0)
        {
//            Intent intent = new Intent();
            String str=data.getStringExtra("a");
            l = (TextView) findViewById(R.id.textanswer);
            l.setText(str);
        }
        else if(requestCode==1 && resultCode==1)
        {
            Intent intent = new Intent();
            String str=data.getStringExtra("b");
            l = (TextView) findViewById(R.id.textanswer);
            l.setText(str);
        }
    }
}
