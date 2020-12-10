package com.example.hsyaddressbook;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hsyaddressbook.UserDao;
import com.example.hsyaddressbook.User;
import com.example.hsyaddressbook.UserDaoImpl;

import java.io.ByteArrayOutputStream;

public class EditActivity extends AppCompatActivity {

    Button editbt;
    EditText nmtext;
    EditText phtext;
    ImageView imgv;
    String id;
    UserDao mld;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        init();
    }
    public void init(){
        mld = new UserDaoImpl(getApplicationContext());
        nmtext = (EditText) findViewById(R.id.nmtext);
        phtext = (EditText) findViewById(R.id.phtext);
        imgv = (ImageView) findViewById(R.id.imgv);
        editbt = (Button) findViewById(R.id.editbt);
        id = String.valueOf((Integer)getIntent().getSerializableExtra("id"));
        User user = mld.GetOne(id);
        nmtext.setText(user.getName());
        phtext.setText(user.getPhone());
        if(user.getImage()==null){
            int rsId = getResources().getIdentifier("head", "drawable" , getPackageName());
            imgv.setImageResource(rsId);
        }else{
            Bitmap bm = BitmapFactory.decodeByteArray(user.getImage(), 0, user.getImage().length);
            imgv.setImageBitmap(bm);
            bmp = bm;
        }
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });
        editbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nmtext.getText().toString();
                String phone = phtext.getText().toString();

                byte[] img = null;
                if(bmp!=null){
                    ByteArrayOutputStream os = new ByteArrayOutputStream();
                    small(bmp).compress(Bitmap.CompressFormat.PNG, 100, os);
                    img=os.toByteArray();
                }
                User user = new User(Integer.valueOf(id),name,phone,img);
                if(mld.UpdateMail(user)) {
                    Toast.makeText(getApplicationContext(),"修改成功",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"修改失败",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            System.out.println(imagePath);
            showImage(imagePath);
            c.close();
        }
    }
    private void showImage(String imaePath){
        bmp = BitmapFactory.decodeFile(imaePath);
        imgv.setImageBitmap(bmp);
    }
    private static Bitmap small(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(0.1f,0.1f);  //长和宽放大缩小的比例
        Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
        return resizeBmp;
    }
}
