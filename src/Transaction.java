package PACKAGE_NAME;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Transaction {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date takenDate;

    private Date returnDate;

    private Date dueDate;

    private char bookLost;

    private double timeBookOut;

    private String renterID;

    private double lateFee = 0.0;

    public Transaction(String renterID, Date takenDate, Date returnDate, char bookLost) {
        this.renterID = renterID;
        this.takenDate = takenDate;
        this.returnDate = returnDate;
        this.bookLost = bookLost;
        this.dueDate = calculateDueDate();
    }

    public Transaction(String renterID, String takenDateInput, String returnDateInput, String bookLost) {
    }

    public Transaction(String renterID, Date takenDate, Date returnDate, String bookLost) {
    }

    public String getRenterID() {
        return renterID;
    }

    public void setRenterID(String renterID) {
        this.renterID = renterID;
    }

    public Date getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(Date takenDate) {
        this.takenDate = takenDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public char getBookLost() {
        return bookLost;
    }

    public void setBookLost(char bookLost) {
        this.bookLost = bookLost;
    }

    public double getTimeBookOut() {
        return timeBookOut;
    }

    public void setTimeBookOut(double timeBookOut){
        this.timeBookOut = timeBookOut;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    //Created calculateDueDate method to determine the loaning period of books rented and when they're due
    public Date calculateDueDate() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(takenDate);

        int loanPeriod = 30;

        calendar.add(Calendar.DAY_OF_MONTH, loanPeriod);

        return calendar.getTime();
    }

    //Created isOverDue method to determine if a book is overdue
    public boolean isOverdue(){
        if (returnDate == null){
            return false;
        }

        return returnDate.after(calculateDueDate());
    }

    //Created calculateLateFee method to determine the late fee cost for books that are overdue
    public double calculateLateFee() {

        double lateFeeRatePerDay = 0.10;

        Date currentDate = new Date();

        long daysOverdue = calculateDaysOverdue();

        double lateFee = lateFeeRatePerDay * daysOverdue;

        return lateFee;
    }

    //Created calculateDaysOverdue method to determine how long a book has been overdue for
    private long calculateDaysOverdue() {
        Date currentDate = new Date();
        if (isOverdue()) {
            if (returnDate == null) {
                return TimeUnit.DAYS.convert(currentDate.getTime() - dueDate.getTime(), TimeUnit.MILLISECONDS);
            } else {
                return TimeUnit.DAYS.convert(returnDate.getTime() - dueDate.getTime(), TimeUnit.MILLISECONDS);
            }
        }
        return 0;
    }


    //Created timeBookOut method to show how long a book has been out for
    public double timeBookOut(){
        Date endDate = (returnDate != null) ? returnDate : new Date();
        long diffInMilliseconds = endDate.getTime() - takenDate.getTime();
        return TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);
    }

}
