package me.zchi.fontsview;

import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText mTextInput;
    private TextView mFontView;
    private Button mClearButton;
    private Button mFontSelectButton;
    private Button mColorSelectButton;
    private Font font = new Font(0, new String[]{"TianYingZhangXingShu.ttf", "fzYingBiXingShu.ttf","WangJinYanXingShu.ttf","ChangChengZhongXingShu.ttf"},MainActivity.this);
    private String mFontName;
//    private Texts texts=new Texts(TextView mFontView);

    //TODO 更换字体颜色功能
    //TODO 字体导入
    //TODO 根据数量自动调节字体大小
    //TODO 内置诗词库

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFontView = (TextView) findViewById(R.id.font_view);
        mTextInput = (EditText) findViewById(R.id.text_input);
        mClearButton = (Button) findViewById(R.id.clear_input);
        mFontSelectButton = (Button) findViewById(R.id.select_font);
        mColorSelectButton=(Button)findViewById(R.id.select_color);

//        AssetManager assets = getAssets();
//        Typeface fromAsset = Typeface.createFromAsset(assets, "fonts/TianYingZhangXingShu.ttf");
//        textView.setTypeface(fromAsset);

//        int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
//        String timeText;
//        if (hours >= 5 && hours <= 11) {
//            timeText = "早安";
//        } else if (hours >= 11 && hours < 14) {
//            timeText = "午安";
//        } else if (hours >= 14 && hours < 19) {
//            timeText = "下午好";
//        } else if (hours >= 19 && hours < 21) {
//            timeText = "晚上好";
//        } else {
//            timeText = "晚安";
//        }
//        String helloText = timeText + "，傻小喵";
//        mFontView.setText(helloText);
        font.applyFont(font.getFontIndex(),mFontView);
        mTextInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Editable inputText = mTextInput.getText();
                String viewString = inputText.toString();
                if (inputText.length() > 8) {
                    viewString = viewString.substring(viewString.length() - 8, viewString.length());
                }
                mFontView.setText(viewString);
            }
        });

        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextInput.setText("");
            }
        });

        mFontSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChooseDialog(v);
            }
        });
        mColorSelectButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
    }

    private void showChooseDialog(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.font_select);
        final String[] fontList = font.getFontList();
        builder.setSingleChoiceItems(fontList, font.getFontIndex(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "You Click" + fontList[i], Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
                mFontName = fontList[i];
                font.applyFont(i,mFontView);
            }
        });
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void showColorChooseDialog(View v){

    }
}
