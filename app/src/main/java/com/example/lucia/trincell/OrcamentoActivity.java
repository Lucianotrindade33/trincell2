package com.example.lucia.trincell;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class OrcamentoActivity extends AppCompatActivity {
    //

    private ListView mListView;
    private Button btnPedido;

    public static ArrayList<Products> prodEscolhidos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orcamento);

        btnPedido  = (Button) findViewById(R.id.btnPedido);

        btnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                //Intent intent = new Intent(Intent.ACTION_SEND);
                // intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"lucianotrindade.ti@gmail.com", ""});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Pedido");
                intent.putExtra(Intent.EXTRA_TEXT, "Meu pedido é :"+prodEscolhidos);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });





        //
        mListView  = (ListView) findViewById(R.id.ListaPecas);

        ArrayAdapter<Products> adapter = new ArrayAdapter<Products>(
                OrcamentoActivity.this, android.R.layout.simple_list_item_1,prodEscolhidos
        );
        mListView.setAdapter(adapter);


        Log.d("TAG","ARRAY QUE CHEGOU: "+prodEscolhidos.toString());

    }//fecha oncreate
}//fecha classe
