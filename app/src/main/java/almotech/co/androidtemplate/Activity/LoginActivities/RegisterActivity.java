package almotech.co.androidtemplate.Activity.LoginActivities;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import almotech.co.androidtemplate.R;

import static almotech.co.androidtemplate.Utilities.StringCheckers.isValidEmail;

public class RegisterActivity extends AppCompatActivity {
    Button sign_in_instead_btn;
    Button sign_up_btn;
    TextInputLayout name_et,email_et,password_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoLightNoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initializeView();
        buttonListners();
    }

    public void initializeView(){

        email_et = (TextInputLayout) findViewById(R.id.email_et);
        password_et = (TextInputLayout) findViewById(R.id.password_et);
        name_et = (TextInputLayout) findViewById(R.id.name_et);
        sign_up_btn = (Button) findViewById(R.id.sign_up_btn);
        sign_in_instead_btn = (Button) findViewById(R.id.sign_in_instead_btn);


    }
    public void buttonListners(){

        sign_in_instead_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRegister(name_et.getEditText().getText().toString(),
                        email_et.getEditText().getText().toString(),
                        password_et.getEditText().getText().toString()
                );
            }
        });


    }

    public void checkRegister(String name,String email,String password){
        if (!name.equalsIgnoreCase("")&&!email.equalsIgnoreCase("")&& !password.equalsIgnoreCase("")){

            if (isValidEmail(email)){
                if (password.length()>=6){
                    performApiLoginCall(email,password);

                }else{
                    Toast.makeText(RegisterActivity.this, "Please check your password!", Toast.LENGTH_SHORT).show();

                }
            }else{

                Toast.makeText(RegisterActivity.this, "Please enter a valid email address!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(RegisterActivity.this, "Please fill all required fields!", Toast.LENGTH_SHORT).show();
        }

    }

    private void performApiLoginCall(String email,String password) {

        Toast.makeText(this, "Register Success!", Toast.LENGTH_SHORT).show();
    }

}
