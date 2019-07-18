package icare.models;

/**
 * Factory for creating users, including patients and staff
 * @author d.mikhaylov
 */
public class UserFactory {
    
    public UserFactory() {
    //TODO initialize the factory if needed
    }
    
    public User createNewUser(
            String userType,
            String firstName,
            String lastName,
            String dob,
            String password,
            String department,
            Long insuranceLbl,
            String gender){
        
        User newUser = new User(firstName, lastName, dob, gender);
              
        //if the type of the user is recornized, then return a specific type of a user
        switch (userType) {
            case "Staff":
                newUser = new Staff(firstName, lastName, department, dob, gender);               
               break;
            case "Patient":
                newUser = new Patient(firstName, lastName, insuranceLbl, dob, gender);
                newUser.updateCredential(password);
                break;
            default:
                break;
        }
        newUser.updateCredential(password);
        return newUser;
        
        
    }
    

}
