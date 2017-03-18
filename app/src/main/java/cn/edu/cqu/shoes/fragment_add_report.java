package cn.edu.cqu.shoes;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by RUNLAI on 2017/3/14.
 */

public class fragment_add_report extends Fragment {
    EditText reportTitle;
    EditText shoesType;
    ImageView shoesPhoto;
    ImageButton btnOk;
    ImageButton btnCancle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_report, container, false);
        reportTitle = (EditText) view.findViewById(R.id.fgaddReport_et_title) ;
        shoesType = (EditText) view.findViewById(R.id.fgaddReport_et_shoestype);
        shoesPhoto = (ImageView) view.findViewById(R.id.fgaddReport_shoesPhoto);
        btnOk = (ImageButton) view.findViewById(R.id.fgaddReport_OkBtn) ;
        btnCancle = (ImageButton) view.findViewById(R.id.fgaddReport_CancleBtn);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("Please Select");
                dialog.setPositiveButton("Take Photo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),"Take Photo",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("Choose from Gallery", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),"Choose from Gallery",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),"Cancel",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clear the data
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // TextView tv = (TextView) getActivity().findViewById(R.id.fgaddReport_tv_title);
      //  Bundle bundle = getArguments();
      //  if (bundle != null) {
        //    tv.setText(bundle.getString("ARGS"));
      //  }
    }

    public static fragment_add_report newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        fragment_add_report fragment = new fragment_add_report();
        fragment.setArguments(args);
        return fragment;
    }


}
