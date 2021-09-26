package com.example.blocodenotasbasico;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.example.blocodenotasbasico.databinding.FragmentFirstBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class FirstFragment extends Fragment implements View.OnClickListener {

    private FragmentFirstBinding binding;
    private List<Button> caixaDeBotoes = new ArrayList<Button>();

    Funcionador fnc = Funcionador.getFuncionador();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fnc.Funciona(getContext());


        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        AndThereMayBeLight();
        System.out.println("First fragment criado");
        System.out.println("notas size: "+fnc.getSize());


        //content();
        }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
    }


    public void AndThereMayBeLight(){

        LinearLayout layout = (LinearLayout) getView().findViewById(R.id.layoutFragmentLages);//pega o layout
        for (int i=1;i<fnc.getSize();i++ ){// para cada elemento dentro do array, o for adicionara um botão
            System.out.println("tamanho: "+ fnc.getSize());
            String nomebotao= "botao "+i;
            Button btn = new Button(getContext());
            btn.setText(nomebotao);
            btn.setTextColor(Color.BLACK);
            btn.setId(i);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment);
                    fnc.defineNota(btn.getId());
                    Snackbar.make(view, "id: "+ fnc.getNotaselecionada(), Snackbar.LENGTH_LONG).show();
                }
            });
            caixaDeBotoes.add(btn);
            layout.addView(btn);

        }


    }


}
