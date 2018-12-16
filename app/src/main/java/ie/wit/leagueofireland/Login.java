package ie.wit.leagueofireland;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Arrays;

public class Login extends AppCompatActivity {

    private EditText Password,Username;
    private Button btnLogin;
    private FirebaseAuth firebaseauth;
    private TextView forgotPassword;

    private LoginButton btnfacebook;
    private CallbackManager mCallbackManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FacebookSdk.sdkInitialize(getApplicationContext());

        Password = (EditText) findViewById(R.id.loginPassword);
        Username = (EditText) findViewById(R.id.loginUsername);
        btnLogin = (Button) findViewById(R.id.loginButton);
        forgotPassword = (TextView) findViewById(R.id.FPassword);

        btnfacebook = (LoginButton) findViewById(R.id.fb_Login);
        mCallbackManager = CallbackManager.Factory.create();
        btnfacebook.setReadPermissions("email");



        firebaseauth = FirebaseAuth.getInstance();




        FirebaseUser user = firebaseauth.getCurrentUser();

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Password.class));
            }
        });

        btnfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, LeagueofIreland.class));
            }
        });


        if(user != null){
            finish();
            startActivity(new Intent(Login.this, LeagueofIreland.class));
        }
    }


    private void validate(String Username, String Password){
        firebaseauth.signInWithEmailAndPassword(Username, Password). addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, LeagueofIreland.class));
                }else{
                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void buttonclickLoginFb(View v)
    {
        LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    private void handleFacebookToken(AccessToken accessToken)
    {
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        firebaseauth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                FirebaseUser myuserobj = firebaseauth.getCurrentUser();

                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Could not register",Toast.LENGTH_SHORT).show();
                            }
                    }
                });

    }

                     @Override
                        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                        mCallbackManager.onActivityResult(requestCode, resultCode, data);
                        super.onActivityResult(requestCode, resultCode, data);
                     }


}
