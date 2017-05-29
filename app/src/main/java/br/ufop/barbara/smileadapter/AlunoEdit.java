package br.ufop.barbara.smileadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class AlunoEdit extends AppCompatActivity {

    private ArrayList<Smile> alunos = new ArrayList<Smile>();
    private int posicao = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Receber dados de MainActivity
        Intent it = getIntent();
        Bundle params = it.getExtras();

        alunos = (ArrayList<Smile>) params.get("alunos");
        posicao = (int) params.get("posicao");

        setContentView(R.layout.activity_aluno_edit);

        EditText et1 = (EditText) findViewById(R.id.txtnome);
        et1.setText("" + alunos.get(posicao).name);

        EditText et2 = (EditText) findViewById(R.id.txtMatri);
        et2.setText("" + alunos.get(posicao).matricula);

        EditText et3 = (EditText) findViewById(R.id.txtcoeficiente);
        et3.setText("" + alunos.get(posicao).coeficiente);

        EditText et4 = (EditText) findViewById(R.id.txtcurso);
        et4.setText("" + alunos.get(posicao).curso);

        EditText et5 = (EditText) findViewById(R.id.txtperiodo);
        et5.setText("" + alunos.get(posicao).periodo);

        EditText et6 = (EditText) findViewById(R.id.txtphone);
        et6.setText("" + alunos.get(posicao).phone);
    }

    public void confirmar(View view){
        EditText et1 = (EditText) findViewById(R.id.txtnome);
        String nome = et1.getText().toString();

        EditText et2 = (EditText) findViewById(R.id.txtMatri);
        int matricula = Integer.parseInt(et2.getText().toString());

        EditText et3 = (EditText) findViewById(R.id.txtcoeficiente);
        Double coef = Double.valueOf(et3.getText().toString());

        EditText et4 = (EditText) findViewById(R.id.txtcurso);
        String curso = et4.getText().toString();

        EditText et5 = (EditText) findViewById(R.id.txtperiodo);
        int periodo = Integer.parseInt(et5.getText().toString());

        EditText et6 = (EditText) findViewById(R.id.txtphone);
        int phone = Integer.parseInt(et6.getText().toString());

        Smile aluno = new Smile(nome, curso, periodo, matricula, coef, phone);
        alunos.set(posicao, aluno);

        //Envia lista de alunos atualizada para a activity que a chamou
        Intent it = new Intent();
        it.putExtra("alunos", alunos);
        setResult(RESULT_OK, it);
        finish();

    }

    public void deletar(View view){
        alunos.remove(posicao);

        Intent it = new Intent();
        it.putExtra("alunos", alunos);
        setResult(RESULT_OK, it);
        finish();
    }
}
