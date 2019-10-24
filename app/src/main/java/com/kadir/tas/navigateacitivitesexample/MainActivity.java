package com.kadir.tas.navigateacitivitesexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayDeque;
import java.util.Deque;

public class MainActivity extends AppCompatActivity {

    static boolean State = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                    Intent i = new Intent(MainActivity.this, MainActivity.class);
                    stack.push(i);
                }
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                stack.push(intent);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
