package br.com.agostinho.sicredimobile.util;


import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import br.com.agostinho.sicredimobile.R;

/**
 * Created by breno on 21/02/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.include_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    public void setTitleToolbar(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.include_toolbar);

        if (toolbar != null) {
            if (!title.isEmpty())
                getSupportActionBar().setTitle(title);
        }
    }

    public void setDisplayHomeAsUpEnabled(boolean value){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(value);
        actionBar.setDisplayShowHomeEnabled(true);

        Toolbar toolbar = (Toolbar) findViewById(R.id.include_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}

