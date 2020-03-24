package FunctionLayer;

/**
 * The purpose of User is to...
 * @author kasper
 */
public class User {

    public User( String email, String password, String fName, String sName ) {
        this.email = email;
        this.password = password;
        this.fName = fName;
        this.sName = sName;

    }

    private String email;
    private String password; // Should be hashed and secured
    String fName;
    String sName;


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }


}
