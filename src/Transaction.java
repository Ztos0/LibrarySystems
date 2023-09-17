package PACKAGE_NAME;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Transaction {

    private Date takenDate;

    private Date returnDate;

    private Date dueDate;

    private boolean bookLost;

    private double timeBookOut;

    private String renterID;

    private double lateFee = 0.0;

    public Transaction(Date takenDate, Date returnDate, Date dueDate, boolean bookLost, double timeBookOut, String renterID, double lateFee) {
        this.takenDate = takenDate;
        this.returnDate = returnDate;
        this.dueDate = dueDate;
        this.bookLost = bookLost;
        this.timeBookOut = timeBookOut;
        this.renterID = renterID;
        this.lateFee = lateFee;
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

    public boolean getBookLost() {
        return bookLost;
    }

    public void setBookLost(boolean bookLost) {
        this.bookLost = bookLost;
    }

    public double getTimeBookOut() {
        return timeBookOut;
    }

    public void setTimeBookOut(double timeBookOut){
        this.timeBookOut = timeBookOut;
    }

    public String getRenterID() {
        return renterID;
    }

    public void setRenterID(String renterID) {
        this.renterID = renterID;
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

        return lateFee;
    }

    private long calculateDaysOverdue(Date currentDate) {

        if (returnDate == null || returnDate.after(currentDate)) {

            return 0;
        }

        long diffInMilliseconds = currentDate.getTime() - returnDate.getTime();
        return TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);
    }

    public double timeBookOut(Date currentDate){

        long diffInMilliseconds = currentDate.getTime() - returnDate.getTime();
        return timeBookOut = TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);

    }
}
