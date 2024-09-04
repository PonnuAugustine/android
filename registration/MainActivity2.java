package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent=getIntent();
        String first_name=intent.getStringExtra("fname");
        String last_name = intent.getStringExtra("lname");
        String gender = intent.getStringExtra("gender");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String password = intent.getStringExtra("password");
        String dob = intent.getStringExtra("dob");

        // Find TextViews to display the data
        TextView txtDetails = findViewById(R.id.d1);

        // Display data
        String details = "First Name: " + first_name + "\n\n" +
                "Last Name: " + last_name + "\n\n" +
                "Gender: " + gender + "\n\n" +
                "Email: " + email + "\n\n" +
                "Phone: " + phone + "\n\n" +
                "Password: " + password + "\n\n" +
                "Date of Birth: " + dob;

        txtDetails.setText(details);
    }

    public void back(View view) {
        Toast.makeText(this, "Logging Out", Toast.LENGTH_SHORT).show();
        Intent bintent=new Intent(MainActivity2.this, MainActivity.class);
        startActivity(bintent);
        finish();
    }
}