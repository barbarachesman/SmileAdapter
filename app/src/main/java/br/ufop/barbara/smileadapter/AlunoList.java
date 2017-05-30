package br.ufop.barbara.smileadapter;

import android.Manifest;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AlunoList extends ListActivity {
    private static final int ALUNO_EDIT = 1;
    private static final int ALUNO_CALL = 2;
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    private Integer action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent it = getIntent();
        Bundle params = it.getExtras();
        alunos = (ArrayList<Aluno>) params.get("alunos");
        action = (Integer) params.get("action");

        setListAdapter(new AlunoAdapter(this, alunos));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Take item on a specific position
        Aluno aluno = (Aluno) this.getListAdapter().getItem(position);

        if(action == 0){
            //Enviar alunos e posicao para activity ALunoEdit
            Intent it = new Intent(this, AlunoEdit.class);
            it.putExtra("alunos", alunos);
            it.putExtra("posicao", position);
            startActivityForResult(it, ALUNO_EDIT);

        }
        else if(action == 1) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE}, 1);

            //Enviar alunos e posicao para activity ALunoCall
            Uri uri = Uri.parse("tel:" + String.valueOf(aluno.phone));
            Intent it = new Intent(Intent.ACTION_CALL, uri);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(it);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( requestCode == ALUNO_EDIT || requestCode == ALUNO_CALL ) {
            if (resultCode == RESULT_OK) {
                alunos = data.getParcelableArrayListExtra("alunos");
                setListAdapter(new AlunoAdapter(this, alunos));

            }
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

    @Override
    public void onBackPressed(){
        Intent it = new Intent();
        it.putExtra("alunos", alunos);

        setResult(RESULT_OK, it);
        finish();
    }
}
