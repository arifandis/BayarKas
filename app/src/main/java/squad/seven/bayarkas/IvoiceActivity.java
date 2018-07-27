package squad.seven.bayarkas;

import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IvoiceActivity extends AppCompatActivity {
    TextView mNamaBayar, mKodeBayar, mTanggal, mNominal;
    private String nama, kode, tanggal, nominal;
    TextView mTitleHeader;
    AppBarLayout mAppBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        setContentView(R.layout.activity_ivoice);

        mTitleHeader = findViewById(R.id.header);
        mAppBarLayout = findViewById(R.id.appBarID);
        mNamaBayar = findViewById(R.id.nama);
        mKodeBayar = findViewById(R.id.kode_pembayaran);
        mTanggal = findViewById(R.id.tanggal_bayar);
        mNominal = findViewById(R.id.total_bayar);

        //Set Header
        mTitleHeader.setText("Bayar Kas Apps");

        nama = getIntent().getStringExtra("nama");
        kode = getIntent().getStringExtra("kode");
        tanggal = getIntent().getStringExtra("tanggal");
        nominal = getIntent().getStringExtra("nominal");

        mNamaBayar.setText(nama);
        mKodeBayar.setText(kode);
        mTanggal.setText(tanggal);
        mNominal.setText(String.format("Rp.%s", nominal));

    }
}
