package com.joaoreis.demo.entities.pk;

import com.joaoreis.demo.entities.Book;
import com.joaoreis.demo.entities.Rent;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Rent rent;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        OrderItemPK that = (OrderItemPK) object;
        return Objects.equals(rent, that.rent) && Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rent, book);
    }
}
