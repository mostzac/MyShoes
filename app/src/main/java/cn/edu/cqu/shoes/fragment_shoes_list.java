package cn.edu.cqu.shoes;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Values.ShoesReport;

/**
 * Created by RUNLAI on 2017/3/14.
 */

public class fragment_shoes_list extends Fragment {
    private List<String> shoesreport = new ArrayList<>();//记录鉴定报告的表格
    SparseBooleanArray sp;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shoesreport.clear();
        String[] theChoices = new String[]{
                "Albania","America", "Angola", "China","England", "India","Japan",  "Russia",
        };
        for(int i = 0;i<theChoices.length;i++){
            shoesreport.add(theChoices[i]);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shoes_list, container, false);
         recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        //setRecyclerData();
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter adapter = new MyAdapter(shoesreport);
        recyclerView.setAdapter(adapter);
    }

   /* public void setRecyclerData()
    {
        String[] theChoices = new String[]{
                "Albania","America", "Angola", "China","England", "India","Japan",  "Russia",
        };
        for(int i = 0;i<theChoices.length;i++){
            shoesreport.add(theChoices[i]);
        }

        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter adapter = new MyAdapter(shoesreport);
        recyclerView.setAdapter(adapter);
    }*/

    public static fragment_shoes_list newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        fragment_shoes_list fragment = new fragment_shoes_list();
        fragment.setArguments(args);
        return fragment;
    }
}
