package com.example.blocodenotasbasico;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;


public class Funcionador {
    private Context context;
    public SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private String tda ="TamanhoDoArray";
    private String tdat="TamanhoDoArrayTitulos";
    private String ContentS="Status_";
    private String ContentT="Titulos_";
    public Integer notaSelecionada;
    public List<String> titulos= new ArrayList<>();
    public List<String> notas= new ArrayList<>();
    private static Funcionador INSTANCE= new Funcionador();


    public void Funciona(Context context) {
        this.context=context;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        System.out.println("notas size: "+getSize());

        notas.clear();
        titulos.clear();
        //secao para conteudo
        int tamanho = preferences.getInt(tda,0);
        for (int i = 0; i<tamanho; i++){
            notas.add(preferences.getString(ContentS+i,null));
        }
        //secao para titulos
        int tamanhoT = preferences.getInt(tdat,0);
        for (int i = 0; i<tamanhoT; i++){
            titulos.add(preferences.getString(ContentT+i,null));
        }
    }

    public void SalvarConteudo(String conteudo){
        editor.putInt(tda, notas.size());//tamanho do array de conteudo definido

            try{
                notas.set(notaSelecionada,conteudo);
                System.out.println("Editando...");
            }catch (java.lang.IndexOutOfBoundsException IOOBE){
                notas.add("");
                notaSelecionada =0;
                notas.set(notaSelecionada,conteudo);
            }
        //System.out.println(notas.toString());
        if (notas.get(0)!=null) {
            for(int i=0;i<notas.size();i++)
            {
                editor.remove(ContentS + i);
                editor.putString(ContentS + i, notas.get(i));
            }
        }
        editor.commit();
    }
    public void SalvarTitulos(String titulo){
        editor.putInt(tdat,titulos.size());//tamanho do array de titulos definido
        try{
            titulos.set(notaSelecionada,titulo);
            System.out.println("Editando...");
        }catch (java.lang.IndexOutOfBoundsException IOOBE){
            titulos.add("Sem titulo");
            notaSelecionada =0;
            titulos.set(notaSelecionada,titulo);
            System.out.println("Tentando novamente editar...");
        }

        if (titulos.get(0)!=null) {
            for(int i=0;i<titulos.size();i++)
            {
                editor.remove(ContentT + i);
                editor.putString(ContentT + i, titulos.get(i));
            }
        }
        editor.commit();
    }

    public String acessarNota(){
        try{
            System.out.println("Acessar nota Ativado");
            if (notaSelecionada ==null){
                throw  new Exception("error");
            }
            return preferences.getString(ContentS+ notaSelecionada,null);
        }catch (Exception e){
            return "escreva algo";
        }
    }

    public String acessarTitulos(){
        try{
            System.out.println("Acessar titulo Ativado");
            return preferences.getString(ContentT+ notaSelecionada,null);
        }catch (Exception e){
            return "Sem titulo";
        }
    }

    public void apagarTudo(){
        editor.clear();
        notas.clear();
        titulos.clear();
        editor.commit();
    }

    public void CriarNota(String c, String t){
        System.out.println("conteudo: " + ContentS+notas.size());


        editor.putString(ContentT+titulos.size(),t);
        editor.putInt(tdat,preferences.getInt(tdat,0)+1);

        editor.putString(ContentS+notas.size(),c);
        editor.putInt(tda,preferences.getInt(tda, 0)+1);

        editor.commit();

        System.out.println("nya: "+notas.toString());
    }

    public void setNotaSelecionada(Integer notaselecionada){
        this.notaSelecionada =notaselecionada;
    }

    public Integer getNotaSelecionada() {
        return this.notaSelecionada;
    }

    public static Funcionador getFuncionador(){
        return INSTANCE;
    }

    public int getSize(){return this.notas.size();}

    public String getTitulo(int n){
            try{
            return preferences.getString(ContentT+n,null);
            }catch (java.lang.IndexOutOfBoundsException IOOBE){
            return "Sem titulo";
            }
        }
}
