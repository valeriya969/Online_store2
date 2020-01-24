package entity;

import java.time.LocalDate;

public class Order {
    private int id;
    private User user;
    private OrderItem orderItem;
    private LocalDate dateOfOrder = LocalDate.now();

    public Order(int id, User user, OrderItem orderItem, LocalDate dateOfOrder) {
        this.id = id;
        this.user = user;
        this.orderItem = orderItem;
        this.dateOfOrder = dateOfOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDate dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }
}
