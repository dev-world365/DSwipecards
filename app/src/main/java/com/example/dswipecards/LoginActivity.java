package com.example.dswipecards;

//import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private TextView btnLogin;
    //private ProgressDialog progressDialog;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize Facebook SDK - call this before everything
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_login);

        if (PrefUtils.getCurrentUser(LoginActivity.this) != null) {
            // if user object is not null, proceed to next screen(logout screen), else show this screen
//            Intent homeIntent = new Intent(LoginActivity.this, LogoutActivity.class);
            Intent homeIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(homeIntent);
            finish();
        }
        else{

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.login_button); //facebook button
        loginButton.setReadPermissions("public_profile", "email", "user_friends");

        btnLogin = (TextView) findViewById(R.id.btnLogin); //our custom button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //progressDialog = new ProgressDialog(LoginActivity.this);
                //progressDialog.setMessage("Loading 123...");
                //progressDialog.show();

                loginButton.performClick();
                loginButton.setPressed(true);
                loginButton.invalidate();
                loginButton.registerCallback(callbackManager, mCallBack);
                loginButton.setPressed(false);
                loginButton.invalidate();

            }
        });
    }

    //standard method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private FacebookCallback<LoginResult> mCallBack = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            //progressDialog.dismiss();

            // App code
            GraphRequest request = GraphRequest.newMeRequest(
                    loginResult.getAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(
                                JSONObject object,
                                GraphResponse response) {

                            Log.e("response: ", response + "");
                            try {
                                user = new User();
                                user.facebookID = object.getString("id").toString();
                                user.email = object.getString("email").toString();
                                user.name = object.getString("name").toString();
                                user.gender = object.getString("gender").toString();
                                PrefUtils.setCurrentUser(user, LoginActivity.this);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(LoginActivity.this, "welcome " + user.name, Toast.LENGTH_LONG).show();
//                            Intent intent = new Intent(LoginActivity.this, LogoutActivity.class);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();

                        }

                    });

            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email,gender, birthday");
            request.setParameters(parameters);
            request.executeAsync();
        }

        @Override
        public void onCancel() {
            //progressDialog.dismiss();
        }

        @Override
        public void onError(FacebookException e) {
            //progressDialog.dismiss();
        }
    };
}
