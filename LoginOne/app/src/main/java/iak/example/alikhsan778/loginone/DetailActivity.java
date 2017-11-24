package iak.example.alikhsan778.loginone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
ImageView mImage;
    TextView mTextEmail, mTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mImage = (ImageView)findViewById(R.id.img_account);
        mTextEmail = (TextView)findViewById(R.id.tv_user_get);
        mTextPassword = (TextView)findViewById(R.id.tv_pas_get);
        Intent i = getIntent();
        if(i!=null){
            //mImage.setImageResource(Integer.parseInt(i.getStringExtra("image_send")));
            mTextEmail.setText(i.getStringExtra("email_send"));
            mTextPassword.setText(i.getStringExtra("pass_send"));
            Bundle bundle = getIntent().getExtras();
            byte[] bytes = bundle.getByteArray("image_send");
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0, bytes.length);
            mImage.setImageBitmap(bitmap);

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
        finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
