package com.example.lucia.trincell;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {


    //Drawer
    private Drawer result = null;

    //Toolbar
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        // cabeçalho
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.logocerto
                )
                .addProfiles(

                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener(){
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;


                    }
                })
                .build();

        //Inicio Menu
        result = new DrawerBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(false)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .withSavedInstance(savedInstanceState)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Peças").withIdentifier(0).withIcon(R.mipmap.ic_launcher),
                        new SecondaryDrawerItem().withName("Assistência técnica").withIdentifier(1).withIcon(R.mipmap.ic_launcher),
                        new SecondaryDrawerItem().withName("Promoções da semana ").withIdentifier(2).withIcon(R.mipmap.ic_launcher),
                        new PrimaryDrawerItem().withName("Cadastrar Peças").withIdentifier(3).withIcon(R.mipmap.ic_launcher)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {


                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        switch ((int)drawerItem.getIdentifier()){


                            case 0:
                                Toast.makeText(getBaseContext(),"Você clicou Peças",Toast.LENGTH_LONG).show();
                                Intent i = new Intent(MainActivity.this, tela1.class);
                                startActivity(i);
                                break;

                            case 1:
                                Toast.makeText(getBaseContext(),"Você clicou Assistência técnica",Toast.LENGTH_LONG).show();
                                Intent i2 = new Intent(MainActivity.this, tela_2pecasActivity.class);
                                startActivity(i2);
                                break;
                            case 2:
                                Toast.makeText(getBaseContext(),"Você clicou promoções , aproveite é por tempo determinado!!",Toast.LENGTH_LONG).show();
                                Intent i3 = new Intent(MainActivity.this, tela3_instrucoes.class);
                                startActivity(i3);
                                break;
                            case 3:
                                Toast.makeText(getBaseContext(),"Você clicou cadastrar peças",Toast.LENGTH_LONG).show();
                                Intent i4 = new Intent(MainActivity.this, Login.class);
                                startActivity(i4);
                                break;
                        }
                        return false;
                    }
                }).build();

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                //Intent intent = new Intent(Intent.ACTION_SEND);
                // intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"lucianotrindade.ti@gmail.com", ""});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Assunto");
                intent.putExtra(Intent.EXTRA_TEXT, "Em breve entraremos em contato.");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }//fecha oncreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public void email(View view) {
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        //Intent intent = new Intent(Intent.ACTION_SEND);
//        // intent.setType("*/*");
//        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"lucianotrindade.ti@gmail.com", ""});
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Assunto");
//        intent.putExtra(Intent.EXTRA_TEXT, "Byoncé do agreste");
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
//
//    }
}
