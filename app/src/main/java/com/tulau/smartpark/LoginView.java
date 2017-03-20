package com.tulau.smartpark;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginView extends AppCompatActivity {

    EditText txtid, txtpass;
    Button btnLogin;
    FirebaseAuth mAuthencation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        txtid = (EditText)findViewById(R.id.txtID);
        txtpass = (EditText)findViewById(R.id.txtPass);
        btnLogin = (Button)findViewById(R.id.bntLogin);
        mAuthencation = FirebaseAuth.getInstance();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangNhap();
            }
        });
    }

    private void DangNhap(){
        String email = txtid.getText().toString();
        String password = txtpass.getText().toString();
        mAuthencation.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(LoginView.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            Intent t2 = new Intent(LoginView.this, MainActivity.class);
                            startActivity(t2);
                        }
                        else{
                            Toast.makeText(LoginView.this,"Tài khoản hoặc mật khẩu sai!nhan", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

}
