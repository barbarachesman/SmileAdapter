package br.ufop.barbara.smileadapter;

import android.app.ListActivity;
import android.content.Intent;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    private static final int ALUNO_EDIT = 1;
    private ArrayList<Smile> alunos = new ArrayList<Smile>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alunos.add(new Smile( "Barbara", "SI", 8, 13121,  10, 91207505));
        alunos.add(new Smile( "Luiza", "SI", 8, 13121,  9, 91096756));
        alunos.add(new Smile( "Rafael", "SI", 8, 76287,  4, 900001939));
        alunos.add(new Smile( "ALine", "SI", 8, 80873,  6, 32341233));

        setListAdapter(new SmileAdapter(this, alunos));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Take item on a specific position
        Smile smile = (Smile) this.getListAdapter().getItem(position);

        //Enviar alunos e posicao para activity ALunoEdit
        Intent it = new Intent(this, AlunoEdit.class);
        it.putExtra("alunos", alunos);
        it.putExtra("posicao", position);
        startActivityForResult(it, ALUNO_EDIT);

        //Toast.makeText(this, "You selected: " + smile.name, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ALUNO_EDIT) {
            if (resultCode == RESULT_OK) {
                alunos = data.getParcelableArrayListExtra("alunos");
                setListAdapter(new SmileAdapter(this, alunos));
            }
        } else {

        }
    }
}
