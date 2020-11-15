package com.example.firstaid;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UpdateProfile extends AppCompatActivity {

    Toolbar toolbar;
    EditText name, age, phone, password;
    Button update, upbtn;
    String user_email;
    TextView uname, uemail, uphone, uage;
    LinearLayout profile_ll;
    ScrollView update_ll;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }

        name = findViewById(R.id.unametext);
        age = findViewById(R.id.agetext);
        phone = findViewById(R.id.phonenum);
        password = findViewById(R.id.password);
        update_ll = findViewById(R.id.update_ll);
        profile_ll = findViewById(R.id.profile_ll);
        uname = findViewById(R.id.name);
        uage = findViewById(R.id.age);
        uphone = findViewById(R.id.phone);
        uemail = findViewById(R.id.email);

        update = findViewById(R.id.btnupdate);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = name.getText().toString().trim();
                String userpswd = password.getText().toString().trim();
                String userage = age.getText().toString().trim();
                String userphone = phone.getText().toString().trim();

                updateUser(username,userpswd,userphone,userage);
            }
        });

        upbtn = findViewById(R.id.upbtn);

        upbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile_ll.setVisibility(View.GONE);
                update_ll.setVisibility(View.VISIBLE);
            }
        });

        db.collection("users")
                .document(mAuth.getCurrentUser().getUid())
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot document = task.getResult();
                        name.setText(document.get("username").toString());
                        age.setText(document.get("age").toString());
                        phone.setText(document.get("phone").toString());
                        password.setText(document.get("password").toString());
                        user_email = document.get("email").toString();

                        uname.setText(document.get("username").toString());
                        uage.setText(document.get("age").toString());
                        uemail.setText(document.get("email").toString());
                        uphone.setText(document.get("phone").toString());
                    }
                });
    }

    private void updateUser(final String user_name, final String user_pswd, final String user_num, final String user_age) {
        if (user_name.equals("") | user_pswd.equals("")  | user_num.equals("") | user_age.equals("")) {
            Toast.makeText(UpdateProfile.this,"Fields can't be empty!",Toast.LENGTH_LONG).show();
        }
        else if (user_num.length()<10){
            Toast.makeText(UpdateProfile.this,"Enter valid phone number!",Toast.LENGTH_LONG).show();
        }
        else {

            FirebaseUser user = mAuth.getCurrentUser();
            user.updatePassword(user_pswd)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {

                                Map<String, Object> userdata = new HashMap<>();
                                userdata.put("username", user_name);
                                userdata.put("email", user_email);
                                userdata.put("password", user_pswd);
                                userdata.put("phone", user_num);
                                userdata.put("age", user_age);

                                db.collection("users")
                                        .document(mAuth.getCurrentUser().getUid())
                                        .set(userdata)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(UpdateProfile.this, "Profile Updated!", Toast.LENGTH_LONG).show();
                                                Intent intent = new Intent(UpdateProfile.this, Dashboard.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                startActivity(intent);
                                            }
                                        });

                            }
                        }

                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(UpdateProfile.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}