package PACKAGE_NAME;

import javax.swing.*;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Library {

    private String storedUsername = "";
    private String storedPassword = "";

    private ArrayList<Book> Books;// these are never used, we need to fix these
    private ArrayList<User> Users; // these are never used, we need to fix these

    private ArrayList<Transaction> Transactions = new ArrayList<>();

    private LibraryUI LibUI = new LibraryUI();

    public Library(){
        Books = new ArrayList<>();// add these to try and fix arrays
        Users = new ArrayList<>();// add these to try and fix arrays
    }

    public void signUp(){
        storedUsername = JOptionPane.showInputDialog("Enter a new username:");
        storedPassword = passwordInput("Enter a new password: "); // the passwordInput variable makes it so its hidden when user is inputting
        JOptionPane.showMessageDialog(null, "Sign up successful!");
    }
    public boolean logIn(){
        String username = JOptionPane.showInputDialog("Enter your username:");
        String password = passwordInput("Enter your password:");

        return storedUsername.equals(username) && storedPassword.equals(password);
    }



    private void MainMenu() {
        while (true) {
            String[] options = {"Add Book", "Add Renter Info", "Add Transaction Info", "Book Info", "Renter Info", "Transaction Info", "Exit"};
            int selection = JOptionPane.showOptionDialog(null, "Select an action:",
                    "Library Manager", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (selection) { //each case in the selection is in order of the String[] options
                case 0:
                    String userID = JOptionPane.showInputDialog(null, "Enter Renter ID:");
                    String bookName = JOptionPane.showInputDialog(null, "Enter Book Name:");
                    String bookGenre = JOptionPane.showInputDialog(null, "Enter Book Genre:");
                    String bookAuthor = JOptionPane.showInputDialog(null, "Enter Book Author:");
                    String bookPublisher = JOptionPane.showInputDialog(null, "Enter Book Publisher:");
                    String bookReleaseDate = JOptionPane.showInputDialog(null, "Enter Book release date:");
                    String bookCostStr = JOptionPane.showInputDialog(null, "Enter Book Price:");
                    String bookDate = JOptionPane.showInputDialog(null, "When was the book rented? 00/00/0000");
                    // JOptionPane showInputDialog shows the input dialog option when the user selections " Add Book"

                    double bookCost = Double.parseDouble(bookCostStr);
                    Book newBook = new Book(userID,bookName, bookGenre, bookAuthor, bookPublisher, bookReleaseDate, bookCost, bookDate);

                    newBook.setBookName(bookName);
                    Books.add(newBook);// this never reach the arraylist
                    break;
                case 1:

                    String userName = JOptionPane.showInputDialog(null, "Enter Renter Name:");
                    if (userName == null) {
                        //Check for cases when the user input doesn't give an input
                    } else {
                        String usersID = JOptionPane.showInputDialog(null, "Enter Renter ID:");
                        String userAge = JOptionPane.showInputDialog(null, "Enter Renter Age:");
                        String userAddress = JOptionPane.showInputDialog(null, "Enter Renter Address:");
                        String librarianName = JOptionPane.showInputDialog(null, "Enter Librarian Name:");

                        try {
                            int userAGE = Integer.parseInt(userAge);
                            User newUser = new User(userName, usersID, userAGE, userAddress, librarianName);
                            Users.add(newUser);// this never reaches the arraylist

                            // lets the user know the information was added successfully
                            JOptionPane.showMessageDialog(null, "User information added successfully.");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Invalid age entered. Please enter a valid number.");

                        }//end catch
                    }//end else
                    // JOptionPane showInputDialog shows the input dialog option when the user selections " Add Renter Info"


                    break;
                case 2:
                    String renterID = JOptionPane.showInputDialog(null, "Enter Renter ID:");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

                    String takenDateInput = JOptionPane.showInputDialog(null, "Enter taken date (MM/DD/YYYY):");
                    Date takenDate = null;
                    try {
                        takenDate = dateFormat.parse(takenDateInput);
                    } catch (ParseException e) {
                        JOptionPane.showMessageDialog(null, "Invalid date format for taken date. Please use MM/DD/YYYY.");
                        break; // Exit the current case if there's an error
                    }

                    String returnDateInput = JOptionPane.showInputDialog(null, "Enter return date (MM/DD/YYYY):");
                    Date returnDate = null;
                    try {
                        returnDate = dateFormat.parse(returnDateInput);
                    } catch (ParseException e) {
                        JOptionPane.showMessageDialog(null, "Invalid date format for return date. Please use MM/DD/YYYY.");
                        break; // Exit the current case if there's an error
                    }

                    String bookLostStr = JOptionPane.showInputDialog(null, "Is the book lost? Y/N");
                    if (bookLostStr == null || bookLostStr.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid input for the book's lost status.");
                        break;
                    }
                    char bookLost = bookLostStr.toUpperCase().charAt(0); // Convert to uppercase and get the first character

                    Transaction newTransaction = new Transaction(renterID, takenDate, returnDate, bookLost);
                    Transactions.add(newTransaction);
                    LibUI.displayTransaction(newTransaction);
                    Date dueDate = newTransaction.calculateDueDate();
                    double durationGone = newTransaction.timeBookOut(new Date());
                    double lateFee = newTransaction.calculateLateFee();
                    //holds data to send it to case 5
                    break;
                case 3:
                    String bookInfo = JOptionPane.showInputDialog(null, "Enter ID:");
                    ArrayList<Book> filteredBooks = new ArrayList<>();

                    for (Book book : Books){
                        if (book.getUserID().equalsIgnoreCase(bookInfo)){
                            filteredBooks.add(book);
                        }
                    }
                    if (!filteredBooks.isEmpty()){
                        LibUI.displayBooks(filteredBooks);
                        LibUI.showTable();
                    } else{
                        JOptionPane.showMessageDialog(null, "No books were found under that ID.");
                    }
                    break;

                case 4:
                    String userInfo = JOptionPane.showInputDialog(null, "Enter Renter ID:");
                    User foundUser = null;
                    for (User user : Users) {
                        if (user.getUserID().equalsIgnoreCase(userInfo)) {
                            foundUser = user;
                            break;
                        }
                    }
                    if (foundUser != null) {
                        ArrayList<User> singleUserList = new ArrayList<>();
                        singleUserList.add(foundUser);
                        LibUI.displayUsers(singleUserList);
                        LibUI.showTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "No renters were found under that ID.");
                    }


                    break;
                case 5:
                    String transactionInfo = JOptionPane.showInputDialog(null, "Enter Renter ID:");
                    ArrayList<Transaction> filteredTransactions = new ArrayList<>();

                    for (Transaction transaction : Transactions) {
                        if (transaction.getRenterID().equalsIgnoreCase(transactionInfo)) {
                            filteredTransactions.add(transaction);
                        }
                    }

                    if (!filteredTransactions.isEmpty()) {
                        LibUI.displayTransactions(filteredTransactions);
                        LibUI.showTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "No transactions were found under that ID.");
                    }
                    break;

                case 6:
                    System.exit(0); // this exits it when they press exit
            }
        }
    }

    public static String passwordInput(String message){
        JPasswordField passwordField = new JPasswordField();
        Object[] obj = {message, passwordField};
        if (JOptionPane.showConfirmDialog(null, obj, "Password", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
            return new String (passwordField.getPassword());
        }
        return null;
    }

    public static void main(String[] args) {
        Library library = new Library();

        String[] options = {"Sign Up", "Log in"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an action:",
                "Library Access", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        boolean isLoginSuccessful = false;

        while (!isLoginSuccessful) {
            if (choice == 0) {
                library.signUp();
            }

            isLoginSuccessful = library.logIn();

            if (!isLoginSuccessful) {
                String[] retryOptions = {"Sign Up", "Try Again", "Exit"};
                int retryChoice = JOptionPane.showOptionDialog(null, "Login failed. What would you like to do next?",
                        "Login", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, retryOptions, retryOptions[0]);

                switch (retryChoice) {
                    case 0: // Sign Up option chosen
                        choice = 0;
                        break;
                    case 1: // Try Again option chosen
                        choice = 1;
                        break;
                    case 2: // Exit option chosen
                        System.exit(0);
                        break;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Login successful!");
        library.MainMenu();
    }

}//end of Library
