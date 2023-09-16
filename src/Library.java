package PACKAGE_NAME;

import javax.swing.*;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> Books;// these are never used, we need to fix these
    private ArrayList<User> Users; // these are never used, we need to fix these

    public Library(){
        Books = new ArrayList<>();// add these to try and fix arrays
        Users = new ArrayList<>();// add these to try and fix arrays


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

                        try {
                            int userAGE = Integer.parseInt(userAge);
                            User newUser = new User(userName, userID, userAGE, userAddress, librarianName);
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

                    String bookInfo = JOptionPane.showInputDialog(null, "Enter Book Name:");
                    for (Book book : Books) {
                        if (book.getBookName().equalsIgnoreCase(bookInfo)) {
                            // Display book information
                            JOptionPane.showMessageDialog(null, book.toString());
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
                            JOptionPane.showMessageDialog(null, user.toString());
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


