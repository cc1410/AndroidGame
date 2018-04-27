package com.example.juanelberto.menuprincipal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Ajustes extends AppCompatActivity {

    ImageView imageView;
    ImageButton btnSelectPhoto, btnTakePhoto;
    EditText edFirstname, edLastname;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_SELECT_IMAGE = 2;
    static Object imgUri = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
         imageView = (ImageView) findViewById(R.id.imageView);
        btnSelectPhoto = (ImageButton) findViewById(R.id.btnSelectPhoto);
        btnTakePhoto = (ImageButton) findViewById(R.id.btnTakePhoto);
         edFirstname = (EditText) findViewById(R.id.edFirstname);
         edLastname = (EditText) findViewById(R.id.edLastname);

        btnSelectPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                intent.setType("image/*");
                intent.putExtra("return-data", true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_SELECT_IMAGE);
            }
        });

        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });


    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode != requestCode){
            switch (requestCode){
                case REQUEST_IMAGE_CAPTURE:
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    imageView.setImageBitmap(imageBitmap);
                  //   imgUri = saveToInternalStorage(imageBitmap);
                   // saveSettings();
                    break;
                case REQUEST_SELECT_IMAGE:
                    Uri imageUri = data.getData();
                    Log.d("chen", imageUri.toString());
                    imageView.setImageURI(imageUri);
                //    saveSettings();
                    break;
            }

        }
    }


}
