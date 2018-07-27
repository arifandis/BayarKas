package squad.seven.bayarkas;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BuktiActivity extends AppCompatActivity {
    Button cetak;
    private String nama, kode, tanggal, nominal;
    TextView mTitleHeader;
    AppBarLayout mAppBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);

        setContentView(R.layout.activity_bukti);

        mTitleHeader = findViewById(R.id.header);
        mAppBarLayout = findViewById(R.id.appBarID);
        cetak = findViewById(R.id.cetak_bukti);

        //Set Header
        mTitleHeader.setText("Bayar Kas Apps");

        nama = getIntent().getStringExtra("nama");
        kode = getIntent().getStringExtra("kode");
        tanggal = getIntent().getStringExtra("tanggal");
        nominal = getIntent().getStringExtra("nominal");

        cetak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IvoiceActivity.class);
                intent.putExtra("nama", nama);
                intent.putExtra("kode", kode);
                intent.putExtra("tanggal", tanggal);
                intent.putExtra("nominal", nominal);
                startActivity(intent);
                finish();
            }
        });
    }
}
