package PACKAGE_NAME;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Transaction {

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

    public Date calculateDueDate() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(takenDate);

        int loanPeriod = 30;

        calendar.add(Calendar.DAY_OF_MONTH, loanPeriod);

        return calendar.getTime();
    }

    public boolean isOverdue(){
        if (returnDate == null){
            return false;
        }

        return returnDate.after(calculateDueDate());
    }

    public double calculateLateFee() {

        double lateFeeRatePerDay = 0.10;

        Date currentDate = new Date();
        long daysOverdue = calculateDaysOverdue(currentDate);

        double lateFee = lateFeeRatePerDay * daysOverdue;

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        String formattedLateFee = decimalFormat.format(lateFee);

        return Double.parseDouble(formattedLateFee);
    }

    private long calculateDaysOverdue(Date currentDate) {

        if (returnDate == null || returnDate.after(currentDate)) {

            return 0;
        }

        long diffInMilliseconds = currentDate.getTime() - returnDate.getTime();
        return TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);
    }

    public double timeBookOut(Date currentDate){
        long diffInMilliseconds = currentDate.getTime() - takenDate.getTime();
        return TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);
    }
}
