package me.zchi.fontsview;

import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Z on 2017/3/20.
 */

public class Texts {
    public void appStart(TextView mFontView){
        int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        String timeText;
        if (hours >= 5 && hours <= 11) {
            timeText = "早安";
        } else if (hours >= 11 && hours < 14) {
            timeText = "午安";
        } else if (hours >= 14 && hours < 19) {
            timeText = "下午好";
        } else if (hours >= 19 && hours < 21) {
            timeText = "晚上好";
        } else {
            timeText = "晚安";
        }
        String helloText = timeText + "，傻小喵";
        mFontView.setText(helloText);
    }
}
