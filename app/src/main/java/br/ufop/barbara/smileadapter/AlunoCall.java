package br.ufop.barbara.smileadapter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.ListActivity;
import android.content.Intent;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AlunoCall extends AppCompatActivity {
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

    /*@Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Take item on a specific position
        Smile smile = (Smile) this.getListAdapter().getItem(position);

        Uri uri = Uri.parse("tel:" + v.findViewById(R.id.txtphone));
        Intent it = new Intent(Intent.ACTION_CALL, uri);
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(it);
        }

        //Toast.makeText(this, "You selected: " + smile.name, Toast.LENGTH_SHORT).show();
    }*/

    public void makeCall(View view) {
        String text = "99887766";
        Uri uri = Uri.parse("tel:" + text);
        Intent it = new Intent(Intent.ACTION_CALL, uri);
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(it);
        }
    }
}
