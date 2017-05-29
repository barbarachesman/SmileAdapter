package br.ufop.barbara.smileadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ArrayList<Smile> alunos = new ArrayList<Smile>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void add(View view){
        //Add - Chama nova activity para cadastrar aluno
        Intent it = new Intent(this, AlunoNovo.class);
        startActivity(it);

    }

    public void edit(View view){
        //List - Lista (e edita) alunos conforme já implementado
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);

    }

    public void call(View view){
        //Call - Exibe a lista de alunos e liga para o aluno selecionado
        Intent it = new Intent(this, AlunoCall.class);
        startActivity(it);

    }


}