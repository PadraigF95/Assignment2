package ie.wit.leagueofireland;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ie.app.models.Donation;

public class Report extends Base {
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        listView = (ListView) findViewById(R.id.reportList);
        DonationAdapter adapter = new DonationAdapter(this, donations);
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


            case R.id.menuStats:
                startActivity(new Intent(this, Stats.class));
                Toast.makeText(this, "Stats Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuDonate:
                startActivity(new Intent(this, Donate.class));
                Toast.makeText(this, "Donate Selected", Toast.LENGTH_SHORT).show();
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


    class DonationAdapter extends ArrayAdapter<Donation> {
        private Context context;
        public List<Donation> donations;

        public DonationAdapter(Context context, List<Donation> donations) {
            super(context, R.layout.row_donate, donations);
            this.context = context;
            this.donations = donations;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = inflater.inflate(R.layout.row_donate, parent, false);
            Donation donation = donations.get(position);
            TextView amountView = (TextView) view.findViewById(R.id.row_amount);
            TextView methodView = (TextView) view.findViewById(R.id.row_method);
            TextView teamView = (TextView) view.findViewById(R.id.row_teams);

            amountView.setText("$" + donation.amount);
            methodView.setText(donation.method);
            teamView.setText("" + donation.team);

            return view;
        }

        @Override
        public int getCount() {
            return donations.size();
        }
    }
}


