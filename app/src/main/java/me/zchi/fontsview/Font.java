package me.zchi.fontsview;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Z on 2017/3/18.
 */

public class Font {
    private String[] mFontList;
    private int mFontIndex;
    private Context mMainContext;

    public Context getMainContext() {
        return mMainContext;
    }

    public void setMainContext(Context mainContext) {
        mMainContext = mainContext;
    }

    public String[] getFontList() {
        return mFontList;
    }

    public void setFontList(String[] fontList) {
        mFontList = fontList;
    }

    public int getFontIndex() {
        return mFontIndex;
    }

    public void setFontIndex(int fontIndex) {
        mFontIndex = fontIndex;
    }

    public Font(int fontIndex, String[] fontList, Context mainContext){
        mFontIndex=fontIndex;
        mFontList=fontList;
        mMainContext=mainContext;

    }

    public void applyFont(int fontIndex, TextView textView){
        mFontIndex=fontIndex;
        AssetManager assets = mMainContext.getAssets();
        Typeface fromAsset = Typeface.createFromAsset(assets, "fonts/"+mFontList[mFontIndex]);
        textView.setTypeface(fromAsset);
    }



}
