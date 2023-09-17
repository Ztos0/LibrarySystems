package PACKAGE_NAME;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Library {

    private ArrayList<Book> Books;// these are never used, we need to fix these
    private ArrayList<User> Users; // these are never used, we need to fix these

    private ArrayList<Transaction> Transactions;

    public Library(){
        Books = new ArrayList<>();// add these to try and fix arrays
        Users = new ArrayList<>();// add these to try and fix arrays
        Transactions = new ArrayList<>();


    }


    private void MainMenu() {
        while (true) {
            String[] options = {"Add Book", "Add Renter Info", "Book Info", "Renter Info","Transactions","Exit"};
            int selection = JOptionPane.showOptionDialog(null, "Select an action:",
                    "Library Manager", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (selection) { //each case in the selection is in order of the String[] options
                case 0:
                    String userID = JOptionPane.showInputDialog(null, "Enter Renter ID:");
                    String bookName = JOptionPane.showInputDialog(null, "Enter Book Name:");
                    String bookGenre = JOptionPane.showInputDialog(null, "Enter Book Genre:");
                    String bookAuthor = JOptionPane.showInputDialog(null, "Enter Book Author:");
                    String bookPublisher = JOptionPane.showInputDialog(null, "Enter Book Publisher:");
                    String bookReleaseDate = JOptionPane.showInputDialog(null, "Enter Book release date 00/00/0000:");
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

                    String bookInfo = JOptionPane.showInputDialog(null, "Enter ID:");
                    for (Book book : Books) {
                        if (book.getUserID().equalsIgnoreCase(bookInfo)) {
                            // Display book information
                            JOptionPane.showMessageDialog(null, book.toString());
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Book not found.");




                    break;
                case 3:
                    String userInfo = JOptionPane.showInputDialog(null, "Enter Renter ID:");
                    for (User user : Users) {
                        if (user.getUserID().equalsIgnoreCase(userInfo)) {
                            // Display renter information
                            JOptionPane.showMessageDialog(null, user.toString());
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Renter ID not found.");

                    break;
                case 4:

                    String returnDateInput = JOptionPane.showInputDialog(null, "Enter return date (MM-DD-YYYY):");

                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                        Date returnDate = dateFormat.parse(returnDateInput);

                        String renterID = JOptionPane.showInputDialog(null, "Enter Renter ID:");
                        int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Age:"));
                        String address = JOptionPane.showInputDialog(null, "Enter Address:");
                        String name = JOptionPane.showInputDialog(null, "Enter Name:");

                        Transaction transact = new Transaction(renterID, returnDate, address, false, age, 0.0);
                        Transactions.add(transact);

                    } catch (ParseException e) {
                        JOptionPane.showMessageDialog(null, "Invalid date format. Please enter a date in MM-DD-YYYY format.");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid integer.");
                    }
                    break;

                case 5:

                            System.exit(0); // this exits it when they press exit
                    }
            }//gf
        }


    public static void main(String[] args) {
        Library library = new Library();
        library.MainMenu();


    }

}//end of Library