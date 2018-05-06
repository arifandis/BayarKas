package squad.seven.bayarkas;

import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import squad.seven.bayarkas.Fragment.FragmentRekap;
import squad.seven.bayarkas.Fragment.FragmentSettings;
import squad.seven.bayarkas.Fragment.FragmentTambahKas;
import squad.seven.bayarkas.Fragment.ViewHistoryFragment;

public class HomeActivity extends AppCompatActivity {
    TextView mTitleHeader;
    AppBarLayout mAppBarLayout;
    Button mHomeBtn,mRekapBtn,mSettingBtn;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTitleHeader = findViewById(R.id.header);
        mAppBarLayout = findViewById(R.id.appBarID);
        mHomeBtn = findViewById(R.id.home);
        mRekapBtn = findViewById(R.id.rekap);
        mSettingBtn = findViewById(R.id.setting);

        firstFragment();

        mHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFragment(R.id.home);
            }
        });
        mSettingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFragment(R.id.setting);
            }
        });
        mRekapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFragment(R.id.rekap);
            }
        });

    }

    void firstFragment(){
        Fragment fragment = new ViewHistoryFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_view,fragment);
        transaction.commit();
        mTitleHeader.setText("Bayar Kas Apps");
    }

    void moveToFragment(int id){
        Fragment fragment=null;
        switch (id){
            case R.id.home:
                fragment = new ViewHistoryFragment();
                mTitleHeader.setText("Bayar Kas Apps");
                break;
            case R.id.rekap:
                fragment = new FragmentRekap();
                mTitleHeader.setText("Rekapitulasi");
                break;
            case R.id.setting:
                fragment = new FragmentSettings();
                mTitleHeader.setText("Setting");
                break;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_view,fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        count++;
        switch (count){
            case 1:
                Toast.makeText(this, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                finish();
                break;
        }
    }
}
