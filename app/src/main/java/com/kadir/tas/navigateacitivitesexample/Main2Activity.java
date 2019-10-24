package com.kadir.tas.navigateacitivitesexample;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Deque;

import static com.kadir.tas.navigateacitivitesexample.MainActivity.State;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Deque<Intent> stack = DataHandler.getInstance().getStack();
                if(!State){
                    State = true;
                    Intent i = new Intent(Main2Activity.this, Main2Activity.class);
                    stack.push(i);
                }
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                stack.push(intent);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(State){
            State = false;
            if (DataHandler.getInstance().getStack().size() > 0){
                Intent intent0 = DataHandler.getInstance().getStack().pop();
                Intent intent = DataHandler.getInstance().getStack().pop();
                startActivity(intent);
                finish();
            }
        }else{
            if (DataHandler.getInstance().getStack().size() > 0){
                Intent intent = DataHandler.getInstance().getStack().pop();
                startActivity(intent);
                finish();
            }else finish();
        }
    }

}
