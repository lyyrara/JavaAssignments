import java.util.Scanner;


public class UserService {
    private UserDAO userDAO = new UserDAO();
    
    private Scanner sc = new Scanner(System.in);

	public void addUser() {
        System.out.print("Enter a user name: ");
        String userName = sc.nextLine();
        System.out.print("Enter a user id: ");
        int userId = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter a first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter a last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter a password: ");
        String password = sc.nextLine();
        userDAO.adduser(userName,userId, firstName, lastName, password);
        
	}

    public void removeTask() {
        System.out.print("Enter the user id to remove: ");
        int remove_id = sc.nextInt();
        boolean remove = userDAO.removeuser(remove_id);
        if(remove){
            System.out.println("User removed successfully.");
        } else {
            System.out.println("User with the given ID not found.");
        }
        
	}

    public void register(){
        System.out.print("Register task id:");
        int idx = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter a user role: ");
        String role = sc.nextLine();
        boolean update = userDAO.register(idx, role);
        if(update){
            System.out.println("User register successfully.");
        } else {
            System.out.println("User with the given ID not found.");
        }
    }
    

    
}
