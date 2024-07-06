package com.android.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText username,mobile,email,password,conPass;
    TextView signIn;
    AppCompatButton register;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username= (EditText)findViewById(R.id.fullnameET);
        mobile=(EditText)findViewById(R.id.mobileET);
        email=(EditText)findViewById(R.id.emailET);
        password=(EditText)findViewById(R.id.passwordET);
        conPass=(EditText)findViewById(R.id.ConfPass);

        register = (AppCompatButton) findViewById(R.id.register);
        signIn = (TextView) findViewById(R.id.signInBtn);
        DB = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//             Toast.makeText(Register.this, "Okkkkkkkkkkkkk", Toast.LENGTH_SHORT).show();
                String user = username.getText().toString();
                String phn = mobile.getText().toString();
                String Email = email.getText().toString();
                String pass = password.getText().toString();
                String conpass = conPass.getText().toString();
                // Long n = null;
                // Intent in = new Intent(Register.this,Home.class);
                //startActivity(in);
//               if(user.equals("")||Email.equals("")||pass.equals("")||confpass.equals("")){
////                   Toast.makeText(Register.this, "Please Entered the Filled", Toast.LENGTH_SHORT).show();
//               }
//               else{
//                   if (pass.equals(confpass)){
//                       Boolean checkuser = DB.checkusername(user);
//                       if (checkuser==false){
//                           Boolean insert = DB.insertData(user,pass,phn,Email);
//                           if (insert==true){
//                               Toast.makeText(Register.this, "Register Successfully...!", Toast.LENGTH_SHORT).show();
//                               startActivity(new Intent(getApplicationContext(),Home.class));
//                           }else{
//                               Toast.makeText(Register.this, "Ooops Registration Failed  ", Toast.LENGTH_SHORT).show();
//                           }
//                       }else{
//                           Toast.makeText(Register.this, "User Already Exist ....!Please Login ", Toast.LENGTH_SHORT).show();
//                       }
//                   }else {
//                       Toast.makeText(Register.this, "Password Dosen't Match ", Toast.LENGTH_SHORT).show();
//                   }
//                }
//            }

                if(user.equals(" ")||Email.equals(" ")||phn.equals(" ")||pass.equals(" ")||conpass.equals("")) {
                    Toast.makeText(Register.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(conpass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass,phn,Email);

                            if(insert==true){
                                Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Login.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Register.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Register.this, "Passwords not matching", Toast.LENGTH_SHORT).show();

                    }
                } }
        });





        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                //startActivity(new Intent(Register.this,Login.class));
            }
        });
    }
}