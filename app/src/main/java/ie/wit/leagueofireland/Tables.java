package ie.wit.leagueofireland;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Tables extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
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

            case R.id.menuRegister:
                startActivity(new Intent(this, Registration.class));
                Toast.makeText(this, "Register Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuLogin:
                startActivity(new Intent(this, Login.class));
                Toast.makeText(this, "Login Selected", Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
