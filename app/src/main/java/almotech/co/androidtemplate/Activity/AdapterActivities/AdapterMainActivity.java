package almotech.co.androidtemplate.Activity.AdapterActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import almotech.co.androidtemplate.R;

public class AdapterMainActivity extends AppCompatActivity implements View.OnClickListener{
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        setTheme(R.style.AppThemeNoLightNoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.adapter_single:
                intent = new Intent(AdapterMainActivity.this, SimpleAdapterActivity.class);
                startActivity(intent);
                break;
            case R.id.adapter_custom_model:
                break;
            case R.id.adapter_dialog:
                break;
            case R.id.adapter_inside_dapter:
                break;

        }
    }
}
