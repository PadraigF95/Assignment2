package ie.wit.leagueofireland;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    private EditText registerEmail, registerPassword, registerUsername, registerAge,registerTeam;
    private Button btnregister;
    private FirebaseAuth firebaseauth;
    String regEmail, regpassword, regAge, regname, regTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setUIViews();

        firebaseauth = FirebaseAuth.getInstance();

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {

                    String Email = registerEmail.getText().toString().trim();
                    String Password = registerPassword.getText().toString().trim();


                    firebaseauth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                sendUserData();
                                Toast.makeText(Registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Registration.this, Login.class));
                            } else {
                                Toast.makeText(Registration.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }

            }
        });
    }

    private void setUIViews() {
        registerEmail = (EditText) findViewById(R.id.Email);
        registerPassword = (EditText) findViewById(R.id.registerPassword);
        registerUsername = (EditText) findViewById(R.id.Username);
        registerAge = (EditText)  findViewById(R.id.registerAge);
        registerTeam = (EditText) findViewById(R.id.registerTeam);
        btnregister = (Button) findViewById(R.id.button);
    }

    private boolean validate() {
        boolean result = false;

         regname = registerUsername.getText().toString();
         regpassword = registerPassword.getText().toString();
         regEmail = registerEmail.getText().toString();
         regAge = registerAge.getText().toString();
         regTeam = registerTeam.getText().toString();

        if (regname.isEmpty() || regpassword.isEmpty() || regEmail.isEmpty()  || regAge.isEmpty() || regTeam.isEmpty()) {
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }

        return result;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_leagueof_ireland, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {



            case R.id.menuHome:
                startActivity(new Intent(this, LeagueofIreland.class));
                Toast.makeText(this, "Stats Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuTables:
                startActivity(new Intent(this, Tables.class));
                Toast.makeText(this, "Tables Selected", Toast.LENGTH_SHORT).show();
                break;


            case R.id.menuStats:
                startActivity(new Intent(this, Stats.class));
                Toast.makeText(this, "Stats Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuDonate:
                startActivity(new Intent(this, Donate.class));
                Toast.makeText(this, "Donate Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuReport:
                startActivity(new Intent(this, Report.class));
                Toast.makeText(this, "Report Selected", Toast.LENGTH_SHORT).show();
                break;


            case R.id.menuLogin:
                startActivity(new Intent(this, Login.class));
                Toast.makeText(this, "Login Selected", Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }




    private void sendUserData()
    {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseauth.getUid());
        UserProfile userProfile = new UserProfile(regAge, regEmail, regname, regTeam);
        myRef.setValue(userProfile);
    }
}
