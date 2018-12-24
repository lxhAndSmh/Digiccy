package com.botpy.digiccy.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.botpy.digiccy.R;
import com.botpy.digiccy.ui.sample.SampleActivity;
import com.botpy.digiccy.util.LanguageUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.main_tv)
    public void onClick() {
        Intent intent = new Intent(this, SampleActivity.class);
        startActivity(intent);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LanguageUtil.setLocale(newBase));
    }
}
