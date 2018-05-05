package squad.seven.bayarkas;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TambahKasActivity extends AppCompatActivity {
    AppBarLayout mAppBarLayout;
    Button mHomeBtn,mRekapBtn,mSettingBtn,mSimpanBtn,mBatalBtn;
    EditText mNamaTxt,mKodeBayarTxt,mPenerimaTxt,mNominalBayarTxt,mTglBayarTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kas);

        mAppBarLayout = findViewById(R.id.appBarID);
        mHomeBtn = findViewById(R.id.home);
        mRekapBtn = findViewById(R.id.rekap);
        mSettingBtn = findViewById(R.id.setting);
        mSimpanBtn = findViewById(R.id.simpan);
        mBatalBtn = findViewById(R.id.batal);
        mNamaTxt = findViewById(R.id.nama);
        mKodeBayarTxt = findViewById(R.id.kode_pembayaran);
        mPenerimaTxt = findViewById(R.id.penerima_id);
        mNominalBayarTxt = findViewById(R.id.nominal_bayar);
        mTglBayarTxt = findViewById(R.id.tanggal_bayar);

        mSimpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mBatalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void simpanDataKas(){
        String nama = mNamaTxt.getText().toString();
        String kodeBayar = mKodeBayarTxt.getText().toString();
        String penerima = mPenerimaTxt.getText().toString();
        String nominalBayar = mNominalBayarTxt.getText().toString();
        String tglBayar = mTglBayarTxt.getText().toString();
    }
}
