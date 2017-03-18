package cn.edu.cqu.shoes;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by RUNLAI on 2017/3/14.
 */

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.ViewHolder>{
    private List<String> mShoesList;
    static class ViewHolder extends  RecyclerView.ViewHolder {
        View shoesReportView;
        TextView shoesImg;
        TextView reportTitle;

        public ViewHolder(View view) {
            super(view);
            shoesReportView = view;
            shoesImg = (TextView) view.findViewById(R.id.shoes_img);
            reportTitle = (TextView) view.findViewById(R.id.report_title);
        }
    }
    public MyAdapter(List<String> shoesList){
        mShoesList = shoesList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_shoes_report,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.shoesReportView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String  shoesimg = "ShoesImg";
                String  reporttitle = "ReportTitle";
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(v.getContext(), ReportActivity.class);
                intent.putExtra("shoesImg",shoesimg);
                intent.putExtra("ReportTitle",shoesimg);
                v.getContext().startActivity(intent);
                //String shoesreport = mShoesList.get(position);
                //Toast.makeText(v.getContext(),"you click view"+shoesreport,Toast.LENGTH_SHORT).show();
            }

        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        String str = mShoesList.get(position);
        holder.shoesImg.setText(str);
        holder.reportTitle.setText(str);
    }

    @Override
    public int getItemCount(){
        return mShoesList.size();
    }
}
