package com.example.blocodenotasbasico;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Anotacao {

    private Context context;
    private SharedPreferences preferences;
    private final String NOME_ARQUIVO ="anotacao.preferencias";

    private SharedPreferences.Editor editor;
    private  final String CHAVE_NOME="Nome";



    public void AnotacaoPreferencias(Context c){
        this.context=c;//o parametro recebe o "this" do Main, e coloca aquele this dentro da variavel context
        preferences = context.getSharedPreferences( NOME_ARQUIVO,0);//pega o contexto,acessa as sharedPreferences(armazenamento de dados), coloca no arquivo
        editor = preferences.edit();//aparentemente, permite que edite o arquivo (aparentemente)

    }
    public void salvarAnotacao(String anotacao){
        editor.putString(CHAVE_NOME,anotacao);//Bota o conteudo na chave
        editor.commit();//salva as alterações no preferences
    }

    public String recuperarAnotacao(){


        return preferences.getString(CHAVE_NOME,"");//aqui pega uma string dentro de preferences?
    }


    public void adicionarNota() {


    }




    private  List<String> todasAsChaves = new ArrayList<String>();
    private SharedPreferences preferenciasLages;
    private Context contextoLages;
    private SharedPreferences.Editor editorLages;
    private final String NOME_DO_ARQUIVO ="anotacao.preferencias";

    public void receberContexto(Context c){
        this.contextoLages=c;//O contexto que a funcao receber, entra aqui e é definido
        preferenciasLages = contextoLages.getSharedPreferences( NOME_ARQUIVO,0);//a variavel preferences se torna o sharedPreferences do contexto
        editorLages = preferenciasLages.edit();//cria o editor
        //Talvez eu possa enviar o numero da chave, e apos isso pegar o valor enquivalente nas notas?
    }
    public void Salvar(String conteudo){
        //todasAsNotas.add(conteudo);
        editorLages.putString(CHAVE_NOME,conteudo);//Bota o conteudo na chave, preciso pegar o contexto do ngc, e armazenar no lugar certo
        editorLages.commit();//salva as alterações no preferences

        //Snackbar.make(view,"Nota criada", Snackbar.LENGTH_LONG).show();
    }

}









