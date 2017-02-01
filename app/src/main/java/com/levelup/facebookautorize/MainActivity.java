package com.levelup.facebookautorize;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callbackManager = CallbackManager.Factory.create();
        Button mButtonFaceBook = (Button) findViewById(R.id.bt_facebook);

        mButtonFaceBook.setOnClickListener(click -> {
            LoginManager.getInstance().logInWithReadPermissions(
                    MainActivity.this,
                    Arrays.asList("public_profile"));
        });
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback() {

                    @Override
                    public void onSuccess(Object o) {

                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
