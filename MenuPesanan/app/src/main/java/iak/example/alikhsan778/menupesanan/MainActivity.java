package iak.example.alikhsan778.menupesanan;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText mNamaPelanggan;
    CheckBox mCheckWhippedCream, mCheckChocolatos;
    TextView mQuantity, mHarga, mDetailOrder;
    int n = 0, nHarga;
    String sNamaPelanggan, sToppingChoices;
    ProgressBar mProgresBar;
    private final int mDisplayLength = 7000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuantity = (TextView) findViewById(R.id.tv_quantity);
        mHarga = (TextView) findViewById(R.id.sumary_order);
        mDetailOrder = (TextView) findViewById(R.id.tv_detail_order);
        mCheckWhippedCream = (CheckBox) findViewById(R.id.cb_topingwcrm);
        mCheckChocolatos = (CheckBox) findViewById(R.id.cb_topingchoco);

    }

    public void btnMinusAction(View view) {
        if (n <= 0) {
            n = 0;
            mQuantity.setText(String.valueOf(n));
            mQuantity.setTextColor(getResources().getColor(R.color.colorBlack));
            mActionBuy(n);
        } else if (n > 0) {
            n--;
            mQuantity.setText(String.valueOf(n));
            mQuantity.setTextColor(getResources().getColor(R.color.colorGreen));
            mActionBuy(n);
            if (n == 0) {
                mQuantity.setText(String.valueOf(n));
                mQuantity.setTextColor(getResources().getColor(R.color.colorBlack));
                mActionBuy(n);
            }
        }
    }

    public void btnPlusAction(View view) {
        if (n < 10) {
            n++;
            mQuantity.setText(String.valueOf(n));
            mActionBuy(n);
        } else if (n > 10) {
            n = 10;
            mQuantity.setText(String.valueOf(n));
            mActionBuy(n);
        }
        mQuantity.setTextColor(getResources().getColor(R.color.colorGreen));
    }

    public void btnSubmitOrder(View view) {
        boolean mValidasi = true;
        mNamaPelanggan = (EditText) findViewById(R.id.ed_nama);

        mProgresBar = (ProgressBar) findViewById(R.id.progressBar);

        if (TextUtils.isEmpty(mNamaPelanggan.getText().toString())) {
            mValidasi = false;
            mNamaPelanggan.setError("Required");
        }
        if (mValidasi) {
            mProgresBar.setVisibility(View.VISIBLE);
            sNamaPelanggan = mNamaPelanggan.getText().toString();

            mSummaryOrrder();
            Handler mHandler = new Handler();
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(Intent.ACTION_SENDTO);
                    i.setData(Uri.parse("mailto: " + sNamaPelanggan));
                    i.putExtra(Intent.EXTRA_SUBJECT, "Order Kopi Topinngs");
                    i.putExtra(Intent.EXTRA_TEXT, mSummaryOrrder());
                    if (i.resolveActivity(getPackageManager()) != null) {
                        startActivity(i);
                    }
                }
            }, mDisplayLength);

        }
    }

    public String mSummaryOrrder() {
        String sSummaryOrder = "-----------------Order Past-------------------- ";
        sSummaryOrder += "\nNama Pelanggan    : " + sNamaPelanggan;
        sSummaryOrder += "\nTopping\t\t\t\t: " + sToppingChoices;
        sSummaryOrder += "\nPrices\t\t\t\t: " + nHarga;
        mDetailOrder.setText(sSummaryOrder);
        return sSummaryOrder;
    }

    public void mActionBuy(int mBuy) {
        if (mCheckWhippedCream.isChecked()) {
            nHarga = mBuy * 10;
            mHarga.setText("$ " + String.valueOf(nHarga));

            sToppingChoices = mCheckWhippedCream.getText().toString();
        } else if (mCheckChocolatos.isChecked()) {
            nHarga = mBuy * 5;
            mHarga.setText("$ " + String.valueOf(nHarga));
            sToppingChoices = mCheckChocolatos.getText().toString();
        }
        if (mCheckWhippedCream.isChecked() && mCheckChocolatos.isChecked()) {
            nHarga += mBuy * 15;
            mHarga.setText("$ " + String.valueOf(nHarga));
            sToppingChoices = mCheckWhippedCream.getText().toString() + "\n\t\t\t\t\t\t   " + mCheckChocolatos.getText().toString();
        }
        mHarga.setTextColor(getResources().getColor(R.color.colorGreen));
        if (mHarga.getText().toString().equals("$ 0")) {
            mHarga.setTextColor(getResources().getColor(R.color.colorGray));
        }
    }

}
