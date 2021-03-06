package com.example.labadobe_corel.ton;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TON extends Activity implements View.OnClickListener {
    private EditText userEmail, userSenha;
    private Button logar;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ton);
        userEmail = (EditText) findViewById(R.id.emailLogin);
        userSenha = (EditText) findViewById(R.id.senhaLogin);
        logar = (Button) findViewById(R.id.logar);


        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }
        else {
            Intent intent = new Intent();
            intent.setClass(TON.this,)
        }
        logar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String email = userEmail.getText().toString().trim();
        String senha = userSenha.getText().toString().trim();
        userLogin(email, senha);
    }


    private void userLogin(String email, String senha) {
        //barra de progresso
        progressDialog.setMessage("Logando...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        } else {
                            Toast.makeText(TON.this, "Usuário não encontrado...", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}