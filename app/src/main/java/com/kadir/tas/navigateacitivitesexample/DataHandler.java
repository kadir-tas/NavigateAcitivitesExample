package com.kadir.tas.navigateacitivitesexample;

import android.content.Intent;

import java.util.ArrayDeque;
import java.util.Deque;

public class DataHandler {
    private static DataHandler mDataHandler;
    private Deque<Intent> stack = new ArrayDeque<>();

    private DataHandler() {
    }

    public static DataHandler getInstance(){
        if(mDataHandler == null){
            mDataHandler = new DataHandler();
        }
        return mDataHandler;
    }

    public Deque<Intent> getStack() {
        return stack;
    }

    public void setStack(Deque<Intent> stack) {
        this.stack = stack;
    }
}