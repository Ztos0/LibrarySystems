package PACKAGE_NAME;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class LibraryUI {

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;
    private JDialog tableDialog; // Add this

    private JButton removeButton;

    public LibraryUI() {
        model = new DefaultTableModel();
        table = new JTable(model);
        scrollPane = new JScrollPane(table);

        // Initialize the dialog
        tableDialog = new JDialog();
        tableDialog.setModal(true);
        tableDialog.setSize(800, 600); // Set the size or you can pack() it later
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
        removeButton.addActionListener(e -> removeSelectedBook());
    }
    private void removeSelectedBook(){
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1){
            model.removeRow(selectedRow);
        } else{
            JOptionPane.showMessageDialog(null, "Please select a book to remove.");
        }
    }

    public void displayUsers(List<User> users) {
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"User Name", "User ID", "User Age", "User Address", "Librarian Name"});

        for (User user : users) {
            model.addRow(new Object[]{user.getUserName(), user.getUserID(), user.getUserAge(), user.getUserAddress(), user.getLibrarianName()});
        }
    }

    public void displayBooks(List<Book> books) {
        model.setRowCount(0);
        model.setColumnIdentifiers(new String[]{"User ID", "Book Name", "Book Genre", "Book Author", "Book Publisher", "Book Release Date", "Book Cost", "Book Date"});

        for (Book book : books) {
            model.addRow(new Object[]{book.getUserID(), book.getBookName(), book.getBookGenre(), book.getBookAuthor(), book.getBookPublisher(), book.getbookReleaseDate(), book.getBookCost(), book.getbookDate()});
        }
    }

    public void showTable() {
        tableDialog.setVisible(true); // This makes the dialog appear and pauses the rest until closed
    }
}
