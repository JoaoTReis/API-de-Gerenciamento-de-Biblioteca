package com.joaoreis.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.joaoreis.demo.entities.enums.RentStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_Rent")
public class Rent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant moment;

    private Integer rentStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.rent")
    private Set<RentItem> items = new HashSet<>();

    @OneToOne(mappedBy = "rent", cascade = CascadeType.ALL)
    private Payment payment;

    public Rent() {
    }

    public Rent(Long id, Instant moment, RentStatus rentStatus,User client) {
        this.id = id;
        this.moment = moment;
        setRentStatus(rentStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public RentStatus getRentStatus() {
        return RentStatus.valueOf(rentStatus);
    }

    public void setRentStatus(RentStatus rentStatus) {
        if(rentStatus != null) {
            this.rentStatus = rentStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Set<RentItem> getItems(){
        return items;
    }

    public Double getTotal(){
        double sum = 0.0;
        for(RentItem x : items){
            sum += x.getSubTotal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Rent rent = (Rent) object;
        return Objects.equals(id, rent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
