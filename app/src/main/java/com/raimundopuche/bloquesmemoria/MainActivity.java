package com.raimundopuche.bloquesmemoria;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    private Button btn;
    private Button btn2;
    private Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btn = (Button)findViewById(R.id.princi);
        btn2= (Button)findViewById(R.id.inter);
        btn3= (Button)findViewById(R.id.avanza);

        btn.setBackgroundColor(Color.argb(100, 30, 108, 243));
        btn2.setBackgroundColor(Color.argb(100, 30, 108, 243));

        btn3.setBackgroundColor(Color.argb(100,30,108,243));




        btn.setOnClickListener(new View.OnClickListener() {

                                   @Override
                                   public void onClick(View v) {



                                       Intent intent = new Intent(MainActivity.this, principiante.class);
                                       intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                       intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                                       startActivity(intent);


                                   }

                               }

        );


        btn2.setOnClickListener(new View.OnClickListener()
                               {

                                   @Override
                                   public void onClick(View v) {

                                       Intent intent = new Intent(MainActivity.this, intermedio.class);
                                       intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                       intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                                       startActivity(intent);

                                   }

                               }

        );
        btn3.setOnClickListener(new View.OnClickListener()
                               {

                                   @Override
                                   public void onClick(View v) {

                                       Intent intent = new Intent(MainActivity.this, JuegoPrincipal.class);
                                       intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                       intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                                       startActivity(intent);



                                   }

                               }

        );












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
}
