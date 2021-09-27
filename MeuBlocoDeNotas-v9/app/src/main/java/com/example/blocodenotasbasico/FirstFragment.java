package com.example.blocodenotasbasico;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.blocodenotasbasico.databinding.FragmentFirstBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
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


        binding.buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                fnc.setNotaSelecionada(null);
            }
        });
        AndThereMayBeLight();
        System.out.println("First fragment criado");



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
        for (int i=0;i<fnc.getSize();i++ ){// para cada elemento dentro do array, o for adicionara um botão
            String nomebotao= fnc.getTitulo(i);
            Button btn = new Button(getContext());
            if (nomebotao==null){nomebotao="sem titulo";}
            btn.setText(nomebotao);
            btn.setTextColor(Color.BLACK);
            btn.setId(i);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment);
                    fnc.setNotaSelecionada(btn.getId());
                    Snackbar.make(view, "id: "+ fnc.getNotaSelecionada(), Snackbar.LENGTH_LONG).show();
                }
            });
            btn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                        new Handler().post(new Runnable() {
                            @Override
                            public void run() {
                                btn.setBackgroundColor(Color.RED);
                            }
                        });
                    }

                    return false;
                }
            });
            caixaDeBotoes.add(btn);
            layout.addView(btn);
        }

    }


}
