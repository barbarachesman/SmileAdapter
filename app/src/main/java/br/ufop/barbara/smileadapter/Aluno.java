package br.ufop.barbara.smileadapter;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by barbara on 17/05/17.
 */

public class Aluno implements Parcelable{

    /*public static final int HAPPY = 1;
    public static final int SAD = 2;
    public static final int CRAZY = 3;
    */

    public String name, curso;
    public int periodo, matricula;
    public double coeficiente;
    public int phone;


    public Aluno(String name, String curso, int periodo, int matricula, double coeficiente, int phone) {
        this.name = name;
        this.curso = curso;
        this.periodo = periodo;
        this.matricula = matricula;
        this.coeficiente = coeficiente;
        this.phone = phone;
    }


    protected Aluno(Parcel in) {
        name = in.readString();
        curso = in.readString();
        periodo = in.readInt();
        matricula = in.readInt();
        coeficiente = in.readDouble();
        phone  = in.readInt();
    }

    public static final Creator<Aluno> CREATOR = new Creator<Aluno>() {
        @Override
        public Aluno createFromParcel(Parcel in) {
            return new Aluno(in.readString(), in.readString(), in.readInt(), in.readInt(), (int) in.readDouble(), in.readInt());
        }

        @Override
        public Aluno[] newArray(int size) {
            return new Aluno[size];
        }
    };

    public int getImage(){
        if(coeficiente < 7){
            return R.drawable.sad;
        }

        else{
            return R.drawable.happy;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(curso);
        dest.writeInt(periodo);
        dest.writeInt(matricula);
        dest.writeDouble(coeficiente);
        dest.writeInt(phone);
    }
}
