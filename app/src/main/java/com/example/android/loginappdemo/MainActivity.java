package com.example.android.loginappdemo;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String uname, pw;
    EditText userName, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.et_username);
        userPassword = (EditText) findViewById(R.id.et_pw);


        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uname = userName.getText().toString();
                pw = userPassword.getText().toString();
                if (uname.equals("student@gc.ca") && pw.equals("Password")) {
                    Snackbar.make(view, "Welcome", Snackbar.LENGTH_LONG).show();
                } else if (uname.length() == 0) {
                    userName.setError("Username can not be empty.");
                    Snackbar.make(view, "Try Again", Snackbar.LENGTH_SHORT).show();
                } else if (pw.length() == 0) {
                    userPassword.setError("password can not be empty.");
                    Snackbar.make(view, "Try Again", Snackbar.LENGTH_SHORT).show();
                } else {
                    if (!(uname.equals("student@gc.ca")) && !(pw.equals("Password"))) {
                        Snackbar.make(view, "Both username and password are incorrect. Try Again", Snackbar.LENGTH_SHORT).show();
                    } else if (!(uname.trim().equals("student@gc.ca"))) {
                        userName.setError("Username is incorrect.");
                        Snackbar.make(view, "Try Again", Snackbar.LENGTH_SHORT).show();
                    } else if (!(pw.trim().equals("Password"))) {
                        userPassword.setError("Password is incorrect.");
                        Snackbar.make(view, "Try Again", Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}
