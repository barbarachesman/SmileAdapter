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

public class SmileAdapter extends BaseAdapter{


    private Context context;
    private List<Smile> smiles;

    public SmileAdapter(Context context, List<Smile> smiles){
        this.context = context;
        this.smiles = smiles;
    }

    @Override
    public int getCount() {
        return smiles.size();
    }

    @Override
    public Object getItem(int position) {
        return smiles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Smile smile = smiles.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.smile_detail, null);

        TextView textNome = (TextView) v.findViewById(R.id.textView);
        textNome.setText(smile.name);

        TextView curso = (TextView) v.findViewById(R.id.curso);
        curso.setText(smile.curso);

        TextView periodo = (TextView) v.findViewById(R.id.periodo);
        periodo.setText((String.valueOf(smile.periodo)));

        TextView matricula = (TextView) v.findViewById(R.id.matricula);
        matricula.setText(String.valueOf(smile.matricula));

        TextView coeficiente = (TextView) v.findViewById(R.id.coeficiente);
        coeficiente.setText(String.valueOf(smile.coeficiente));

        TextView phone = (TextView) v.findViewById(R.id.phone);
        phone.setText(String.valueOf(smile.phone));

        ImageView img = (ImageView) v.findViewById(R.id.imageView);
        img.setImageResource(smile.getImage());


        return v;
    }
}
