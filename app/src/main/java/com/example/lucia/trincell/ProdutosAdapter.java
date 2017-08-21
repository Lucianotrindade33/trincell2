package com.example.lucia.trincell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lucia on 28/07/2017.
 */

public class ProdutosAdapter extends ArrayAdapter<Products> {

    private ArrayList<Products> produto;
    private Context context;

    public ProdutosAdapter(Context c, ArrayList<Products> objects) {

        super(c, 0, objects);
        this.context = c;
        this.produto = objects;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        if(produto != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.activity_tela1, parent, true);

            TextView Idmarca = (TextView) view.findViewById(R.id.Idmarca);
            TextView Idmodelo = (TextView) view.findViewById(R.id.Idmodelo);
            TextView Idpeca = (TextView) view.findViewById(R.id.Idpeca);
            TextView Idvalor = (TextView) view.findViewById(R.id.Idvalor);
            TextView Idid = (TextView) view.findViewById(R.id.Idid);


            Products produto2 = produto.get(position);

            Idmarca.setText(produto2.getMarca());
            Idmodelo.setText(produto2.getModelo().toString());
            Idpeca.setText(produto2.getPeca());
            Idvalor.setText(produto2.getPreco().toString());
            Idid.setText(produto2.getId());
        }




        return view;
    }

}
