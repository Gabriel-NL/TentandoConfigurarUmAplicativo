package com.example.blocodenotasbasico;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;


public class Funcionador {
    private Context context;
    public SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    public List<String> notas= new ArrayList<>();
    public Integer notaselecionada;
    private static Funcionador INSTANCE= new Funcionador();



    public void Funciona(Context context) {
        this.context=context;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();

        notas.clear();
        int tamanho = preferences.getInt("TamanhoDoArray",0);//caralho, sera que isso se refere a posição? i de index?
        System.out.println("tamanho= "+tamanho);
        for (int i = 0; i<tamanho; i++){
            notas.add(preferences.getString("Status_"+i,null));
        }
    }//carregador feito!

    public void Salvar(String conteudo, String titulo){
        editor.putInt("TamanhoDoArray", notas.size());//tamanho do array definido!
        if (notas.size()<=notaselecionada){
            notas.add(conteudo);
            System.out.println("Adicionando...");
        }else{
            try{
                notas.set(notaselecionada,conteudo);
                System.out.println("Editando...");
            }catch (java.lang.IndexOutOfBoundsException IOOBE){
                notas.add("");
                notaselecionada=0;
                notas.set(notaselecionada,conteudo);
                System.out.println("Tentando novamente editar...");
            }
        }
        System.out.println(notas.toString());

        for(int i=0;i<notas.size();i++)
        {
            editor.remove("Status_" + i);
            editor.putString("Status_" + i, notas.get(i));
            //resumindo: Ele tira tudo o que tinha em cada chave, e atualiza os valores
        }
        editor.commit();
    }



    public String acessarNota(){
        try{
            return notas.get(notaselecionada);
        }catch (Exception e){
            return "escreva algo";
        }
    }

    public void getTitulos(){}

    public void apagarTudo(){
        editor.clear();
        notas.clear();
        editor.commit();
    }

    public void CriarNota(String c){
        notas.add(c);

        System.out.println("Total de notas: "+INSTANCE.getSize());
    }
    public void defineNota(Integer notaselecionada){
        this.notaselecionada=notaselecionada;
    }

    public Integer getNotaselecionada() {
        return this.notaselecionada;
    }

    public static Funcionador getFuncionador(){
        return INSTANCE;
    }

    public int getSize(){

        return this.notas.size();
    }

}
