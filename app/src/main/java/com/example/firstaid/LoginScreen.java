package com.example.firstaid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginScreen extends AppCompatActivity {

    TextView t1, f1;
    Button b1, gstbtn;
    EditText email,pswd;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.emailid);
        pswd = findViewById(R.id.password);

        t1 = (TextView) findViewById(R.id.signup);
        b1 = (Button) findViewById(R.id.btnlogin) ;
        f1 = (TextView)findViewById(R.id.fgpwd);
        gstbtn = (Button) findViewById(R.id.btnguest);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String useremail = email.getText().toString().trim();
                String userpswd = pswd.getText().toString().trim();
                LoginUser(useremail,userpswd);
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(LoginScreen.this, SignUp.class);
                startActivity(intent);
            }
        });
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        gstbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginScreen.this,Dashboard.class));
            }
        });


    }

    private void LoginUser(String useremail, String userpswd) {

        if (useremail.equals("")|userpswd.equals("")){
            Toast.makeText(LoginScreen.this,"Fields can't be empty!",Toast.LENGTH_LONG).show();
        }
        else {
            b1.setEnabled(false);
            mAuth.signInWithEmailAndPassword(useremail, userpswd)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                user = mAuth.getCurrentUser();
                                b1.setEnabled(true);
                                Toast.makeText(LoginScreen.this, "Login Success!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginScreen.this,Dashboard.class));
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(LoginScreen.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                b1.setEnabled(true);
                            }
                        }
                    });
        }
    }
}