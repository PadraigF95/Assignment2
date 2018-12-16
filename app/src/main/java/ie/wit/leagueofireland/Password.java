    package ie.wit.leagueofireland;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

    public class Password extends AppCompatActivity {

    private EditText emailPassword;
    private Button resetPassword;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        emailPassword = (EditText)findViewById(R.id.PasswordEmail);
        resetPassword = (Button)findViewById(R.id.Reset);
        firebaseAuth = FirebaseAuth.getInstance();

        resetPassword.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String useremail = emailPassword.getText().toString().trim();


                if(useremail.equals("") ) {
                    Toast.makeText(Password.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }else{
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Password.this, "Error, password reset email sent", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(Password.this, LeagueofIreland.class));
                            }else{
                                Toast.makeText(Password.this, "Password reset Can't be sent", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }
}
