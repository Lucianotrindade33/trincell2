package com.example.lucia.trincell;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import android.view.MenuItem;


import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class tela1 extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ArrayAdapter<Products> adapter;
    private ArrayList<Products> produtos;
    private DatabaseReference firebase;
    private ValueEventListener valueEventListenerProdutos;
    private int pedido=33;

    //11_08
    private ArrayList<Products> produtosEscolhidos = new ArrayList<>();
    private static final int Menu_compra=10;

    private Button btnVoltarTelaInicial;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tela1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //11_08
        mListView  = (ListView) findViewById(R.id.ListaPecas);

        produtos = new ArrayList<>();
        adapter = new ArrayAdapter<Products>(
                tela1.this,android.R.layout.simple_list_item_multiple_choice,produtos
        );
        mListView.setAdapter(adapter);
        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Products products = ((ArrayAdapter<Products>)parent.getAdapter()).getItem(position);
                Log.d("TAG","produto escolhido: "+products.toString());
                produtosEscolhidos.add(products);
                Log.d("TAG","qtd: "+produtosEscolhidos.size());
                Toast.makeText(getBaseContext(), "Produto "+(position+1)+" selecionado!", Toast.LENGTH_LONG).show();
            }
        });

        FirebaseApp.initializeApp(tela1.this);
        final  FirebaseDatabase db =FirebaseDatabase.getInstance();
        final DatabaseReference Aparelhos = db.getReference("Aparelhos");

        Aparelhos.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()){
                    Products p = data.getValue(Products.class);
                    produtos.add(p);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mAuth = FirebaseAuth.getInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pedido++;
                //ped0ido=pedido;
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                //Intent intent = new Intent(Intent.ACTION_SEND);
                // intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"lucianotrindade.ti@gmail.com", ""});
                intent.putExtra(Intent.EXTRA_SUBJECT, "pedido");
                intent.putExtra(Intent.EXTRA_TEXT, "seu pedido é de número : "+pedido);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }//FECHA ONCREATE

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu_compra,Menu_compra,10,"Finalizar");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case Menu_compra:
                Toast.makeText(tela1.this,"Vamos continuar...",Toast.LENGTH_SHORT).show();

                OrcamentoActivity.prodEscolhidos = produtosEscolhidos;
                Intent it = new Intent(tela1.this, OrcamentoActivity.class);
                //it.putExtra("array",produtosEscolhidos);
                startActivity(it);

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}