package com.example.lista_empleos.Adaptador;

import android.content.Context;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lista_empleos.MainActivity;
import com.example.lista_empleos.Modelo.Empleo;
import com.example.lista_empleos.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder>  {
    private Context mcontext;
    private ArrayList<Empleo> mlista;
    private static final int TYPE_HEAD=0;
    private static final int TYPE_LIST=1;

    public Adaptador (Context context, ArrayList<Empleo> lista){
        mcontext= context;
        mlista= lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        View item = inflater.inflate(R.layout.ly_itemsempleo, null);
        //View v = LayoutInflater.from(mcontext).inflate(R.layout.ly_itemsempleo,parent,false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Empleo actual= mlista.get(position);

        String urlimg =actual.getImagen();
        String ofertalab= actual.getOfertaLaboral();
        String empresa= actual.getEmpresa();
        String cargo= actual.getCargo();
        String correo=actual.getCorreo();
        String descrip=actual.getDescripcion();

        holder.mOfertaLab.setText(ofertalab);
        holder.mEmpresa.setText(empresa);
        holder.mCargo.setText(cargo);
        holder.mCorreo.setText(correo);
        holder.mDescripcion.setText(descrip);
        Glide.with(mcontext)
                .load(urlimg)
                .into(holder.mImagev);
        //Picasso.with(mcontext).load(urlimg).fit().centerInside().into(holder.mImagev);
    }

    @Override
    public int getItemCount() {
        return mlista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImagev;
        public TextView mOfertaLab;
        public TextView mEmpresa;
        public TextView mCargo;
        public TextView mCorreo;
        public TextView mDescripcion;
        public TextView header;
        int view_type;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImagev= itemView.findViewById(R.id.imgEmpr);
            mOfertaLab= itemView.findViewById(R.id.lblOfrtlab);
            mEmpresa= itemView.findViewById(R.id.lblEmpresa);
            mCargo= itemView.findViewById(R.id.lblCargo);
            mCorreo= itemView.findViewById(R.id.lblCorreo);
            mDescripcion= itemView.findViewById(R.id.lblDescripción);
            view_type=1;


        }
    }

}
