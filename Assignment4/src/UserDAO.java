public class UserDAO {

    private User[] users = new User[3];

    public void adduser(String userName, int userId, String firstName, String lastName, String password){
        User user = new User(userName, userId, firstName, lastName, password);
        int counter = 0;
		for (User u : users) {
			if (u == null) {
				users[counter] = user;
				break;
			}
			counter++;
		}
        System.out.println("User Added");
		printusers();;
    }
    
    public boolean removeuser(int userId){
        int counter = 0;
		for (User u : users) {
			if (u.getuserId() == userId) {
				users[counter] = null;
				break;
			}
			counter++;
            if (counter == users.length) {
				return false;
			}
		}
        System.out.println("User Removed");
		printusers();
        return true;
    }

    
    public boolean register(int userId, String role){
        int counter = 0;
        for (User u : users) {
			if (userId== u.getuserId()) {
				users[counter].setrole(role);
				break;
			}
            counter++;
            if (counter == users.length) {
				return false;
			}
        }
		printusers();
        return true;
    }

	public void printusers(){
        for(User u : this.users){
            if(u != null){
                System.out.println("user Name: "+u.getuserName()+" user id: "+ u.getuserId() +" firstname: "+u.getfirstName()+" lastname: "+u.getlastName()+ " role:"+u.getrole());
            }
        }    
    }

}
