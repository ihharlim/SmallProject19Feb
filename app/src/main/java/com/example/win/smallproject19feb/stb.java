package com.example.win.smallproject19feb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class stb extends AppCompatActivity {

    ImageView iv;
    Toast ta;
    Intent itnb, itnc;
    Button butta, buttb, buttc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stb);
        //create all stages
        itnc = (Intent) new Intent(this, stc.class);
        itnb = (Intent) new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        iv = (ImageView) findViewById(R.id.iva);
        butta = (Button) findViewById(R.id.butte);
        butta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(itnb,0);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bm = (Bitmap) data.getExtras().get("data");
        iv.setImageBitmap(bm);
    }

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
        System.exit(0);
    }
}
