package PACKAGE_NAME;

public class User {

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


// adding stuff lmao oooooo



