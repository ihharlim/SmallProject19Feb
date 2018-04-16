package com.example.win.smallproject19feb;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Toast;
import android.view.MenuInflater;
import android.view.Menu;
import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Delayed;

public class Sta extends AppCompatActivity {

    Context ctx;
    Toast ta;
    Intent itnb, itnc;
    Button butta, buttb, buttc;
    AlertDialog.Builder build;
    AlertDialog alert;
    Timer timee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sta);
        ctx = this;

        //create all stages
        itnb = (Intent) new Intent(this, stb.class);
        itnc = (Intent) new Intent(this, stc.class);

        //button a : photo page
        butta = (Button) findViewById(R.id.butta);
        butta.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                gotoPhoto();
            }
        });

        //button b : progress page
        buttb = (Button) findViewById(R.id.buttb);
        buttb.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                gotoProgress();
            }
        });
        //button c : exit the program
        buttc = (Button) findViewById(R.id.buttc);
        buttc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                exitTheProgram();
            }
        });
    }

    //create the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi){
        if (mi.getItemId() == R.id.menud) {
            exitTheProgram();
        }
        else if (mi.getItemId() == R.id.menub){
            gotoPhoto();
        }
        else if (mi.getItemId() == R.id.menuc){
            gotoProgress();
        }
        return super.onOptionsItemSelected(mi);
    }


    //module photo
    public void gotoPhoto(){
        startActivity(itnb);
    }
    //module progress
    public void gotoProgress(){
        startActivity(itnc);
    }
    //module exit
    public void exitTheProgram(){
        build = new AlertDialog.Builder(this);
        build.setMessage("Are you sure you want to exit?")
        .setCancelable(false)
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ta = Toast.makeText(ctx,"Exiting App...",Toast.LENGTH_LONG);
                        ta.setGravity(Gravity.CENTER,0,0);
                        ta.show();
                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                System.exit(0);
                            }
                        },2000);
                    }
                })
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ta = Toast.makeText(ctx,"Cancel",Toast.LENGTH_LONG);
                ta.setGravity(Gravity.CENTER,0,0);
                ta.show();
            }
        });
        alert = build.create();
                alert.setTitle("Exit Application");
                alert.show();
    }
}
