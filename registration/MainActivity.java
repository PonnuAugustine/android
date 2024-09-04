package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText first_name1;
    private EditText last_name1;
    private EditText email1;
    private EditText phone1;
    private EditText pass1;
    private EditText dob1;
    private RadioGroup gender1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        first_name1=findViewById(R.id.fname);
        last_name1 =findViewById(R.id.lname);
        gender1=findViewById(R.id.radioGroup3);
        email1=findViewById(R.id.email);
        phone1=findViewById(R.id.phn);
        pass1=findViewById(R.id.pass);
        dob1=findViewById(R.id.dob);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btn), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    public void next(View view) {
        String first_name=first_name1.getText().toString();
        String last_name= last_name1.getText().toString();
        String email=email1.getText().toString();
        String phone=phone1.getText().toString();
        String password=pass1.getText().toString();
        String dob=dob1.getText().toString();
        int selectedId = gender1.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        String gender = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "Not Specified";
        if(first_name.isEmpty() || last_name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || dob.isEmpty()){
            Toast.makeText(this, "Fill all the fields", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Registration Success.", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("fname", first_name);
            intent.putExtra("lname", last_name);
            intent.putExtra("gender", gender);
            intent.putExtra("email", email);
            intent.putExtra("phone", phone);
            intent.putExtra("password", password);
            intent.putExtra("dob", dob);
            startActivity(intent);
        }
    }
}