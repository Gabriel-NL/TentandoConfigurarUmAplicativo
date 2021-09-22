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

        Funcionador fnc = Funcionador.getFuncionador();
        //Funcionador fnc = new Funcionador();
        TextView textoMultiLineSecondFragment = (TextView) getView().findViewById(R.id.textoMultiLineSecondFragment);
        textoMultiLineSecondFragment.setText(fnc.acessarNota());
        //System.out.println(fnc.getNotaselecionada());


        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ant.Salvar(textoMultiLineSecondFragment.toString());
                String txt = textoMultiLineSecondFragment.getText().toString();
                System.out.println("second fragment envia: "+txt);
                //System.out.println(fnc.getNotaselecionada());
                fnc.Salvar(fnc.getNotaselecionada(),txt);


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