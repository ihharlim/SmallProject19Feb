package com.example.win.smallproject19feb;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class stc extends AppCompatActivity {

    Toast ta;
    Intent itnb, itnc;
    Button butta, buttb, buttc;
    ProgressDialog pg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stc);
        //create all stages
        itnb = (Intent) new Intent(this, stb.class);
        itnc = (Intent) new Intent(this, stc.class);

        pg = (ProgressDialog) new ProgressDialog(this);
        pg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pg.setMessage("this is mock loading");
        pg.setIndeterminate(true);
        pg.setCancelable(true);

        butta = (Button) findViewById(R.id.buttd);
        butta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pg.show();
                pg.setProgress(50);
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
        System.exit(1);
    }
}
