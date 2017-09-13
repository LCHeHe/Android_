package com.example.administrator.text_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class answer_1 extends AppCompatActivity
{
    TextView s;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_1);

        s = (TextView) findViewById(R.id.内容);
        Intent intent = getIntent();
        String q = intent.getStringExtra("qe");
        s.setText(q);

        Button button=(Button)findViewById(R.id.b);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent();
                EditText I = (EditText) findViewById(R.id.editText_answer_1);
                String aId = I.getText().toString();
                intent.putExtra("a", aId);
                setResult(0,intent);
                finish();
            }
        });
    }
}
