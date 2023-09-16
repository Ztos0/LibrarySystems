package PACKAGE_NAME;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class LibraryUI{
    private JTabbedPane tabbedPane;
    private DefaultTableModel userModel;
    private DefaultTableModel bookModel;

    public LibraryUI() {
        // initializing table and model
        tabbedPane = new JTabbedPane();
        userModel = new DefaultTableModel();
        bookModel = new DefaultTableModel();
        // array to setup amount of colums in table
        String[] userColumns = {"Name", "ID", "Age", "Address", "Librarian",};
        bookModel.setColumnIdentifiers(userColumns);

        // creatings tables with their respective models
        JTabbedPane tabbedPane = new JTabbedPane();
        JTable userTable = new JTable(userModel);
        JTable bookTable = new JTable(bookModel);

        //adds table to the tabbed pane
        tabbedPane.addTab("User Information", new JScrollPane(userTable));
        tabbedPane.addTab("Book Information", new JScrollPane(bookTable));


    }

    public void insertBookTable(ArrayList<Book> books) {
        // clear the data that is currently existing
        bookModel.setRowCount(0);

        for (Book book : books) {
            Object[] rowData = {
                    book.getBookName(),
                    book.getBookGenre(),
                    book.getBookAuthor(),
                    book.getBookPublisher(),
                    book.getbookReleaseDate(),
                    book.getBookCost(),
                    book.getbookDate()
            };
            bookModel.addRow(rowData);
        }
    }
    public void insertUserTable(ArrayList<User> users) {
        // clear the data that is currently existing
        userModel.setRowCount(0);

        for (User user : users) {
            Object[] rowData = {
                    user.getUserName(),
                    user.getUserID(),
                    user.getUserAge(),
                    user.getUserAddress(),
                    user.getLibrarianName()
            };
            userModel.addRow(rowData);
        }
    }
    //method that displays the table
    //display table in dialog
    public void displayTableInDialog(String title){
        JOptionPane.showMessageDialog(null, new JScrollPane(tabbedPane), title, JOptionPane.PLAIN_MESSAGE);
    }

}

