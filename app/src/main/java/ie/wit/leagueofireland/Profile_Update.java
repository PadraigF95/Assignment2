package ie.wit.leagueofireland;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile_Update extends AppCompatActivity {

    private EditText newUserName, newUserEmail, newUserAge, newUserTeam;
    private Button save;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__update);

        newUserName = findViewById(R.id.updateProfileName);
        newUserEmail = findViewById(R.id.updateProfileEmail);
        newUserAge = findViewById(R.id.updateProfileAge);
        newUserTeam = findViewById(R.id.updateProfileTeam);
        save = findViewById(R.id.btnSave);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        final DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                newUserName.setText( userProfile.getRegisterUsername());
                newUserAge.setText( userProfile.getRegisterAge());
                newUserEmail.setText(userProfile.getRegisterEmail());
                newUserTeam.setText( userProfile.getRegisterTeam());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Profile_Update.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = newUserName.getText().toString();
                String age = newUserAge.getText().toString();
                String email = newUserEmail.getText().toString();
                String team = newUserTeam.getText().toString();

                UserProfile userProfile = new UserProfile(age, email, name, team);

                databaseReference.setValue(userProfile);

                finish();

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();


        }
        return super.onOptionsItemSelected(item);
    }

    }

