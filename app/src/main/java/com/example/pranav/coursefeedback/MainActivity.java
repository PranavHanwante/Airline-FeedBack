package com.example.pranav.coursefeedback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgFeeback;
    CheckBox cbNotes,cbCertificate;
    Button btnSubmit;

    EditText editText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgFeeback = findViewById(R.id.rgFeedback);
        cbNotes = findViewById(R.id.cbNotes);
        cbCertificate=findViewById(R.id.cbCertificate);
        btnSubmit = findViewById(R.id.btnSubmit);
        editText = findViewById(R.id.editText);




        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fb2 = editText.getText().toString();
                int id = rgFeeback.getCheckedRadioButtonId();
                RadioButton rb = findViewById(id);
                String fb = rb.getText().toString();

                String cm = "";
                if (cbNotes.isChecked()) cm=cm+"Notes";
                if (cbCertificate.isChecked()) cm=cm+"Certificate";

                String msg = "Feedback" + fb + "\n" +"Course Materials" + cm;
                Toast.makeText(MainActivity.this, ""+fb2, Toast.LENGTH_SHORT).show();
               // Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();


                Intent i = new Intent(MainActivity.this,FeedbackActivity.class);
                i.putExtra("msg",msg);
                startActivity(i);





            }
        });



    }
}
