package br.ufop.barbara.smileadapter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.view.View;
import android.app.ListActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AlunoCall extends ListActivity {
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    private int posicao = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //Receber dados de AlunoList
        Intent it = getIntent();
        Bundle params = it.getExtras();

        alunos = (ArrayList<Aluno>) params.get("alunos");
        posicao = (int) params.get("posicao");

        setContentView(R.layout.activity_aluno_call);

        //setListAdapter(new AlunoAdapter(this, alunos));
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE}, 1);
        super.onListItemClick(l, v, position, id);
        //Take item on a specific position
        Aluno aluno = (Aluno) this.getListAdapter().getItem(position);

        Uri uri = Uri.parse("tel:" + String.valueOf(aluno.phone));
        Intent it = new Intent(Intent.ACTION_CALL, uri);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(it);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int i = 0; i < grantResults.length; ++i) {
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                //Permission has been denied
                Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}
