package com.ren.jiemei.jartest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ren.jiemei.mylibrary.LoadTest;

public class MainActivity extends AppCompatActivity {

    private Button load;
    private ImageView image;

    private String path = "http://img04.tooopen.com/thumbnails/20130712/x_17270713.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load = (Button) findViewById(R.id.load);
        image = (ImageView) findViewById(R.id.image);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadTest loadTest = new LoadTest();
                loadTest.setUrl(path);
                loadTest.execute();
                loadTest.setDataListence(new LoadTest.setDataL() {
                    @Override
                    public void getData(byte[] bytes) {
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        image.setImageBitmap(bitmap);
                    }
                });
            }
        });
    }
}
