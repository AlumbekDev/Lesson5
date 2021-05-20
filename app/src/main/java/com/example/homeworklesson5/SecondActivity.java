package com.example.homeworklesson5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public static final String NAME = "Name";
    ImageView mainImageView;
    TextView title, description;
    private LanguegeModel model;

    String data1, data2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        if (getIntent().hasExtra("title")){
            title.setText(Server.getModelByTitle(getIntent().getStringExtra("title")).getDescription());
        }
//        Intent intent = new Intent();
//        startActivityForResult(intent, 100);
//        title.setText(model.getTitle());

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 100 && resultCode == RESULT_OK) {
//            if (data != null) {
//                LanguegeModel languegeModel = new LanguegeModel(data.getStringExtra("name"), data.getStringExtra("des"), data.getIntExtra("image", 10));
//                title.setText(languegeModel.getTitle());
//                description.setText(languegeModel.getDescription());
//
//            }
//        }
//    }

    private void getData() {
        if (getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") &&
                getIntent().hasExtra("data2")) {

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage", 1);

        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myImage);
    }

}