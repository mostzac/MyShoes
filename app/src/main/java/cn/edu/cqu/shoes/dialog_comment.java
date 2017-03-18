package cn.edu.cqu.shoes;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by RUNLAI on 2017/3/18.
 */

public class dialog_comment extends Dialog {
    public dialog_comment(Context context){
        super(context);
    }
    public dialog_comment(Context context,int theme){
         super(context,theme);
        }

    public static class Builder{
        private Context context;
        private String title;
        private String message;
        private String positiveButtonText;
        private String negativeButtonText;
        private View contentView;
        private DialogInterface.OnClickListener positiveButtonClickListener;
        private DialogInterface.OnClickListener negativeButtonClickListener;
        
        public Builder(Context context){
            this.context=context;
            }
        
        public Builder setMessage(String message){
            this.message=message;
            return this;
            }
        
        /**
         *SettheDialogmessagefromresource
         *
         *@paramtitle
         *@return
         */
        public Builder setMessage(int message){
            this.message=(String)context.getText(message);
            return this;
            }
        
        /**
         *SettheDialogtitlefromresource
         *
         *@paramtitle
         *@return
         */
        public Builder setTitle(int title){
            this.title=(String)context.getText(title);
            return this;
            }
        
        /**
         *SettheDialogtitlefromString
         *
         *@paramtitle
         *@return
         */
        
        public Builder setTitle(String title){
            this.title=title;
            return this;
            }
        
        public Builder setContentView(View v){
            this.contentView=v;
            return this;
            }
        
        /**
         *Setthepositivebuttonresourceandit'slistener
         *
         *@parampositiveButtonText
         *@return
         */
        public Builder setPositiveButton(int positiveButtonText,
        DialogInterface.OnClickListener listener){
            this.positiveButtonText=(String)context
            .getText(positiveButtonText);
            this.positiveButtonClickListener=listener;
            return this;
            }
        
        public Builder setPositiveButton(String positiveButtonText,
                DialogInterface.OnClickListener listener){
            this.positiveButtonText=positiveButtonText;
            this.positiveButtonClickListener=listener;
            return this;
            }
        
        public Builder setNegativeButton(int negativeButtonText,
        DialogInterface.OnClickListener listener){
            this.negativeButtonText=(String)context
            .getText(negativeButtonText);
            this.negativeButtonClickListener=listener;
            return this;
            }
        
        public Builder setNegativeButton(String negativeButtonText,
                DialogInterface.OnClickListener listener){
            this.negativeButtonText=negativeButtonText;
            this.negativeButtonClickListener=listener;
            return this;
            }
        
        public dialog_comment create(){
            TextView tv_title;
            EditText et_comment;
            ImageButton btnAdd;
            ImageButton btnCancle;
            LayoutInflater inflater=(LayoutInflater)context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //instantiatethedialogwiththecustomTheme
            final dialog_comment dialog=new dialog_comment(context);
            View layout=inflater.inflate(R.layout.dialog_comment,null);
            dialog.addContentView(layout,new LayoutParams(
                    LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
            //setthedialogtitle
            tv_title =(TextView)layout.findViewById(R.id.tv_comment);
            et_comment = (EditText) layout.findViewById(R.id.et_comment);
            btnAdd = (ImageButton) layout.findViewById(R.id.dialog_btnAdd);
            btnCancle = (ImageButton) layout.findViewById(R.id.dialog_btnCancal);
            //settheconfirmbutton
            if(positiveButtonText!=null){
                if(positiveButtonClickListener!=null){
                  btnAdd.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v){
                            positiveButtonClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                            }
                        });
                    }
                }else{
                //ifnoconfirmbuttonjustsetthevisibilitytoGONE
                btnAdd.setVisibility(View.GONE);
                }
            //setthecancelbutton
            if(negativeButtonText!=null){
                if(negativeButtonClickListener!=null){
                    btnCancle.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v){
                            negativeButtonClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                            }
                        });
                    }
                }else{
                //ifnoconfirmbuttonjustsetthevisibilitytoGONE
                btnCancle.setVisibility(View.GONE);
                }
            dialog.setContentView(layout);
            return dialog;
            }
        }

}

