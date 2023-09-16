package PACKAGE_NAME;

    public class Book {

        private String bookName;
        private String bookGenre;
        private String bookAuthor;
        private String bookPublisher;
        private String bookReleasedate;
        private Double bookCost;

        public Book(String bookName, String bookGenre, String bookAuthor, String bookPublisher, String bookReleasedate,Double bookCost){
            this.bookName = bookName;
            this.bookGenre = bookGenre;
            this.bookAuthor = bookAuthor;
            this.bookPublisher = bookPublisher;
            this.bookReleasedate = bookReleasedate;
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
        public String getbookReleasedate(){
            return bookReleasedate;
        }
        public Double getBookCost(){
            return bookCost;
        }
        public void setBookName(String bookName){
            this.bookName = bookName;
        }

    }



