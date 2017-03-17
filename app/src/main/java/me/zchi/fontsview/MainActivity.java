package me.zchi.fontsview;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText mTextInput;
    private TextView mFontView;
    private Button mClearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFontView = (TextView) findViewById(R.id.font_view);
        mTextInput = (EditText) findViewById(R.id.text_input);
        mClearButton=(Button)findViewById(R.id.clear_input);
        AssetManager assets = getAssets();
        Typeface fromAsset = Typeface.createFromAsset(assets, "fonts/fzYingBiXingShu.ttf");
        mFontView.setTypeface(fromAsset);

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

        mTextInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Editable inputText=mTextInput.getText();
                String viewString=inputText.toString();
                if(inputText.length()>8){
                    viewString=viewString.substring(viewString.length()-8,viewString.length());
                }
                mFontView.setText(viewString);
            }
        });
        mClearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mTextInput.setText("");
            }
        });
    }
}
