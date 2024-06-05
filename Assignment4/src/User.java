public class User {
    
    private String userName;
    private int userId;
    private String firstName;
    private String lastName;
    private String password;
    private String role;

    public User(String userName, int userId, String firstName, String lastName, String password) {
        this.userName = userName;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        
    }

    public String getuserName() {
        return this.userName;
    }

    public int getuserId() {
        return this.userId;
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

    public void setuserId(int userId) {
        this.userId = userId;
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
