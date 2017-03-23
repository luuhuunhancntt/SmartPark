package com.tulau.smartpark;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginView extends AppCompatActivity {
    final String DATABASE_NAME = "SmartPark.sqlite";
    SQLiteDatabase database;
    EditText txtid, txtpass;
    Button btnLogin;
//    FirebaseAuth mAuthencation;


    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        database = DatabaseLogin.initDatabase(this, DATABASE_NAME);
        final Cursor cursor = database.rawQuery("SELECT * FROM LoginView", null);
        cursor.moveToLast();

        final String taikhoan = cursor.getString(1);
        final String password = cursor.getString(2);
        final String quyen    = cursor.getString(3);






        txtid = (EditText) findViewById(R.id.txtID);
        txtpass = (EditText) findViewById(R.id.txtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
//        mAuthencation = FirebaseAuth.getInstance();






        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = new ProgressDialog(LoginView.this,
                        R.style.Theme_AppCompat_Light_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Loading...");
                progressDialog.show();


                String tk = txtid.getText().toString();
                String pw = txtpass.getText().toString();
                if(taikhoan.equals(tk)||password.equals(pw)){
                    Toast.makeText(LoginView.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent t2 = new Intent(LoginView.this, MainActivity.class);
                    startActivity(t2);
                }else {
                    Toast.makeText(LoginView.this, "Tài khoản hoặc mật khẩu sai!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }








    private void DangNhap() {


    }

}
