package service;

import dao.CategoryDAO;
import dao.OrderItemDAO;
import dao.ProductDAO;
import entity.Category;
import entity.Product;
import input.In;
import entity.User;
import dao.UserDAO;
import entity.OrderItem;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Service {

    private In in;
    private UserDAO userDAO;
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private OrderItemDAO orderItemDAO;

    public Service(In in, UserDAO userDAO, CategoryDAO categoryDAO, ProductDAO productDAO, OrderItemDAO orderItemDAO) {
        this.in = in;
        this.userDAO = userDAO;
        this.categoryDAO = categoryDAO;
        this.productDAO = productDAO;
        this.orderItemDAO = orderItemDAO;
    }

    public User createUser(){
        String login = in.read();
        String password = in.read();
        User user = new User(login, password, new OrderItem());
        System.out.println("Welcome "+user.getLogin());
        userDAO.updateUser(user);
        return user;
    }

    public void dressWoman() {
        List<Category> categories = categoryDAO.findAll();
        for (Category category:categories){
            if (category.getSex().equals("w")){
                System.out.println(category.getId()+ " " +category.getName());
            }
        }
    }

    public void dressMan() {
        List<Category> categories = categoryDAO.findAll();
        for (Category category:categories){
            if (category.getSex().equals("m")){
                System.out.println(category.getId()+ " " +category.getName());
            }
        }
    }

    public void seeCategory(String a){
       List<Product> products = productDAO.findByIdCategory(a);
        for (Product product:products){
            System.out.println(product);
        }
    }

    public void addToBasket(User user,String a){
        int b= Integer.parseInt(a);
        List<Product> products = productDAO.findAll();
        for (Product product : products) {
            if (product.getId()==b){
                user.getOrderItem().setId_p(b);
                orderItemDAO.update(user.getOrderItem());
            }
        }
    }

    public void showBasket(User user){
        List<Product> products = productDAO.findProductInOrderItem(user.getId());
        for (Product product:products){
            System.out.println(product);
        }
    }

    public void buy(User user){
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("basket", locale);
        String value = rb.getString("key1");
        System.out.printf("%20s %n",value);
        String value1=rb.getString("key2");
        System.out.printf("%-25s %10s%n",value1,user.getOrderItem().getDateOfOrder());
        System.out.printf("%-25s %10s%n","Products","Price");
        System.out.println("------------------------------------");
        double sum=0;
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        List<Product> products = productDAO.findProductInOrderItem(user.getId());
        for (Product product:products){
            System.out.printf("%-25s %10s%n",product.getName(),numberFormat.format(product.getPrice()));
            sum=sum+product.getPrice();
        }
        System.out.println("------------------------------------");
        String value2 = rb.getString("key3");
        System.out.printf("%-25s %10s%n", value2, numberFormat.format(sum));
        }
}
