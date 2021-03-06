package com.example.blocodenotasbasico;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.blocodenotasbasico.databinding.FragmentFirstBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements View.OnClickListener {

    private FragmentFirstBinding binding;
    private List<Button> caixaDeBotoes = new ArrayList<Button>();
    private String auxiliar;
    private SecondFragment SF;
    private Anotacao ann;

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

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);

            }
        });


        LinearLayout layout = (LinearLayout) getView().findViewById(R.id.layoutFragmentLages);//pega o layout
        for (int i=0;i< 3;i++ ){// para cada elemento dentro do array, o for adicionara um botão
            String nomebotao= "botao "+i;
            Button btn = new Button(getContext());

            btn.setText(nomebotao);
            btn.setTextColor(Color.BLACK);
            //btn.setId(Integer.parseInt(nomebotao));

            String aExibir = "Botao apertado: "+ Integer.toString(i);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment);

                    //SF.setKey(aExibir);
                    ann.setChave(aExibir);

                }
            });
            caixaDeBotoes.add(btn);
            layout.addView(btn);
        }

        }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {

    }
}
//btn.setText("batata queimada");
//Snackbar.make(view, aExibir, Snackbar.LENGTH_LONG).show();