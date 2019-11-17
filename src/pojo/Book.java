package pojo;

public class Book {
    Integer id;
    String name;
    String author;
    String booknumber;
    String price;
    String press;
    String borrower;
    String Headpathbook;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(String booknumber) {
        this.booknumber = booknumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getHeadpathbook() {
        return Headpathbook;
    }

    public void setHeadpathbook(String headpathbook) {
        Headpathbook = headpathbook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", booknumber='" + booknumber + '\'' +
                ", price='" + price + '\'' +
                ", press='" + press + '\'' +
                ", borrower='" + borrower + '\'' +
                ", Headpathbook='" + Headpathbook + '\'' +
                '}';
    }
}
