package com.example.blocodenotasbasico;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.blocodenotasbasico.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    Funcionador fnc = Funcionador.getFuncionador();


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        TextView textoMultiLineSecondFragment = (TextView) getView().findViewById(R.id.textoMultiLineSecondFragment);
        TextView tituloSecondFragment= (TextView) getView().findViewById(R.id.tituloSecondFragment);

        textoMultiLineSecondFragment.setText(fnc.acessarNota());


        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = textoMultiLineSecondFragment.getText().toString();
                String titulo =tituloSecondFragment.getText().toString();

                if (fnc.getNotaselecionada()==null){
                    fnc.CriarNota(txt);
                    System.out.println("Não havia nada, criando...");
                }else{
                    fnc.Salvar(txt,titulo);
                    System.out.println("Salvando...");
                }

                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);

            }
        });



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}