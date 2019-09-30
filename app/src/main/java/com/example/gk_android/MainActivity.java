package com.example.gk_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<NhanVien> arrNhanVien = null;
    MyArrayAdapter adapter = null;
    ListView lvNhanVien = null;
    Button btnNhap, btnXoa, btnChuyen;
    EditText txtMa, txtTen;
    RadioGroup genderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, SecondActivity.class);


        btnNhap = (Button)findViewById(R.id.nhapBTN);
        btnXoa = (Button)findViewById(R.id.xoaBTN);
        btnChuyen = (Button)findViewById(R.id.chuyenBTN);

        txtMa = (EditText)findViewById(R.id.maTXT);
        txtTen = (EditText)findViewById(R.id.tenTXT);
        genderGroup = (RadioGroup)findViewById(R.id.rdogr);

        lvNhanVien = (ListView)findViewById(R.id.nvLV);
        arrNhanVien = new ArrayList<NhanVien>();
        adapter = new MyArrayAdapter(this, R.layout.my_item_layout, arrNhanVien);
        lvNhanVien.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xulyNhap();

            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xulyXoa();

            }
        });

        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gioiTinh = "nam";
                String maNV = txtMa.getText() + "";
                String tenNV = txtTen.getText() + "";
                if(genderGroup.getCheckedRadioButtonId() == R.id.rdoNu)
                {
                    gioiTinh = "nu";
                }

                intent.putExtra("maNV", maNV);
                intent.putExtra("tenNV", tenNV);
                intent.putExtra("gioiTinh", gioiTinh);
                startActivity(intent);
            }
        });
    }
    public void xulyNhap()
    {
        String ma = txtMa.getText() + "";
        String ten = txtTen.getText() + "";
        boolean gioiTinh = false;
        if(genderGroup.getCheckedRadioButtonId() == R.id.rdoNu)
        {
            gioiTinh = true;
        }

        NhanVien nv = new NhanVien();
        nv.setID(ma);
        nv.setName(ten);
        nv.setGender(gioiTinh);

        arrNhanVien.add(nv);

        adapter.notifyDataSetChanged();

        txtMa.setText("");
        txtTen.setText("");
        txtMa.requestFocus();
    }

    public void xulyXoa()
    {
        for(int i = lvNhanVien.getChildCount() - 1; i >= 0; i--)
        {
            View v = lvNhanVien.getChildAt(i);
            CheckBox chk = (CheckBox)v.findViewById(R.id.cb_item);
            if(chk.isChecked())
            {
                arrNhanVien.remove(i);
            }

        }
        adapter.notifyDataSetChanged();
    }
}
