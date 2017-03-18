package cn.edu.cqu.shoes;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by RUNLAI on 2017/3/16.
 */

public class ReportActivity extends AppCompatActivity {
    TextView reportTitle;
    TextView shoesName;
    TextView shoesType;
    Button btnBack;
    Button btnComment;
    ListView listComment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        reportTitle = (TextView) findViewById(R.id.activity_report_tvtitle);
        shoesName = (TextView) findViewById(R.id.activity_report_tvname);
        shoesType = (TextView) findViewById(R.id.activity_report_tvtype);
        btnBack = (Button) findViewById(R.id.activity_report_btnBack);
        btnComment = (Button) findViewById(R.id.activity_report_btnComment);
        listComment = (ListView) findViewById(R.id.activity_report_listView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String shoesImg = extras.getString("shoesImg");
            String ReportTitle = extras.getString("ReportTitle");
            reportTitle.setText(ReportTitle);
            shoesName.setText(shoesImg);
        }

        btnComment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //LayoutInflater inflater = getLayoutInflater();
                //View layout = inflater.inflate(R.layout.dialog_comment, (ViewGroup) findViewById(R.id.dialog));
                dialog_comment.Builder builder = new dialog_comment.Builder(ReportActivity.this);
                builder.setPositiveButton("null",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        Toast.makeText(getBaseContext(),"Add",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("null",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        Toast.makeText(getBaseContext(),"Cancel",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }

        });
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
