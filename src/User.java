package PACKAGE_NAME;

public class User {

    @Override
    public String toString() {
        String format = "%-20s%s%n";
        StringBuilder sb = new StringBuilder();
        sb.append("+---------------------+\n");
        sb.append(String.format(format, "Renter Name :\t", userName));
        sb.append(String.format(format, "ID:\t\t", userID));
        sb.append(String.format(format, "Age:\t\t", userAge));
        sb.append(String.format(format, "Address:\t\t", userAddress));
        sb.append(String.format(format, "Librarian Name:\t", librarianName));
        sb.append("+---------------------+\n");
        return sb.toString();
    }


    private String userName;
    private String userID;
    private int userAge;
    private String userAddress;
    private String librarianName;

    public User(String userName, String userID, int userAge, String userAddress, String librarianName){
        this.userName = userName;
        this.userID = userID;
        this.userAge = userAge;
        this.userAddress = userAddress;
        this.librarianName = librarianName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserID() {
        return userID;
    }

    public int getUserAge() {
        return userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getLibrarianName() {
        return librarianName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setUserID(String userID){
        this.userID = userID;
    }
    public void setUserAge(int userAge){
        this.userAge = userAge;
    }
    public void setUserAddress(String userAddress){
        this.userAddress = userAddress;
    }
    public void setLibrarianName(String librarianName){
        this.librarianName = librarianName;
    }
}





