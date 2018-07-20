package squad.seven.bayarkas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IvoiceActivity extends AppCompatActivity {
    TextView mNamaBayar, mKodeBayar, mTanggal, mNominal;
    private String nama, kode, tanggal, nominal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ivoice);

        mNamaBayar = findViewById(R.id.nama);
        mKodeBayar = findViewById(R.id.kode_pembayaran);
        mTanggal = findViewById(R.id.tanggal_bayar);
        mNominal = findViewById(R.id.total_bayar);

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
