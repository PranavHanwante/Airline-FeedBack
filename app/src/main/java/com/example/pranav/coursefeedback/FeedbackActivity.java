package com.example.pranav.coursefeedback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FeedbackActivity extends AppCompatActivity {


    TextView tvFeedBack;
    Button btnSend;
    Button btnSms,btnEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);



        tvFeedBack = findViewById(R.id.tvFeedback);
        btnSend = findViewById(R.id.btnSend);


        btnSms = findViewById(R.id.btnSms);
        btnEmail = findViewById(R.id.btnEmail);



        final Intent i = getIntent();
        final String msg = i.getStringExtra("msg");
        tvFeedBack.setText(msg);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(Intent.ACTION_SEND);
                s.setType("text/plain");
                s.putExtra(Intent.EXTRA_TEXT,msg);
                startActivity(s);

            }
        });



        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = tvFeedBack.getText().toString();
                Intent i = new Intent(FeedbackActivity.this,SmsActivity.class);

                i.putExtra("msg",msg);
                startActivity(i);

            }
        });



        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = tvFeedBack.getText().toString();
                Intent i = new Intent(FeedbackActivity.this,EmailActivity.class);

                i.putExtra("msg",msg);
                startActivity(i);

            }
        });





    }
}
