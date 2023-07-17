package com.kelompok1.aplikasitanamanhias.activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.kelompok1.aplikasitanamanhias.model.ModelMain;
import com.kelompok1.tanamanhias.R;

public class DBuah extends AppCompatActivity {

    public static final String DETAIL_BUNGA = "DETAIL_BUNGA";
    String strNamaBunga, strManfaatBunga, strBudidaya;
    ModelMain modelMain;
    Toolbar toolbar;
    ImageView imageBunga;
    TextView tvNamaBunga, tvManfaatBunga, tvBudidaya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbunga);

        //set transparent statusbar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        toolbar = findViewById(R.id.toolbar);
        imageBunga = findViewById(R.id.imageBunga);
        tvNamaBunga = findViewById(R.id.tvNamaBunga);
        tvManfaatBunga = findViewById(R.id.tvManfaatBunga);
        tvBudidaya = findViewById(R.id.tvBudidayaBunga);

        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //get data intent
        modelMain = (ModelMain) getIntent().getSerializableExtra(DETAIL_BUNGA);
        if (modelMain != null) {
            strNamaBunga = modelMain.getNama();
            strManfaatBunga = modelMain.getDeskripsi();
            strBudidaya = modelMain.getBudidaya();

            Glide.with(this)
                    .load(modelMain.getImage())
                    .into(imageBunga);

            tvNamaBunga.setText(strNamaBunga);
            tvManfaatBunga.setText(strManfaatBunga);
            tvBudidaya.setText(strBudidaya);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if (on) {
            layoutParams.flags |= bits;
        } else {
            layoutParams.flags &= ~bits;
        }
        window.setAttributes(layoutParams);
    }

}
