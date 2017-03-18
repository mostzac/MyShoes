package cn.edu.cqu.shoes;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by RUNLAI on 2017/3/14.
 */

public class fragment_user extends Fragment {
    Button btnMyReport;
    Button btnMyComment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        btnMyComment = (Button) view.findViewById(R.id.fguser_commentBtn);
        btnMyReport = (Button) view.findViewById(R.id.fguser_reportBtn);

        btnMyComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UserSelectActivity.class);
                //intent.putExtra("shoesImg",shoesimg);
                //intent.putExtra("ReportTitle",shoesimg);
                v.getContext().startActivity(intent);
            }
        });

        btnMyReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UserSelectActivity.class);
               // intent.putExtra("shoesImg",shoesimg);
                //intent.putExtra("ReportTitle",shoesimg);
                v.getContext().startActivity(intent);
            }
        });
        return view;
}

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // TextView tv = (TextView) getActivity().findViewById(R.id.textView3);
        //Bundle bundle = getArguments();
     //   if (bundle != null) {
      //      tv.setText(bundle.getString("ARGS"));
     //   }
    }

    public static fragment_user newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        fragment_user fragment = new fragment_user();
        fragment.setArguments(args);
        return fragment;
    }
}
