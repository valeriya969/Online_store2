package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> basket = new ArrayList<>();
    private LocalDate dateOfShopping = LocalDate.now();

    public Basket() {
    }

    public Basket(List<Product> basket) {
        this.basket = basket;
    }

    public List<Product> getBasket() {
        return basket;
    }

    public LocalDate getDateOfShopping() {
        return dateOfShopping;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basket=" + basket +
                ", dateOfShopping=" + dateOfShopping +
                '}';
    }
}
