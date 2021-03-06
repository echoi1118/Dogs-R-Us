package com.example.count.csci335project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAnAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme_NoActionBar);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_an_account);

    }

    public void goToSignIn (View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks the "Create" (account) button */
    public void goToCreateAccountSuccessPage(View view) {
        EditText validation = findViewById(R.id.create_acct_email);
        EditText pass1val = findViewById(R.id.create_acct_pw);
        EditText pass2val = findViewById(R.id.create_acct_pw_confirm);

        String pass1 = pass1val.getText().toString();
        String pass2 = pass2val.getText().toString();

        if(!isValidEmail(validation.getText()))
        {
            validation.setError("Please enter a valid email.");
        }
        else if(!isValidPassword(pass1val.getText()))
        {
            pass1val.setError("Please enter a valid password.");

        }
        else if(!pass1.equals(pass2))
        {
            pass2val.setError("Please enter a matching password.");
        }
        else {
            Intent intent = new Intent(this, CreateAcctSuccessNotice.class);
            startActivity(intent);
        }
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;

        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public final static boolean isValidPassword(CharSequence password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

}
