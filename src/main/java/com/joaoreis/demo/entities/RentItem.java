package com.joaoreis.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joaoreis.demo.entities.enums.RentStatus;
import com.joaoreis.demo.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class RentItem implements Serializable {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price = 5.0;
    private Date moment;
    private String rentStatus;

    public RentItem() {
    }

    public RentItem(Rent rent, Book book, Integer quantity,RentStatus rentStatus) {
        id.setRent(rent);
        id.setBook(book);
        this.quantity = quantity;
        this.moment = new Date();
        this.rentStatus = rentStatus.name();
    }

    @JsonIgnore
    public Rent getRent(){
        return id.getRent();
    }

    public void setRent(Rent rent){
        id.setRent(rent);
    }

    public Book getBook(){
        return id.getBook();
    }

    public void setBook(Book book){
        id.setBook(book);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getMoment() {
        return moment;
    }

    public String getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        RentItem orderItem = (RentItem) object;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
