package ie.wit.leagueofireland;

public class UserProfile {
    public String registerAge;
    public String registerEmail;
    public String registerUsername;
    public String registerTeam;

    public UserProfile(){

    }

    public UserProfile(String registerAge, String registerEmail, String registerUsername, String registerTeam) {

        this.registerAge = registerAge;
        this.registerEmail =registerEmail;
        this.registerUsername = registerUsername;
        this.registerTeam = registerTeam;
    }

    public String getRegisterAge(){
        return registerAge;

    }

    public void setRegisterAge(String registerAge){
        this.registerAge = registerAge;

    }

    public String getRegisterEmail() {
        return registerEmail;
    }

    public void setRegisterEmail(String registerEmail){
        this.registerEmail = registerEmail;
    }

    public String getRegisterUsername(){
        return registerUsername ;
    }

    public void setRegisterUsername(String registerUsername){
        this.registerUsername = registerUsername;
    }

    public String getRegisterTeam(){
        return registerTeam ;
    }

    public void setRegisterTeam(String registerTeam){
        this.registerTeam = registerTeam;
    }

}
