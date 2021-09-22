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
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Anotacao extends AppCompatActivity {

    //private List<Button> caixaDeBotoes = new ArrayList<Button>();

    private Context contextoLages;
    private SharedPreferences preferenciasLages;
    private final String NOME_DO_ARQUIVO ="anotacao.preferencias";

    private SharedPreferences.Editor editorLages;
    private  List<String> todasAsChaves = new ArrayList<String>();
    private String selNote;

    public void receberContexto(Context c){
        this.contextoLages=c;                                                      //O contexto que a funcao receber, entra aqui e é definido
        preferenciasLages = contextoLages.getSharedPreferences( NOME_DO_ARQUIVO,0);//a variavel preferences se torna o sharedPreferences do contexto
        editorLages = preferenciasLages.edit();                                   //cria o editor

    }
    public void Salvar(String conteudo){

        editorLages.putString(selNote,conteudo);//Bota o conteudo na chave, preciso pegar o contexto do ngc, e armazenar no lugar certo
        editorLages.commit();//salva as alterações no preferences
    }

    public String acessarNota(String key){

        return preferenciasLages.getString(selNote,"");
    }

    public void setChave(String tituloChave){
        this.selNote= tituloChave;
    }
    public String getChave(){
        return this.selNote;
    }

}









