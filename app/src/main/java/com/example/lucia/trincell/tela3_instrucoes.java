package com.example.lucia.trincell;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class tela3_instrucoes extends AppCompatActivity {

    private Button btncompra1;
    private Button btncompra2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3_instrucoes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btncompra1=(Button)findViewById(R.id.btncompra1);
        btncompra2=(Button)findViewById(R.id.btncompra2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        btncompra1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                //Intent intent = new Intent(Intent.ACTION_SEND);
                // intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"lucianotrindade.ti@gmail.com", ""});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Compra");
                intent.putExtra(Intent.EXTRA_TEXT, "Seu pedido:" +"1 Tela Iphone 5C");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        btncompra2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                //Intent intent = new Intent(Intent.ACTION_SEND);
                // intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"lucianotrindade.ti@gmail.com", ""});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Compra");
                intent.putExtra(Intent.EXTRA_TEXT,"Seu pedido:" +"1 tela motorola moto e");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

}
