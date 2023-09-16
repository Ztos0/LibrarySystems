package PACKAGE_NAME;

    public class Book {

        private String bookName;
        private String bookGenre;
        private String bookAuthor;
        private String bookPublisher;
        private String bookReleaseDate;
        private Double bookCost;

        public Book(String bookName, String bookGenre, String bookAuthor, String bookPublisher, String bookReleaseDate,Double bookCost){
            this.bookName = bookName;
            this.bookGenre = bookGenre;
            this.bookAuthor = bookAuthor;
            this.bookPublisher = bookPublisher;
            this.bookReleaseDate = bookReleaseDate;
            this.bookCost = bookCost;
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
    }



