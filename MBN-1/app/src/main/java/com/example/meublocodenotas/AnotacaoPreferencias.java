package com.example.meublocodenotas;

import android.content.Context;
import android.content.SharedPreferences;


public class AnotacaoPreferencias {

    private Context context;
    private SharedPreferences preferences;
    private final String NOME_ARQUIVO ="anotacao.preferencias";
    private SharedPreferences.Editor editor;
    private  final String CHAVE_NOME="Nome";


    public AnotacaoPreferencias(Context c){
        this.context=c;
        preferences = context.getSharedPreferences( NOME_ARQUIVO,0);
        editor = preferences.edit();

    }
    public void salvarAnotacao(String anotacao){
        editor.putString(CHAVE_NOME,anotacao);
        editor.commit();//salva
    }

    public String recuperarAnotacao(){


        return preferences.getString(CHAVE_NOME,"");
    }


}
