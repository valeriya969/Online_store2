package entity;

import java.time.LocalDate;

public class OrderItem {
   private int id;
   private int id_p;
   private User user;
   private Product product;
   private LocalDate dateOfOrder = LocalDate.now();

    public OrderItem() {
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }
}
