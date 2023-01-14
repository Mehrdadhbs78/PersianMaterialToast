package ir.mehrdadhbs.materialtoast;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.CalendarContract;

public class MaterialToast {

    String Title = "";
    String Text = "";
    Activity context;
    public static int TOAST_SUCCESS = 1;
    public static int TOAST_WARNING = 2;
    public static int TOAST_ERROR = 3;
    public static int TOAST_INFO = 4;

    public static int LENGTH_LONG = 70;
    public static int LENGTH_SHORT = 20;

    public MaterialToast(Activity context){
       this.context = context;
    }

    public void setTitleText(String Text){
        this.Title = Text;
    }
    public void setMainText(String Text){
        this.Text = Text;
    }


    public void show(int ToastType){
        MaterialToastDialog cdd = new MaterialToastDialog(context,Title,Text,ToastType);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        cdd.show();
    }
    public void show(int ToastType, int ToastLength){
        MaterialToastDialog cdd = new MaterialToastDialog(context,Title,Text,ToastType,ToastLength);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        cdd.show();
    }
}