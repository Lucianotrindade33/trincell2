package com.example.lucia.trincell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;


public class cadastraProduto extends AppCompatActivity {

    private Button cadastrar;
    private FirebaseAuth mAuth;
    private Button btnGravar;
    private Button btnVoltarTelaInicial;
    private EditText edtmarca;
    private EditText edtmodelo;
    private EditText edtpeca;
    private EditText edtvalor;
    private EditText edtid;
    private Products products;
    private DatabaseReference firebase;
    private Toolbar toolbar;
    private Button btnDeletar;
    private String senha;




    @Override

    protected void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastra_produto);
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            //setSupportActionBar(toolbar);
            mAuth = FirebaseAuth.getInstance();


            edtmarca = (EditText) findViewById(R.id.Idmarca);
            edtmodelo = (EditText) findViewById(R.id.Idmodelo);
            edtpeca = (EditText) findViewById(R.id.Idpeca);
            edtvalor = (EditText) findViewById(R.id.Idvalor);
            edtid = (EditText) findViewById(R.id.Idid);

            btnGravar = (Button) findViewById(R.id.Insert);


        // btnVoltarTelaInicial = (Button) findViewById(R.id.btnVoltarTelaInicial);







            btnGravar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                products = new Products();
                products.setMarca(edtmarca.getText().toString());
                products.setModelo(edtmodelo.getText().toString());
                products.setPeca(edtpeca.getText().toString());
                products.setPreco(edtvalor.getText().toString());
                products.setId(edtid.getText().toString());
                salvarProduto(products);
            

                }


            });


    }



    private boolean salvarProduto (Products products) {

        try {

            firebase = FireBase.getFirebase().child("Aparelhos");
            firebase.child(products.getId()).setValue(products);
            Toast.makeText(cadastraProduto.this, "Produto inserido com sucesso", Toast.LENGTH_LONG).show();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    }
