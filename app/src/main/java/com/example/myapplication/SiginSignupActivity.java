package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.Fragments.SigninFragment;
import com.example.myapplication.Fragments.SignupFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class SiginSignupActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 100;
    Button buttonSignin;
    Button buttonSignup;
    LinearLayout linearLayout;
    EditText editTextEmail, editTextPassword;
    Button buttonSigninWithGoogle, buttonSigninWithFacebook;
    TextView textViewSignup, textViewSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin_signup);
       // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        buttonSignin = findViewById(R.id.buttonSignin);
        buttonSignup = findViewById(R.id.buttonSignup);
        linearLayout = findViewById(R.id.linearlayout);
        textViewSignup = findViewById(R.id.textViewSignup);
        textViewSignin = findViewById(R.id.textViewSignin);

        SigninFragment signinFragment = new SigninFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.linearlayout,signinFragment);
        transaction.commit();


        textViewSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSignup.setVisibility(View.VISIBLE);
                buttonSignin.setVisibility(View.INVISIBLE);
                textViewSignin.setVisibility(View.VISIBLE);

                SignupFragment signupFragment = new SignupFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearlayout,signupFragment);
                transaction.commit();
            }
        });


        textViewSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSignup.setVisibility(View.INVISIBLE);
                buttonSignin.setVisibility(View.VISIBLE);
                textViewSignin.setVisibility(View.INVISIBLE);


                SigninFragment signinFragment = new SigninFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearlayout,signinFragment);
                transaction.commit();


            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        SigninFragment signinFragment = (SigninFragment) getSupportFragmentManager().findFragmentById(R.id.linearlayout);
        signinFragment.onActivityResult(requestCode, resultCode, data);
    }

}