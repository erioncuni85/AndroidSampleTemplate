package almotech.co.androidtemplate.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import almotech.co.androidtemplate.Activity.AdapterActivities.AdapterMainActivity;
import almotech.co.androidtemplate.Activity.LoginActivities.LoginActivity;
import almotech.co.androidtemplate.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoLightNoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.adapter_card:
                Intent intent  = new Intent(MainActivity.this, AdapterMainActivity.class);
                startActivity(intent);
                break;
            case R.id.mvp_card:


                break;
            case R.id.login_class_card:
                Intent intent1  = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.google_map_card:


                break;
            case R.id.realm_database_card:


                break;
            case R.id.api_card:


                break;
        }

    }
}
