# LibrarySystems
This Library Management System provides a user-friendly interface to manage and display books, users, and transactions within a library. Built using Java and Swing, the system provides functionalities such as adding and removing items based on their type, displaying items in a table format, and managing transactional details.

Features

User Management:

Add, edit, and remove users.
Displays user information such as name, ID, age, address, and the associated librarian's name.

Book Management:

Add, edit, and remove books.
Displays book details such as name, genre, author, publisher, release date, cost, and date of addition.

Transaction Management:

Displays the details of a book transaction, including the renter's ID, taken date, return date, book lost status, due date, duration for which the book has been out, and any late fees.
Calculates the due date based on a fixed loan period.
Determines if a book is overdue and calculates late fees accordingly.

Interactive UI:

Provides a table view for easy reading and management of records.
Actionable buttons based on the current display state (Users, Books, or Transactions).

Structure

LibraryUI.java: This class provides the user interface for the application, including table views and actionable buttons.

Transaction.java: Manages transactions, including calculations for due dates and late fees.

Book.java: Represents a book with attributes such as name, genre, author, etc.

User.java: Represents a library user with details like name, ID, age, and address.

Getting Started
Ensure you have Java installed on your machine.
Clone the repository.
Navigate to the project directory and compile the Java files.
Run the LibraryUI.java to start the application.
Future Enhancements
Implement a search feature for books and users.
Add a feature to edit user and book details.
Implement an authentication system for librarians.
Feedback and Contributions
Contributions, feedback, and bug reports are welcome! Feel free to open issues or pull requests.

Note: This README provides a general overview of the system based on the provided classes. Depending on the complete scope and functionality of the application, further sections can be added or modified.






