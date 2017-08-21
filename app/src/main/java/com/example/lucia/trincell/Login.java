package com.example.lucia.trincell;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.lucia.trincell.R.id.fab2;


public class Login extends AppCompatActivity {
    private EditText edtLogin;

    private EditText edtSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtLogin=(EditText)findViewById(R.id.edtLogin);
        edtSenha=(EditText)findViewById(R.id.edtSenha);

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtLogin.getText().toString().equals("333") && edtSenha.getText().toString().equals("333")) {
                    Toast.makeText(getBaseContext(),"Bem vindo Luciano Trindade",Toast.LENGTH_LONG).show();

                    // Intent intent = new Intent(Intent.ACTION_SENDTO);
                    Intent boa  = new Intent(Login.this, cadastraProduto.class);
                    startActivity(boa);
                }
                else {

                    Toast.makeText(getBaseContext(),"Usuario não autorizado",Toast.LENGTH_LONG).show();



                };



            }
        });
    }

}
