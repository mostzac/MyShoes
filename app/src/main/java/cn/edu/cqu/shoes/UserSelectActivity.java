package cn.edu.cqu.shoes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RUNLAI on 2017/3/17.
 */

public class UserSelectActivity extends AppCompatActivity {
    private List<String> shoesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);
        String[] theChoices = new String[]{
                "Albania","America", "Angola", "China","England", "India","Japan",  "Russia",
        };
        for(int i = 0;i<theChoices.length;i++){
            shoesList.add(theChoices[i]);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_user);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter adapter = new MyAdapter(shoesList);
        recyclerView.setAdapter(adapter);
    }
}
