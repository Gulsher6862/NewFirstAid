package com.example.firstaid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    EditText email;
    Button fpb;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.emailid);
        fpb = findViewById(R.id.btnfp);
        fpb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_email = email.getText().toString().trim();
                resetLink(user_email);
            }
        });
    }

    private void resetLink(String user_email) {
        if (user_email.equals("")){
            Toast.makeText(ForgotPassword.this,"Fields can't be empty!",Toast.LENGTH_LONG).show();
        }
        else {
            fpb.setEnabled(false);
            mAuth.sendPasswordResetEmail(user_email)
                    .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                fpb.setEnabled(true);
                                Toast.makeText(ForgotPassword.this, "Link sent!", Toast.LENGTH_LONG).show();
                                finish();
                            } else {
                                fpb.setEnabled(true);
                                Toast.makeText(ForgotPassword.this, "Email not found!", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }

}