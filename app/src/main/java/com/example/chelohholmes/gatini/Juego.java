package com.example.chelohholmes.gatini;

public class Juego
{
    public String[] tablero;
    public int jugador;

    public Juego()
    {
        tablero = new String[9];
    }

    public void Recargar(String b1, String b2, String b3, String b4, String b5, String b6, String b7, String b8, String b9)
    {
        tablero[0]=b1;
        tablero[1]=b2;
        tablero[2]=b3;
        tablero[3]=b4;
        tablero[4]=b5;
        tablero[5]=b6;
        tablero[6]=b7;
        tablero[7]=b8;
        tablero[8]=b9;
    }

    public boolean Escribir(int posicion)
    {
        if (tablero[posicion]!=null)
            return false;
        else
        {
            if (jugador==1)
                tablero[posicion]="X";
            else
                tablero[posicion]="O";
            return true;
        }
    }

    public boolean Full()
    {
        boolean lleno = true;
        for (int i=0;i<9;i++)
        {
            if (tablero[i]==null)
                lleno = false;
        }
        return lleno;
    }

    public int Fin()
    {
        String linea;
        String marcas;
        boolean fin = false;

        if (jugador==1)
            linea = "XXX";
        else
            linea = "OOO";

        marcas = tablero[0] + tablero[1] + tablero[2];
        if (marcas.equals(linea))
            fin = true;
        marcas = tablero[3] + tablero[4] + tablero[5];
        if (marcas.equals(linea))
            fin = true;
        marcas = tablero[6] + tablero[7] + tablero[8];
        if (marcas.equals(linea))
            fin = true;
        marcas = tablero[0] + tablero[3] + tablero[6];
        if (marcas.equals(linea))
            fin = true;
        marcas = tablero[1] + tablero[4] + tablero[7];
        if (marcas.equals(linea))
            fin = true;
        marcas = tablero[2] + tablero[5] + tablero[8];
        if (marcas.equals(linea))
            fin = true;
        marcas = tablero[0] + tablero[4] + tablero[8];
        if (marcas.equals(linea))
            fin = true;
        marcas = tablero[2] + tablero[4] + tablero[6];
        if (marcas.equals(linea))
            fin = true;

        if (fin==true)
        {
            for(int i=0;i<9;i++)
            {
                tablero[i]="-";
            }
            if(jugador == 1)
                return 1;
            else
                return 2;
        }
        else if (Full())
            return 3;
        else
            return 0;
    }

    public void Turn()
    {
        if (jugador == 1)
            jugador = 2;
        else
            jugador = 1 ;
    }
}