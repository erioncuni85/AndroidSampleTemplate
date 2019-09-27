package almotech.co.androidtemplate.Activity.LoginActivities;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import almotech.co.androidtemplate.R;

import static almotech.co.androidtemplate.Utilities.StringCheckers.isValidEmail;

public class ForgotPasswordEmail extends AppCompatActivity {
    Button sendMail;
    TextInputLayout email_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoLightNoActionBar);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_email);
        sendMail = (Button) findViewById(R.id.verify_email_btn);
        email_et = (TextInputLayout) findViewById(R.id.email_et);
        sendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkEmailRequirements(email_et.getEditText().getText().toString());


            }
        });

    }


    public void checkEmailRequirements(String email){
        if (!email.equalsIgnoreCase("")){
            if (isValidEmail(email)){
                performForgotApi();
            }else{

                Toast.makeText(ForgotPasswordEmail.this, "Please enter a valid email address!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(ForgotPasswordEmail.this, "Please fill all required fields!", Toast.LENGTH_SHORT).show();
        }

    }

    private void performForgotApi() {
        Toast.makeText(this, "Forgot Password API", Toast.LENGTH_SHORT).show();
    }


}
