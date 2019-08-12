package com.example.pranav.coursefeedback;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class EmailActivity extends AppCompatActivity {

    TextView tvEmailFeedBack;
    EditText etEmail;
    Button btnEmailSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        tvEmailFeedBack = findViewById(R.id.tvEmailFeedBack);
        etEmail = findViewById(R.id.etEmail);
        btnEmailSend = findViewById(R.id.btnEmailSend);


        Intent e = getIntent();
        final String msg = e.getStringExtra("msg");
        tvEmailFeedBack.setText(msg);




        btnEmailSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                    etEmail.setError("Invalid email Address");
                    etEmail.setText("");
                    etEmail.requestFocus();
                    return;
                }
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"+email));
                i.putExtra(Intent.EXTRA_SUBJECT,"FeedBack ");
                i.putExtra(Intent.EXTRA_TEXT,msg);
                startActivity(i);

            }
        });









    }
}
