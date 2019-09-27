package almotech.co.androidtemplate.Activity.LoginActivities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import almotech.co.androidtemplate.Activity.MainActivity;
import almotech.co.androidtemplate.R;

import static almotech.co.androidtemplate.Utilities.StringCheckers.isValidEmail;

public class LoginActivity extends AppCompatActivity {
    Button sign_up_btn,forgotPasswordBtn,login_btn;
    CardView card_login;
    TextView name_transition_elemtn,sign_up_text;
    TextInputLayout email_et,password_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoLightNoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeView();
        buttonListners();

    }




    public void checkLogin(String email,String password){
        if (!email.equalsIgnoreCase("")&& !password.equalsIgnoreCase("")){

            if (isValidEmail(email)){
                if (password.length()>=6){
                    performApiLoginCall(email,password);

                }else{
                    Toast.makeText(LoginActivity.this, "Please check your password!", Toast.LENGTH_SHORT).show();

                }
            }else{

                Toast.makeText(LoginActivity.this, "Please enter a valid email address!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(LoginActivity.this, "Please fill all required fields!", Toast.LENGTH_SHORT).show();
        }

    }



    private void performApiLoginCall(String email,String password) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
    }


    public void initializeView(){

        email_et = (TextInputLayout) findViewById(R.id.email_et);
        password_et = (TextInputLayout) findViewById(R.id.password_et);
        sign_up_text = (TextView) findViewById(R.id.dont_have_account);
        forgotPasswordBtn = (Button) findViewById(R.id.forgot_password);
        login_btn = (Button) findViewById(R.id.sign_in_btn);
        name_transition_elemtn = (TextView) findViewById(R.id.name_transition_elemtn);
        sign_up_btn = (Button) findViewById(R.id.sign_up_btn);
        card_login = (CardView) findViewById(R.id.card_view);

    }
    public void buttonListners(){
        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this,RegisterActivity.class);
                Pair[] pairs = new Pair[8];
                pairs[0] = new Pair(card_login,"transitionCard");
                pairs[1] = new Pair(email_et,"firstElement");
                pairs[2] = new Pair(password_et,"secondElement");
                pairs[3] = new Pair(login_btn,"buttonElement");
                pairs[4] = new Pair(name_transition_elemtn,"nameTransation");
                pairs[5] = new Pair(forgotPasswordBtn,"forgotTransition");
                pairs[6] = new Pair(sign_up_text,"dontHaveAccountTransition");
                pairs[7] = new Pair(sign_up_btn,"signUpTransition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
                startActivity(intent,options.toBundle());
            }
        });
        forgotPasswordBtn = (Button) findViewById(R.id.forgot_password);
        forgotPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,ForgotPasswordNumber.class);
                startActivity(intent);
            }
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin(email_et.getEditText().getText().toString(),
                        password_et.getEditText().getText().toString());
            }
        });

    }


}
