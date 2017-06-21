package com.example.labadobe_corel.ton;

/**
 * Created by Lab. Adobe_Corel on 21/06/2017.
 */

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends Activity implements View.OnClickListener {

    private Button logout;
    private TextView userData;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicial);

        logout = (Button) findViewById(R.id.logout);
        userData = (TextView) findViewById(R.id.dadosUsuario);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null) {
            startActivity(new Intent(this, TON.class));
        }
        user = firebaseAuth.getCurrentUser();

        showUserData();
    }

    @Override
    public void onClick(View v) {

        if(v == logout) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, TON.class));
        }
    }


    public void showUserData() {
        new getDadosUser().execute();
    }

    public void editUserData(User user) {
        String info = "Nome: " + user.getFristName();
        info += "\nSobreNome: " + user.getLastName();
        info += "\nEmail: " + user.getEmail();
        info += "\n:RG " + user.getRg();
        info += "\n:CPF " + user.getCpf();
        info += "\n:PHONE " + user.getPhone();
        info += "\n:CELLPHONE " + user.getCellphone();
        info += "\n:ANDRESS " + user.getAndress();
        info += "\n:CEP " + user.getCep();
        info += "\n:SENHA " + user.getPassoword();
        info += "\n:PROVIDER " + user.getProvaider();

        userData.setText(info);
    }


    private class getDadosUser extends AsyncTask<Void,Void,User> {
        @Override
        public void onPreExecute(){
        }

        @Override
        public User doInBackground(Void... params){
            HttpURLConnection con = null;
            try {
                URL url = new URL("http://vendasplus.com.br/r/vendedor/getInfoVendedorByEmail");
                con = (HttpURLConnection) url.openConnection();
                con.setReadTimeout(10000);
                con.setConnectTimeout(15000);
                con.setRequestMethod("POST");
                con.setDoInput(true);
                con.setDoOutput(true);

                Uri.Builder postBody = new Uri.Builder().appendQueryParameter("email", user.getEmail());
                String query = postBody.build().getEncodedQuery();

                OutputStream os = con.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();

                con.connect();

                String resultado = Util.streamToString(con.getInputStream());
                User user = Util.JSONToVendedor(resultado);
                return user;
            }
            catch (Exception e){
                e.printStackTrace();
            }finally {
                con.disconnect();
            }
            return null;
        }

        @Override
        public void onPostExecute(User user){
            editUserData(user);
        }
    }
}