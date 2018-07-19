package squad.seven.bayarkas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuktiActivity extends AppCompatActivity {
    Button cetak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bukti);
        cetak = findViewById(R.id.cetak_bukti);

        cetak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuktiActivity.this,IvoiceActivity.class));
                finish();
            }
        });
    }
}
