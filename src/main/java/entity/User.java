package entity;

import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String password;
    private Basket basketUser;

    public User(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public User(String login, String password, Basket basketUser) {
        this.login = login;
        this.password = password;
        this.basketUser = basketUser;
    }

    public User(int id, String login, String password, Basket basketUser) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.basketUser = basketUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Basket getBasketUser() {
        return basketUser;
    }

    public void setBasketUser(Basket basketUser) {
        this.basketUser = basketUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(basketUser, user.basketUser);
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (basketUser != null ? basketUser.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "entity.User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
