package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;

    public Tag(String name, List<Post> posts) {
        this.name = name;
        this.posts = posts;
    }

    public Tag(long id) {
        this.id = id;
    }

    public Tag() {

    }
}
