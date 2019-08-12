package com.example.pranav.coursefeedback;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SmsActivity extends AppCompatActivity {


    TextView tvSmsFeedback;
    EditText etPhone;
    Button btnSmsSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        tvSmsFeedback = findViewById(R.id.tvSmsFeedback);
        etPhone = findViewById(R.id.etPhone);
        btnSmsSend = findViewById(R.id.btnSmsSend);



        Intent i = getIntent();
        final String msg = i.getStringExtra("msg");
        tvSmsFeedback.setText(msg);



        btnSmsSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p  = etPhone.getText().toString();
                if(p.length()!=10){

                    etPhone.setError("Invalid ph no. ");
                    etPhone.setText("");
                    etPhone.requestFocus();
                    return;

                }

                Intent s = new Intent(Intent.ACTION_VIEW);
                s.setData(Uri.parse("sms:"+p));
                s.putExtra("sms_body",msg);
                startActivity(s);



            }
        });




    }
}
