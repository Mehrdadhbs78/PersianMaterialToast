package ir.mehrdadhbs.materialtoast;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mackhartley.roundedprogressbar.RoundedProgressBar;

import java.util.Timer;
import java.util.TimerTask;

import ir.mehrdadhbs.materialtoast.Classes.Persian;

class MaterialToastDialog extends Dialog {

    public Activity context;
    public Dialog dialog;

    TextView textTitle, textExplain;
    RoundedProgressBar progressBar;


    String Title, Text = "";
    int a = 0;
    int Toast_Type = 1;
    int ToastLenght = 40;


    public MaterialToastDialog(Activity a,String Title,String Text,int ToastType) {
        super(a);
        this.context = a;
        dialog = this;
        this.Title = Title;
        this.Text = Text;
        this.Toast_Type = ToastType;
    }
    public MaterialToastDialog(Activity a,String Title,String Text,int ToastType,int ToastLenght) {
        super(a);
        this.context = a;
        dialog = this;
        this.Title = Title;
        this.Text = Text;
        this.Toast_Type = ToastType;
        this.ToastLenght = ToastLenght;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Toast_Type == 1) {
            setContentView(R.layout.toastmaindialog);
        }else if(Toast_Type == 2){
            setContentView(R.layout.toastwarning);
        }else if (Toast_Type == 3){
            setContentView(R.layout.toasterror);
        }else if (Toast_Type == 4){
            setContentView(R.layout.toastinfo);
        }

        this.setCanceledOnTouchOutside(true);
        this.setCancelable(true);


        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.BOTTOM;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(wlp);

        textTitle = findViewById(R.id.textTitle);
        textExplain = findViewById(R.id.textExplain);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setRotation(180);


        AssetManager assets = context.getAssets();
        Typeface iranBold = Typeface.createFromAsset(assets,"fonts/iranBold.ttf");
        textTitle.setTypeface(iranBold);

        Typeface iran = Typeface.createFromAsset(assets,"fonts/iran.ttf");
        textExplain.setTypeface(iran);

        textTitle.setText(Persian.faDigit(Title));
        textExplain.setText(Persian.faDigit(Text));

        if(Title.equals("")){
            textTitle.setVisibility(View.GONE);
        }
        if(Text.equals("")){
            textExplain.setVisibility(View.GONE);
        }

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        a++;
                        progressBar.setProgressPercentage(a,false);
                        if(a == 100){
                            dialog.dismiss();
                            timer.cancel();
                            a = 0;
                        }
                    }
                });
            }
        }, 0, ToastLenght);

    }
}
