package com.blog.model;

import javax.persistence.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(columnDefinition = "text")
    private String content;

    @Column(columnDefinition = "date")
    private String dayCreate;

    //    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String name, String content, String dayCreate, Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.dayCreate = dayCreate;
        this.category = category;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDayCreate() {
        return dayCreate;
    }

    public void setDayCreate(String dayCreate) {
        this.dayCreate = dayCreate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
