package com.example.blocodenotasbasico;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Funcionador {
    private Context contextoLages;
    private SharedPreferences preferenciasLages;
    private final String NOME_DO_ARQUIVO ="anotacao";
    private SharedPreferences.Editor editorLages;

    public List<String> notas= new ArrayList<>();
    public Set<String> setando = new HashSet<String>();
    public Integer notaselecionada;
    private static Funcionador INSTANCE= new Funcionador();



    public void Funciona(Context context) {

        this.contextoLages=context;                                                   //O contexto que a funcao receber, entra aqui e é definido
        preferenciasLages = contextoLages.getSharedPreferences( NOME_DO_ARQUIVO,0);//a variavel preferences se torna o sharedPreferences do contexto
        editorLages = preferenciasLages.edit();                                      //cria o editor
        System.out.println("Contexto "+ notaselecionada);
    }
    public void Salvar(Integer num, String conteudo){
        if (notas.isEmpty() == true ){
            notas.add(conteudo);
        }else{
        notas.set(num,conteudo);
        }

        setando.addAll(notas);
        editorLages.putStringSet("key", setando);
        //editorLages.putString(notas.get(num),conteudo);//Bota o conteudo na chave, preciso pegar o contexto do ngc, e armazenar no lugar certo
        editorLages.commit();//salva as alterações no preferences
        notas.clear();
        notas.addAll(setando);
        //notas= (List<String>) preferenciasLages.getAll();

    }





    //get
    public String acessarNota(){
        notas.add("frase 1");
        notas.add("Frase 2");
        notas.add("frase 3");

        //System.out.println("Acessar nota" + notaselecionada.toString());
        //return preferenciasLages.getString(selNote,"");
        try{

            System.out.println("Acessar nota" + notaselecionada.toString());
            String s = notas.get(notaselecionada);
            return s;
        }catch (Exception e){
            return "nulo  :"+  notaselecionada ;
        }

    }


    //set
    public void defineNota(Integer notaselecionada){

        this.notaselecionada=notaselecionada;
        //System.out.println(i);
        System.out.println("definir nota "+this.notaselecionada);


    }

    public Integer getNotaselecionada() {
        return this.notaselecionada;
    }

    public static Funcionador getFuncionador(){
        return INSTANCE;
    }

    public int getSize(){
        return notas.size();
    }
}
