package PACKAGE_NAME;

public class Transaction {

    private String takenDate;

    private String returnDate;

    private String bookLost;

    private double timeBookOut;

    public Transaction(String takenDate, String returnDate, String bookLost, double timeBookOut) {
        this.takenDate = takenDate;
        this.returnDate = returnDate;
        this.bookLost = bookLost;
        this.timeBookOut = timeBookOut;
    }

    public String getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(String takenDate) {
        this.takenDate = takenDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getBookLost() {
        return bookLost;
    }

    public void setBookLost(String bookLost) {
        this.bookLost = bookLost;
    }

    public double getTimeBookOut() {
        return timeBookOut;
    }

    public void setTimeBookOut(double timeBookOut) {
        this.timeBookOut = timeBookOut;
    }


}
