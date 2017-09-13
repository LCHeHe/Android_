package com.example.lc.test_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class test_4 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_4);

        final String h = "L.txt";
        Button a = (Button) findViewById(R.id.cun);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OutputStream out = null;
                try {
                    FileOutputStream fileOutputStream = openFileOutput(h, MODE_PRIVATE);
                    out = new BufferedOutputStream(fileOutputStream);

                    EditText in = (EditText)findViewById(R.id.input);
                    String content = in.getText().toString();
                    try {
                        out.write(content.getBytes(StandardCharsets.UTF_8));
                    } finally {
                        if (out != null)
                            out.close();
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        Button b = (Button) findViewById(R.id.qu);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputStream in = null;
                try {
                    FileInputStream fileInputStream = openFileInput(h);
                    in = new BufferedInputStream(fileInputStream);

                    int c;
                    StringBuilder stringBuilder = new StringBuilder("");
                    try {
                        while ((c = in.read()) != -1) {
                            stringBuilder.append((char) c);
                        }
                        TextView out = (TextView)findViewById(R.id.output);
                        out.setText(stringBuilder.toString());
                    } finally {
                        if (in != null)
                            in.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
