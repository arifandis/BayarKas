package squad.seven.bayarkas;

import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import squad.seven.bayarkas.Fragment.FragmentRekap;
import squad.seven.bayarkas.Fragment.FragmentSettings;
import squad.seven.bayarkas.Fragment.FragmentTambahKas;
import squad.seven.bayarkas.Fragment.ViewHistoryFragment;

public class HomeActivity extends AppCompatActivity {
    AppBarLayout mAppBarLayout;
    Button mHomeBtn,mRekapBtn,mSettingBtn,mTambahBtn;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAppBarLayout = findViewById(R.id.appBarID);
        mHomeBtn = findViewById(R.id.home);
        mRekapBtn = findViewById(R.id.rekap);
        mSettingBtn = findViewById(R.id.setting);
        mTambahBtn = findViewById(R.id.button_tambah);

        toViewContent();

        mTambahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toViewTambahKas();
            }
        });

        mSettingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toViewSetting();
            }
        });

        mRekapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toViewRekap();
            }
        });

    }

    void toViewContent(){
        fragment = new ViewHistoryFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_view,fragment);
        transaction.commit();
    }

    void toViewSetting() {
        fragment = new FragmentSettings();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_view, fragment);
        transaction.commit();
    }

    void toViewTambahKas() {
        fragment = new FragmentTambahKas();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_view, fragment);
        transaction.commit();
    }

    void toViewRekap() {
        fragment = new FragmentRekap();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_view, fragment);
        transaction.commit();
    }
}
