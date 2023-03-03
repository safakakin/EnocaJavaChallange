package com.enoca.blog.model;

import com.enoca.blog.model.enums.Category;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="blogs")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "post_no", nullable = false)
    private Integer no;
    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "content", nullable = false, length = 2400)
    private String content;

    @Column(name = "create_date")
    private LocalDateTime createDate;
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false,updatable = false, nullable = false)
    private User user;

    public Post(){super();}

    public Post(Integer id, Integer userId, Integer no, String title, String content, Category category) {
        this.id = id;
        this.userId=userId;
        this.no = no;
        this.title = title;
        this.content=content;
        this.createDate = LocalDateTime.now();
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
