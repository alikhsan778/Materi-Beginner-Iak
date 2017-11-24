package iak.example.alikhsan778.loginone;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText mEdEmail, mEdPassword;
    CheckBox mAgree;
    ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImage = (ImageView) findViewById(R.id.img_vigure);
        mImage.setImageResource(R.drawable.androidparty);
    }

    public void mActionStartLogin(View view) {
        boolean mValidasi = true;


        mEdEmail = (EditText) findViewById(R.id.et_email);
        mEdPassword = (EditText) findViewById(R.id.et_password);
        mAgree = (CheckBox) findViewById(R.id.cb_agree);
        if (TextUtils.isEmpty(mEdEmail.getText().toString()) || TextUtils.isEmpty(mEdPassword.getText().toString())) {
            mEdEmail.setError("Required");
            mEdPassword.setError("Required");
            mValidasi = false;
        } else if (!mEdEmail.getText().toString().equals("alikhsan778@gmail.com") || !mEdPassword.getText().toString().equals("123456")) {
            mEdEmail.setError("Wrong email");
            mEdPassword.setError("Wrong Password");
            mValidasi = false;
        }

        if (mValidasi) {
            String sEdEmail = mEdEmail.getText().toString();
            String sEdPass = mEdPassword.getText().toString();
            if (mAgree.isChecked()) {
                Toast.makeText(this, "Your " + sEdEmail + " This Assesment", Toast.LENGTH_SHORT).show();
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.androidparty);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] bytes = byteArrayOutputStream.toByteArray();
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                i.putExtra("image_send", bytes);
                i.putExtra("email_send", sEdEmail);
                i.putExtra("pass_send", sEdPass);
                startActivity(i);
            }
        }


    }
}
