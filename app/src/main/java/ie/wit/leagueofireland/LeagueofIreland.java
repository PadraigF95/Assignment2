package ie.wit.leagueofireland;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class LeagueofIreland extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leagueof_ireland);









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
        switch(item.getItemId())
        {
            case R.id.menuTables:startActivity(new Intent(this, Tables.class));
                Toast.makeText(this,"Tables Selected",Toast.LENGTH_SHORT).show();
                break;


            case R.id.menuStats:startActivity(new Intent(this, Stats.class));
                Toast.makeText(this,"Stats Selected",Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuDonate:startActivity(new Intent(this, Donate.class));
                Toast.makeText(this,"Donate Selected",Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuReport:startActivity(new Intent(this, Report.class));
                Toast.makeText(this,"Report Selected",Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuRegister:startActivity(new Intent(this, Registration.class));
                Toast.makeText(this,"Register Selected",Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuLogin:startActivity(new Intent(this, Login.class));
                Toast.makeText(this,"Login Selected",Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuLogout:startActivity(new Intent(this, Logout.class));
                Toast.makeText(this,"Logout Selected",Toast.LENGTH_SHORT).show();
                break;


            case R.id.menuProfile:startActivity(new Intent(this, Profile.class));
            Toast.makeText(this,"Profile selected",Toast.LENGTH_SHORT).show();
            break;

        }





        //noinspection SimplifiableIfStatement



        return super.onOptionsItemSelected(item);
    }
}
