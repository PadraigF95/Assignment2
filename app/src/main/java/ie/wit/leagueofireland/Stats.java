package ie.wit.leagueofireland;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Stats extends AppCompatActivity {
    ListView listView;

    static final String[] numbers = new String[]{
            "Player, Team, Goals Scored",
            "Patrick Hoban, Dundalk, 29",
            "Grahan Cummings,cork City, 15 ",
            "Graham Burke, Shamrock Rovers, 13",
            "Michael Duffy, Dundalk, 13",
            "Kieran Sadlier, Cork City, 13",
            "Daniel Carr, Shamrock Rovers, 11",
            "Daniel Corcoran, Bohemians, 10",
            "Courtney Duffus, Waterford FC, 10",
            "Aaron McEneff, Derry City, 10",
            "Robert Benson, Dundalk, 9",};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        listView = (ListView) findViewById(R.id.statsList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numbers);
        listView.setAdapter(adapter);
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
