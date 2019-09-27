package almotech.co.androidtemplate.Activity.AdapterActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import almotech.co.androidtemplate.Adapter.AdapterClass;
import almotech.co.androidtemplate.R;

public class SimpleAdapterActivity extends AppCompatActivity {
    List<String> feed_item_list = new ArrayList<>();
    RecyclerView recyclerView;
    AdapterClass adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_string);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Simple Adapter");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_simple_adapter);
        feed_item_list.add("1");
        feed_item_list.add("1");
        feed_item_list.add("1");
        feed_item_list.add("1");
        feed_item_list.add("1");
        adapter = new AdapterClass(feed_item_list);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

