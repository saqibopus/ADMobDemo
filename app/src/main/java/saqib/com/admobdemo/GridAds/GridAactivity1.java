package saqib.com.admobdemo.GridAds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import saqib.com.admobdemo.R;

public class GridAactivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_aactivity1);

        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a GridLayoutManager with default vertical orientation and 3 number of columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView

        GridAdapter adapter = new GridAdapter(GridAactivity1.this, getList());
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<String> getList() {
        ArrayList<String> data = new ArrayList<>();
        data.add("one");
        data.add("two");
        data.add("three");
        data.add("four");
        return data;
    }
}
