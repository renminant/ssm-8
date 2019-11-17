package pojo;

public class Borrow {
    Integer id;
    Integer book_id;
    Integer user_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", book_id=" + book_id +
                ", user_id=" + user_id +
                '}';
    }
}
