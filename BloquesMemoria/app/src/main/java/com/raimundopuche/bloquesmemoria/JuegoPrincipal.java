package com.raimundopuche.bloquesmemoria;

import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;


public class JuegoPrincipal extends ActionBarActivity {
    Button bloqueVisible;
    Button bloque1;
    Button bloque2;
    Button bloque3;
    Button bloque4;
    Button bloque5;
    Button bloque6;
    Button bloque7;
    Button bloque8;
    Button bloque9;
    Button bloque10;
    Button bloque11;
    Button bloque12;
    Button bloque13;
    Button bloque14;
    Button bloque15;
    Button bloque16;
    ArrayList<Button> listaBotones;
    ArrayList<String> listaValores;
    TextView etiquetaPuntos;
    int puntos = 0;
    int parejasEncontradas = 8;
    Timer timer;
    int bloquesSeleccionados = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_principal);
        cargarJuego();
    }

    private void cargarJuego() {
        etiquetaPuntos = (TextView)findViewById(R.id.puntos);
        bloque1 = (Button)findViewById(R.id.b11);
        bloque2 = (Button)findViewById(R.id.b12);
        bloque3 = (Button)findViewById(R.id.b13);
        bloque4 = (Button)findViewById(R.id.b14);
        bloque5 = (Button)findViewById(R.id.b21);
        bloque6 = (Button)findViewById(R.id.b22);
        bloque7 = (Button)findViewById(R.id.b23);
        bloque8 = (Button)findViewById(R.id.b24);
        bloque9 = (Button)findViewById(R.id.b31);
        bloque10 = (Button)findViewById(R.id.b32);
        bloque11 = (Button)findViewById(R.id.b33);
        bloque12 = (Button)findViewById(R.id.b34);
        bloque13 = (Button)findViewById(R.id.b41);
        bloque14 = (Button)findViewById(R.id.b42);
        bloque15 = (Button)findViewById(R.id.b43);
        bloque16 = (Button)findViewById(R.id.b44);
        listaBotones = new ArrayList<Button>();
        listaValores = new ArrayList<String>();
        listaBotones.add(bloque1);
        listaBotones.add(bloque2);
        listaBotones.add(bloque3);
        listaBotones.add(bloque4);
        listaBotones.add(bloque5);
        listaBotones.add(bloque6);
        listaBotones.add(bloque7);
        listaBotones.add(bloque8);
        listaBotones.add(bloque9);
        listaBotones.add(bloque10);
        listaBotones.add(bloque11);
        listaBotones.add(bloque12);
        listaBotones.add(bloque13);
        listaBotones.add(bloque14);
        listaBotones.add(bloque15);
        listaBotones.add(bloque16);
        listaValores.add("1");
        listaValores.add("2");
        listaValores.add("3");
        listaValores.add("4");
        listaValores.add("5");
        listaValores.add("6");
        listaValores.add("7");
        listaValores.add("8");
        listaValores.add("1");
        listaValores.add("2");
        listaValores.add("3");
        listaValores.add("4");
        listaValores.add("5");
        listaValores.add("6");
        listaValores.add("7");
        listaValores.add("8");
        Collections.shuffle(listaValores);
        for (int i = 0; i <= 15; i = i + 1){
            listaBotones.get(i).setTag(listaValores.get(i));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_juego_principal, menu);
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
    public void reinicio(View view){
        puntos = 0;
        etiquetaPuntos.setText("Puntos: " + puntos);
        for(int i = 0; i <= 15; i = i + 1){
            listaBotones.get(i).setText("");
            listaBotones.get(i).setEnabled(true);
        }
        cargarJuego();
        parejasEncontradas = 8;
        bloquesSeleccionados = 0;
        bloqueVisible = null;
    }
    public void historial(View view){

    }
    public void verificar(final View view){
        if(bloquesSeleccionados < 2){
            Button temp = (Button)view;
            temp.setText(temp.getTag().toString());
            if(bloqueVisible != null && bloqueVisible.getText().toString().compareTo(temp.getText().toString()) == 0 && bloqueVisible.getId() != temp.getId()){
                temp.setEnabled(false);
                temp.setText("O");
                temp = null;
                bloqueVisible.setEnabled(false);
                bloqueVisible.setText("O");
                bloqueVisible = null;
                parejasEncontradas = parejasEncontradas - 1;
                bloquesSeleccionados = 0;
                if(parejasEncontradas == 0){
                    LinearLayout lmain = (LinearLayout)findViewById(R.id.view);
                    LinearLayout lhistorial = (LinearLayout)findViewById(R.id.historial);
                    lmain.removeAllViews();
                }

                //Abrir otra ventana
            }else if(bloqueVisible == null){
                bloqueVisible = (Button)view;
                bloqueVisible.setText(bloqueVisible.getTag().toString());
                bloquesSeleccionados = bloquesSeleccionados + 1;
            }else{

                //Button temp = (Button)view;

                if(bloqueVisible.getId() != temp.getId()){
                    temp.setText(temp.getTag().toString());
                    bloquesSeleccionados = bloquesSeleccionados + 1;
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        int segundos = 0;
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    if (segundos <= 1) {
                                        segundos = segundos + 1;
                                    } else {
                                        bloquesSeleccionados = 0;
                                        Button temp = (Button)view;
                                        bloqueVisible.setText("");
                                        temp.setText("");
                                        temp = null;
                                        bloqueVisible = null;
                                        puntos = puntos + 50;
                                        etiquetaPuntos.setText("Puntos: " + puntos);
                                        timer.cancel();
                                    }
                                }
                            });

                        }
                    }, 0, 1000);
                }




            }
        }
    }
}
