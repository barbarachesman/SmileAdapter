package br.ufop.barbara.smileadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import static br.ufop.barbara.smileadapter.R.id.phone;

public class AlunoNovo extends AppCompatActivity {

    private ArrayList<Smile> alunos = new ArrayList<Smile>();
    private int posicao = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_novo);

    }

    public void confirmar(View view){
        try {

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
            alunos.add(aluno);

            showMessage("Cadastrado com Exito", AlunoNovo.this);
            new Main2Activity();
        }
        catch (Exception e) {
            showMessage("Erro Ao efetivar o cadastro", AlunoNovo.this);
        }

    }

    public void cancelar(View v){
       new Main2Activity();
    }

    public void showMessage(String Caption, Activity activity) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(activity);
        dialogo.setTitle("Atencao");
        dialogo.setMessage(Caption);
        dialogo.setNeutralButton("OK", null);
        dialogo.show();
    }
}
