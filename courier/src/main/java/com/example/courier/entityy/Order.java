package com.example.courier.entityy;

import org.springframework.stereotype.Component;

@Component
public class Order {

    private long id;
    private String name;
    private Status status;

    public Order() {
    }

    public Order(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    public Order(long id, String name, Status status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
