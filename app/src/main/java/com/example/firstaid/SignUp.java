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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    Button signup;
    EditText name, phone, age, pswd, email;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.unametext);
        age = findViewById(R.id.agetext);
        phone = findViewById(R.id.phonenum);
        email = findViewById(R.id.emailid);
        pswd = findViewById(R.id.password);

        signup = (Button) findViewById(R.id.btnsignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = name.getText().toString().trim();
                String useremail = email.getText().toString().trim();
                String userpswd = pswd.getText().toString().trim();
                String userage = age.getText().toString().trim();
                String userphone = phone.getText().toString().trim();

                createUser(username,userpswd,useremail,userphone,userage);
            }
        });

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

    }

    private void createUser(final String user_name, final String user_pswd, final String user_email, final String user_num, final String user_age) {
        if (user_name.equals("") | user_pswd.equals("") | user_email.equals("") | user_num.equals("") | user_age.equals("")) {
            Toast.makeText(SignUp.this,"Fields can't be empty!",Toast.LENGTH_LONG).show();
        }
        else if (user_num.length()<10){
            Toast.makeText(SignUp.this,"Enter valid phone number!",Toast.LENGTH_LONG).show();
        }
        else {
            signup.setEnabled(false);
            mAuth.createUserWithEmailAndPassword(user_email, user_pswd)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();

                                // Create a new user with a first and last name
                                Map<String, Object> userdata = new HashMap<>();
                                userdata.put("username", user_name);
                                userdata.put("email", user_email);
                                userdata.put("password", user_pswd);
                                userdata.put("phone", user_num);
                                userdata.put("age", user_age);

                                db.collection("users")
                                        .document(user.getUid())
                                        .set(userdata)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(SignUp.this, "Signup Success!", Toast.LENGTH_LONG).show();
                                                mAuth.signOut();
                                                signup.setEnabled(true);
                                                finish();
                                            }
                                        });

                            } else {
                                signup.setEnabled(true);
                                // If sign in fails, display a message to the user.
                                Toast.makeText(SignUp.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}