package com.joaoreis.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joaoreis.demo.entities.enums.Literary_genre;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gender ;

    private Integer literary_genre;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Book> books = new HashSet<>();

    public Category() {
    }

    public Category(Long id, Literary_genre literary_genre) {
        this.id = id;
        setLiterary_genre(literary_genre);
        this.gender = getLiterary_genre().name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Literary_genre getLiterary_genre() {
        return Literary_genre.valueOf( literary_genre);
    }

    public void setLiterary_genre(Literary_genre literary_genre) {
        if(literary_genre != null) {
            this.literary_genre = literary_genre.getCode();
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Category category = (Category) object;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
