package PACKAGE_NAME;

import javax.swing.*;
import java.util.ArrayList;
public class Library {

    private ArrayList<Book> Books;


    private void MainMenu() {
        while (true) {
            String[] options = {"Add Book", "Add Renter Info", "Book Info", "Renter Info", "Exit"};
            int selection = JOptionPane.showOptionDialog(null, "Select an action:",
                    "Library Manager", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (selection) { //each case in the selection is in order of the String[] options
                case 0:
                    String bookName = JOptionPane.showInputDialog(null,"Enter Book Name:");
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
                    Books.add(newBook);
                    break;
                case 1:



                    break;
                case 2:
                    break;
                case 4:
                    break;
                case 3:
                    System.exit(0); // this exits it when they press exit
            }
        }
    }
    public static void main(String[] args){
        Library library = new Library();
        library.MainMenu();
    }

}


