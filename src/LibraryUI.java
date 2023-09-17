package PACKAGE_NAME;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class LibraryUI {

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;
    private JDialog tableDialog; // Add this

    private JButton removeButton;

    private enum DisplayState{
        USERS , BOOKS , TRANSACTIONS
    }

    private DisplayState currentState;

    public LibraryUI() {
        model = new DefaultTableModel();
        table = new JTable(model);
        scrollPane = new JScrollPane(table);

        // Initialize the dialog
        tableDialog = new JDialog();
        tableDialog.setModal(true);
        tableDialog.setSize(850, 500); // set size of dialog box
        tableDialog.add(scrollPane);
        //creating a panel that removes a book
        JPanel buttonPanel = new JPanel();
        removeButton = new JButton("Remove selected book");
        buttonPanel.add(removeButton);

        tableDialog.setLayout(new BorderLayout());
        tableDialog.add(scrollPane, BorderLayout.CENTER);
        tableDialog.add(buttonPanel, BorderLayout.SOUTH);

        //creates an event listener.
        //an event listener is a function that waits for an event to occur.
        //such as, a user clicking a button.
        currentState = DisplayState.BOOKS;
        updateButtonBasedOnState();
        removeButton.addActionListener(e -> removeSelectedItemBasedOnState());
    }
    private void updateButtonBasedOnState(){ // updates the nanme of button, using displaystate.
        if (currentState == DisplayState.BOOKS){
            removeButton.setText("Remove selected book");
        } else if (currentState == DisplayState.USERS){
            removeButton.setText("Remove selected user");
        } else if (currentState == DisplayState.TRANSACTIONS){
            removeButton.setText("Remove selected transaction");
        }
    }
    private void removeSelectedItemBasedOnState(){ //removed item when selecting it
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(null,"Please select an item to remove.");
            return;
        }
        model.removeRow(selectedRow);
    }
    private void removeSelectedBook(){ // removes book that you chose to select
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1){
            model.removeRow(selectedRow);
        } else{
            JOptionPane.showMessageDialog(null, "Please select a book to remove.");
        }
    }

    public void displayUsers(List<User> users) { // setups column names for the user info switch
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"User Name", "User ID", "User Age", "User Address", "Librarian Name"});

        for (User user : users) {
            model.addRow(new Object[]{user.getUserName(), user.getUserID(), user.getUserAge(), user.getUserAddress(), user.getLibrarianName()});

        }
        currentState = DisplayState.USERS;
       updateButtonBasedOnState();
    }

    public void displayBooks(List<Book> books) { // setups column names for the book info switch
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"User ID", "Book Name", "Book Genre", "Book Author", "Book Publisher", "Book Release Date", "Book Cost", "Book Date"});

        for (Book book : books) {
            model.addRow(new Object[]{book.getUserID(), book.getBookName(), book.getBookGenre(), book.getBookAuthor(), book.getBookPublisher(), book.getbookReleaseDate(), book.getBookCost(), book.getbookDate()});
        }
        currentState = DisplayState.BOOKS;
        updateButtonBasedOnState();
    }
    public void displayTransaction(Transaction transaction) { // setsups column names and format for the transaction info
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date dueDate = transaction.calculateDueDate();
        double durationGone = transaction.timeBookOut();
        double lateFee = transaction.calculateLateFee();

        model.setRowCount(0); // Clear the table
        model.setColumnIdentifiers(new String[]{
                "Renter ID",
                "Taken Date",
                "Return Date",
                "Book Lost",
                "Due Date",
                "Duration Gone (in days)",
                "Late Fee"
        });

        model.addRow(new Object[]{
                transaction.getRenterID(),
                dateFormat.format(transaction.getTakenDate()),
                dateFormat.format(transaction.getReturnDate()),
                transaction.getBookLost() == 'Y' ? "Yes" : "No",
                dateFormat.format(dueDate),
                durationGone,
                "$" + String.format("%.2f", lateFee)
        });

        //set to transactions, makes it so you can remove transactions with the action viewer
        currentState = DisplayState.TRANSACTIONS;
        updateButtonBasedOnState();

        showTable();
    }


    public void showTable() {
        tableDialog.setVisible(true); // this makes the dialog appear and pauses the rest until closed
    }
    public void displayTransactions(ArrayList<Transaction> transactions) { // displays transactions and uses a string builder to append
        StringBuilder builder = new StringBuilder();
        builder.append("Transactions:\n");

        for (Transaction transaction : transactions) {
            builder.append(transaction.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, builder.toString());
    }
}
