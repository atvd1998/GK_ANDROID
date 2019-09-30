package com.example.gk_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private String maNV, tenNV, gioiTinh;
    private EditText maTB, tenTB, gtTB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = this.getIntent();

        maNV = intent.getStringExtra("maNV");
        tenNV = intent.getStringExtra("tenNV");
        gioiTinh = intent.getStringExtra("gioiTinh");

        maTB = (EditText)findViewById(R.id.maTXT);
        tenTB = (EditText)findViewById(R.id.tenTXT);
        gtTB = (EditText)findViewById(R.id.gioitinhTXT);

        maTB.setText(maNV);
        tenTB.setText(tenNV);
        gtTB.setText(gioiTinh);



    }
}
