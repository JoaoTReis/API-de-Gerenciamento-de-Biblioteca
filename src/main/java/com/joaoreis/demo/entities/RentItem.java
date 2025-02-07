package com.joaoreis.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joaoreis.demo.entities.enums.RentStatus;
import com.joaoreis.demo.entities.pk.RentItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_rent_item")
public class RentItem implements Serializable {

    @EmbeddedId
    private RentItemPK id = new RentItemPK();
    private Integer quantity;
    private Double price = 5.0;
    private Date moment;
    private Integer rentStatus;

    public RentItem() {
    }

    public RentItem(Rent rent, Book book,RentStatus rentStatus) {
        id.setRent(rent);
        id.setBook(book);
        this.quantity = 1;
        this.moment = new Date();
        setRentStatus(rentStatus);
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

    public Double getSubTotal(){
        return price * quantity;
    }

    public Date getMoment() {
        return moment;
    }

    public RentStatus getRentStatus() {
        return RentStatus.valueOf( rentStatus);
    }

    public void setRentStatus(RentStatus rentStatus) {
        if(rentStatus != null) {
            this.rentStatus = rentStatus.getCode();
        }
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
