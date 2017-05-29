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

public class AlunoCall extends ListActivity {
    private ArrayList<Smile> alunos = new ArrayList<Smile>();
    private int posicao = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alunos.add(new Smile( "Barbara", "SI", 8, 13121,  10, 91207505));
        alunos.add(new Smile( "Luiza", "SI", 8, 13121,  9, 91096756));
        alunos.add(new Smile( "Rafael", "SI", 8, 76287,  4, 900001939));
        alunos.add(new Smile( "Aline", "SI", 8, 80873,  6, 32341233));

        setListAdapter(new SmileAdapter(this, alunos));
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE}, 1);
        super.onListItemClick(l, v, position, id);
        //Take item on a specific position
        Smile smile = (Smile) this.getListAdapter().getItem(position);

        Uri uri = Uri.parse(String.valueOf(smile.phone));
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
