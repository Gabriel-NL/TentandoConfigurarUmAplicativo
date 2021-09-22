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
    }

    public void Salvar(Integer num, String conteudo){
        if (notas.size()==1 ){
            notas.add(conteudo);
            System.out.println("Não tinha nada aqui, preenchendo...");// se não tem valor valido, vai adicionar

        }else{

            if (num==null){
                num=10;
                notas.add("a adicionar");
            }

            if (notas.size()>=num){
                notas.set(num,conteudo);
                System.out.println("Achei o valor! inserindo ("+ conteudo +") no espaço "+ num);//existe o valor valido, altera existente

            }else{
                notas.add(conteudo);
                System.out.println("o array esta vazio, preenchendo...");//
            }
        }

        setando.clear();
        setando.addAll(notas);
        editorLages.putStringSet("key", setando);
        editorLages.commit();
        notas.clear();
        notas.addAll(setando);
    }

    public String acessarNota(){
        try{
            String s = notas.get(notaselecionada);
            return s;
        }catch (Exception e){
            return "escreva algo";
        }
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
        return notas.size();
    }
}
