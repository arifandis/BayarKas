package squad.seven.bayarkas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuktiActivity extends AppCompatActivity {
    Button cetak;
    private String nama, kode, tanggal, nominal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bukti);
        cetak = findViewById(R.id.cetak_bukti);

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
