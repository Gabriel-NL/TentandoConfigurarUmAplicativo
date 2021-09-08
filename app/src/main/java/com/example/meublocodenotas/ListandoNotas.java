package com.example.meublocodenotas;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;


public class ListandoNotas extends AppCompatActivity{

    private GridView grade;
    private String[] notas;

    public void definirQuantidadeNotas(){
        notas[0]= "Paodebatata";



        grade = findViewById(R.id.lista_de_notas);
        grade.setNumColumns(notas.length);
        grade.addView();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        for (int i=0; i< notas.length; i++){

            Button botao= new Button(this);
        }


        /*preciso:
        * -permitir que acessem a pagina inicial do menu (feito)
        * -Permitir mostrar os elementos do array
        *-Permitir clicar em cada nota da lista
        * -Permitir editar cada nota da lista
        * */

    }
}
