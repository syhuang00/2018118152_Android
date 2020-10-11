package com.example.uimytest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editText;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView=(ImageView)findViewById(R.id.image_view);
        button.setOnClickListener(this);
    }
            @Override
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.button:
                        AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("确定查找吗");
                        dialog.setMessage("查询全市的美食店铺。");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        dialog.show();
                    imageView.setImageResource(R.drawable.loveuser);
                    String inputText=editText.getText().toString();
                    Toast.makeText(MainActivity.this,inputText,
                            Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }



