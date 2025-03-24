package ut.edu.webjava.models;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews") // Tên bảng trong database
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String content;

    private int rating;

    // Constructors
    public Review() {
    }

//    public Review(String author, String content, int rating) {
//        this.author = author;
//        this.content = content;
//        this.rating = rating;
//    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
