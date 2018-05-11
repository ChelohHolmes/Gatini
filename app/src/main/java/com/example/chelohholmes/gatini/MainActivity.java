package com.example.chelohholmes.gatini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, nuevo;
    TextView nJug, ganador;
    int jug = 1;
    String bo1 = null, bo2 = null, bo3 = null, bo4 = null, bo5 = null, bo6 = null, bo7 = null, bo8 = null, bo9 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uno = (Button) findViewById(R.id.b1x1);
        dos = (Button) findViewById(R.id.b1x2);
        tres = (Button) findViewById(R.id.b1x3);
        cuatro = (Button) findViewById(R.id.b2x1);
        cinco = (Button) findViewById(R.id.b2x2);
        seis = (Button) findViewById(R.id.b2x3);
        siete = (Button) findViewById(R.id.b3x1);
        ocho = (Button) findViewById(R.id.b3x2);
        nueve = (Button) findViewById(R.id.b3x3);
        nuevo = (Button) findViewById(R.id.Nuevo);
        ImageView nJug = (ImageView) findViewById(R.id.nJug);
        ganador = (TextView) findViewById(R.id.Ganador);
    }

    public void Turno(View v)
    {
        Button b = (Button) findViewById(v.getId());
        int index = Integer.parseInt(b.getTag().toString());
        Movimiento(index, b);
    }

    private void Movimiento(int posicion, Button casilla)
    {
        Juego gato = new Juego();
        gato.jugador=jug;
        gato.Recargar(bo1, bo2, bo3, bo4, bo5, bo6, bo7, bo8, bo9);

        if(!gato.Escribir(posicion))
            return;

        if (gato.jugador==1)
            casilla.setText("X");
        else if (gato.jugador==2)
            casilla.setText("O");

        int estado = gato.Fin();
        if (estado!=0)
        {
            switch (estado)
            {
                case 1:
                    ganador.setText("Jugador [X] ha ganado");
                    break;
                case 2:
                    ganador.setText("Jugador [O] ha ganado");
                    break;
                case 3:
                    ganador.setText("EMPATE");
                    break;
            }
        }
        else
        {
            gato.Turn();
            if (gato.jugador == 2)
                nJug.setImageResource(R.drawable.ic_clear_white_30dp);
            else if (gato.jugador == 1)
                nJug.setImageResource(R.drawable.ic_panorama_fish_eye_white_30dp);
        }
        jug=gato.jugador;
        bo1=gato.tablero[0];
        bo2=gato.tablero[1];
        bo3=gato.tablero[2];
        bo4=gato.tablero[3];
        bo5=gato.tablero[4];
        bo6=gato.tablero[5];
        bo7=gato.tablero[6];
        bo8=gato.tablero[7];
        bo9=gato.tablero[8];
    }

    public void Salir (View v)
    {
        System.exit(0);
    }

    public void Reiniciar (View v)
    {
        uno.setText(" ");
        dos.setText(" ");
        tres.setText(" ");
        cuatro.setText(" ");
        cinco.setText(" ");
        seis.setText(" ");
        siete.setText(" ");
        ocho.setText(" ");
        nueve.setText(" ");
        nJug.setImageResource(R.drawable.ic_panorama_fish_eye_white_30dp);
        ganador.setText(" ");
        bo1=null;
        bo2=null;
        bo3=null;
        bo4=null;
        bo5=null;
        bo6=null;
        bo7=null;
        bo8=null;
        bo9=null;
        jug=1;
    }
}