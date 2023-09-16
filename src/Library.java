package PACKAGE_NAME;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Library {

    private LibraryUI libraryUI;

    private ArrayList<Book> Books;// these are never used, we need to fix these
    private ArrayList<User> Users; // these are never used, we need to fix these

    private ArrayList<Transaction> Transactions;
    public Library(){
        libraryUI = new LibraryUI();
        Books = new ArrayList<>();// add these to try and fix arrays
        Users = new ArrayList<>();// add these to try and fix arrays
        Transactions = new ArrayList<>();// add these to try and fix arrays
    }

    public void displayBookInfo(){
        libraryUI.insertBookTable(Books);
        libraryUI.displayTableInDialog("Book Information");
    }
    public void displayUserInfo(){
        libraryUI.insertUserTable(Users);
        libraryUI.displayTableInDialog("User Information");
    }
    public void addBook(Book book){
        Books.add(book);
        libraryUI.insertBookTable(Books);
    }

    public void addRenter(User user){
        Users.add(user);
        libraryUI.insertUserTable(Users);
    }


    private void MainMenu() {
        while (true) {
            String[] options = {"Add Book", "Add Renter Info", "Book Info", "Renter Info", "Exit"};
            int selection = JOptionPane.showOptionDialog(null, "Select an action:",
                    "Library Manager", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (selection) { //each case in the selection is in order of the String[] options
                case 0:
                    String bookName = JOptionPane.showInputDialog(null, "Enter Book Name:");
                    String bookGenre = JOptionPane.showInputDialog(null, "Enter Book Genre:");
                    String bookAuthor = JOptionPane.showInputDialog(null, "Enter Book Author:");
                    String bookPublisher = JOptionPane.showInputDialog(null, "Enter Book Publisher:");
                    String bookReleaseDate = JOptionPane.showInputDialog(null, "Enter Book release date:");
                    String bookCostStr = JOptionPane.showInputDialog(null, "Enter Book Price:");
                    String bookDate = JOptionPane.showInputDialog(null, "When was the book rented? 00/00/0000");
                    // JOptionPane showInputDialog shows the input dialog option when the user selections " Add Book"

                    double bookCost = Double.parseDouble(bookCostStr);
                    Book newBook = new Book(bookName, bookGenre, bookAuthor, bookPublisher, bookReleaseDate, bookCost, bookDate);

                    newBook.setBookName(bookName);
                    Books.add(newBook);// this never reach the arraylist
                    libraryUI.insertUserTable(Users);
                    break;
                case 1:

                    String userName = JOptionPane.showInputDialog(null, "Enter Renter Name:");
                    if (userName == null) {
                        //Check for cases when the user input doesn't give an input
                    } else {
                        String userID = JOptionPane.showInputDialog(null, "Enter Renter ID:");
                        String userAge = JOptionPane.showInputDialog(null, "Enter Renter Age:");
                        String userAddress = JOptionPane.showInputDialog(null, "Enter Renter Address:");
                        String librarianName = JOptionPane.showInputDialog(null, "Enter Librarian Name:");
                        String returnDateInput = JOptionPane.showInputDialog(null, "Enter return date (YYYY-MM-DD):");

                        try {
                            int userAGE = Integer.parseInt(userAge);
                            User newUser = new User(userName, userID, userAGE, userAddress, librarianName);
                            Users.add(newUser);// this never reaches the arraylist

                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date returnDate = dateFormat.parse(returnDateInput);


                            Date takenDate = new Date(); //declared date variables for constructor
                            //Date returnDate = null;
                            Transaction transact = new Transaction(takenDate, returnDate, null, false, 0.0, 0.0);
                            Transactions.add(transact);

                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid integer.");
                        } catch (ParseException e) {
                            JOptionPane.showMessageDialog(null, "Invalid date format. Please enter a date in YYYY-MM-DD format.");



                            // lets the user know the information was added successfully
                            JOptionPane.showMessageDialog(null, "User information added successfully.");
                        } //end catch
                    }//end else
                    // JOptionPane showInputDialog shows the input dialog option when the user selections " Add Renter Info"
                    libraryUI.insertUserTable(Users);


                    break;
                case 2:

                    String bookInfo = JOptionPane.showInputDialog(null, "Enter Book Name:");
                    for (Book book : Books) {
                        if (book.getBookName().equalsIgnoreCase(bookInfo)) {
                            // Display book information
//                            JOptionPane.showMessageDialog(null, book.toString());
                            //display user informaton in a table
                            ArrayList<Book> bookList = new ArrayList<>();
                            bookList.add(book);
                            libraryUI.insertBookTable(bookList);
                            libraryUI.displayTableInDialog("Book Information");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Book not found.");

                    break;
                case 3:
                    String userInfo = JOptionPane.showInputDialog(null, "Enter Renter Name:");
                    for (User user : Users) {
                        if (user.getUserName().equalsIgnoreCase(userInfo)) {
                            // Display renter information
//                            JOptionPane.showMessageDialog(null, user.toString());
                            //display user informaton in a table
                            ArrayList<User> userList = new ArrayList<>();
                            userList.add(user);
                            libraryUI.insertUserTable(userList);
                            libraryUI.displayTableInDialog("User Information");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Renter not found.");

                    break;

                case 4:

                    System.exit(0); // this exits it when they press exit
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.MainMenu(); 


    }

}//end of Library


