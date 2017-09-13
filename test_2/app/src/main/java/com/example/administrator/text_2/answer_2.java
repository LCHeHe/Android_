package com.example.administrator.text_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class answer_2 extends AppCompatActivity
{
    TextView s;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_2);

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
                Intent intent=getIntent();
                EditText I = (EditText) findViewById(R.id.editText_answer_2);
                String bId = I.getText().toString();
                intent.putExtra("b",bId);
                setResult(1,intent);
                finish();
            }
        });
    }
}
