public class User {
    
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String role;

    public User() {          
    }

    public User(String userName, String firstName, String lastName, String password, String role) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        
    }

    public String getuserName() {
        return this.userName;
    }


    public String getfirstName() {
        return this.firstName;
    }

    public String getlastName() {
        return this.lastName;
    }
    
    public String getpassword() {
        return this.password;
    }

    public String getrole() {
        return this.role;
    }
    
    public void setuserName(String userName) {
        this.userName = userName;
    }

    
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public void setrole(String role) {
        this.role = role;
    }

    


    
}
