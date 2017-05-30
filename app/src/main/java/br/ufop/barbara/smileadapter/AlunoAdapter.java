package br.ufop.barbara.smileadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by barbara on 17/05/17.
 */

public class AlunoAdapter extends BaseAdapter{


    private Context context;
    private List<Aluno> alunos;

    public AlunoAdapter(Context context, List<Aluno> alunos){
        this.context = context;
        this.alunos = alunos;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Aluno aluno = alunos.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.smile_detail, null);

        TextView textNome = (TextView) v.findViewById(R.id.textView);
        textNome.setText(aluno.name);

        TextView curso = (TextView) v.findViewById(R.id.curso);
        curso.setText(aluno.curso);

        TextView periodo = (TextView) v.findViewById(R.id.periodo);
        periodo.setText((String.valueOf(aluno.periodo)));

        TextView matricula = (TextView) v.findViewById(R.id.matricula);
        matricula.setText(String.valueOf(aluno.matricula));

        TextView coeficiente = (TextView) v.findViewById(R.id.coeficiente);
        coeficiente.setText(String.valueOf(aluno.coeficiente));

        TextView phone = (TextView) v.findViewById(R.id.phone);
        phone.setText(String.valueOf(aluno.phone));

        ImageView img = (ImageView) v.findViewById(R.id.imageView);
        img.setImageResource(aluno.getImage());


        return v;
    }
}
