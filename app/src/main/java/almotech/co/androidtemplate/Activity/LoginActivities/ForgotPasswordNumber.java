package almotech.co.androidtemplate.Activity.LoginActivities;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

import almotech.co.androidtemplate.R;

public class ForgotPasswordNumber extends AppCompatActivity {
    TextInputLayout phone_nr,code_et;
    Button send_code,verify_code;

    private FirebaseAuth mAuth;
    // [END declare_auth]

    private boolean mVerificationInProgress = false;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeNoLightNoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_number);

        phone_nr = (TextInputLayout) findViewById(R.id.phone_et);
        code_et = (TextInputLayout) findViewById(R.id.code_et);
        send_code = (Button) findViewById(R.id.send_code_btn);
        verify_code = (Button) findViewById(R.id.verify_code_btn);
        send_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phone_nr.getEditText().getText().toString().length()>5){
                      startPhoneNumberVerification("+" + phone_nr.getEditText().getText().toString());

                }
            }
        });
        verify_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verifyPhoneNumberWithCode(mVerificationId,code_et.getEditText().getText().toString());
            }
        });

        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

        // Initialize phone auth callbacks
        // [START phone_auth_callbacks]
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {
                mVerificationInProgress = false;
                signInWithPhoneAuthCredential(credential);
                Toast.makeText(ForgotPasswordNumber.this, "DONE", Toast.LENGTH_SHORT).show();
                performCallAPI();


            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                mVerificationInProgress = false;
                Toast.makeText(ForgotPasswordNumber.this, "NOT DONE", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                mVerificationId = verificationId;
                mResendToken = token;
                Toast.makeText(ForgotPasswordNumber.this, "SEND", Toast.LENGTH_SHORT).show();
                Animation slideLeft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left);
                Animation slideLeftSlower = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left_slower);
                if (code_et.getVisibility() == View.GONE) {
                    code_et.setVisibility(View.VISIBLE);
                    code_et.startAnimation(slideLeft);
                }if (verify_code.getVisibility() == View.GONE) {
                    verify_code.setVisibility(View.VISIBLE);
                    verify_code.startAnimation(slideLeftSlower);
                }


            }
        };
    }

    private void performCallAPI() {
        Toast.makeText(this, "Forgot Password", Toast.LENGTH_SHORT).show();
    }


    private void startPhoneNumberVerification(String phoneNumber) {
        // [START start_phone_auth]
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
        // [END start_phone_auth]

        mVerificationInProgress = true;
    }

    private void verifyPhoneNumberWithCode(String verificationId, String code) {
        // [START verify_with_code]
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        // [END verify_with_code]
        signInWithPhoneAuthCredential(credential);
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = task.getResult().getUser();
                            Toast.makeText(ForgotPasswordNumber.this, "YEHHHH", Toast.LENGTH_SHORT).show();
                        } else {

                            Toast.makeText(ForgotPasswordNumber.this, "NEHH", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
