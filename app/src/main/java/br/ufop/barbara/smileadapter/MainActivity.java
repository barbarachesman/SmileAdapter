package br.ufop.barbara.smileadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int ALUNO_EDIT = 1;
    private static final int ALUNO_NOVO = 2;
    private Integer action = 0;

    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void add(View view){
        //Add - Chama nova activity para cadastrar aluno
        Intent it = new Intent(this, AlunoNovo.class);
        it.putExtra( "alunos", alunos);
        startActivityForResult(it, ALUNO_NOVO);

    }

    public void edit(View view){
        //List - Lista (e edita) alunos conforme já implementado
        Intent it = new Intent(this, AlunoList.class);
        it.putExtra( "alunos", alunos);
        action = 0;
        it.putExtra("action", action );
        startActivityForResult(it, ALUNO_EDIT);

    }

    public void call(View view){
        //Call - Exibe a lista de alunos e liga para o aluno selecionado
        Intent it = new Intent(this, AlunoList.class);
        it.putExtra( "alunos", alunos);
        action = 1;
        it.putExtra("action", action );
        startActivity(it);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( requestCode == ALUNO_EDIT || requestCode == ALUNO_NOVO ) {
            if (resultCode == RESULT_OK) {
                alunos = data.getParcelableArrayListExtra("alunos");
            }
        }
    }





}