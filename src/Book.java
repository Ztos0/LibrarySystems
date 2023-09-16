package PACKAGE_NAME;

    public class Book {
        @Override
        public String toString() {
            String format = "%-20s%s%n";
            StringBuilder sb = new StringBuilder();
            sb.append("+---------------------+\n");
            sb.append(String.format(format, "Book Name:              \t", bookName));
            sb.append(String.format(format, "Book Genre:             \t", bookGenre));
            sb.append(String.format(format, "Book Author:            \t", bookAuthor));
            sb.append(String.format(format, "Book Publisher:       \t", bookPublisher));
            sb.append(String.format(format, "Book Release Date: \t", bookReleaseDate));
            sb.append(String.format(format, "Book Cost:                \t", bookCost));
            sb.append(String.format(format, "Book Date:                \t", bookDate));
            sb.append("+---------------------+\n");
            return sb.toString();
        }


        private String bookName;
        private String bookGenre;
        private String bookAuthor;
        private String bookPublisher;
        private String bookReleaseDate;
        private Double bookCost;
        private String bookDate;


        public Book(String bookName, String bookGenre, String bookAuthor, String bookPublisher, String bookReleaseDate,Double bookCost, String bookDate){
            this.bookName = bookName;
            this.bookGenre = bookGenre;
            this.bookAuthor = bookAuthor;
            this.bookPublisher = bookPublisher;
            this.bookReleaseDate = bookReleaseDate;
            this.bookCost = bookCost;
            this.bookDate = bookDate;
        }
        public String getBookName(){
            return bookName;
        }
        public String getBookGenre(){
            return bookGenre;
        }
        public String getBookAuthor(){
            return bookAuthor;
        }
        public String getBookPublisher(){
            return bookPublisher;
        }
        public String getbookReleaseDate(){
            return bookReleaseDate;
        }
        public Double getBookCost(){
            return bookCost;
        }
        public String getbookDate(){
            return bookDate;
        }
        public void setBookName(String bookName){
            this.bookName = bookName;
        }
        public void setBookGenre(String bookGenre){
            this.bookGenre = bookGenre;
        }
        public void setBookAuthor(String bookAuthor){
            this.bookAuthor = bookAuthor;
        }

        public void setBookPublisher(String bookPublisher) {
            this.bookPublisher = bookPublisher;
        }

        public void setBookCost(Double bookCost) {
            this.bookCost = bookCost;
        }

        public void setbookReleaseDate(String bookReleaseDate) {
            this.bookReleaseDate = bookReleaseDate;
        }
        public void setbookDate(String bookDate){
            this.bookDate = bookDate;
        }

 //branching
    }



