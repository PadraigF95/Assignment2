package ie.app.models;

public class Donation
{
    public int    amount;
    public String method;
    public String team;

    public Donation (int amount, String method, String team)
    {
        this.amount = amount;
        this.method = method;
        this.team = team;
    }
}
