package com.example.mylistview;

import android.graphics.drawable.Drawable;

public class ListItem {
    String word;
    String num;
    Drawable pic;
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
}