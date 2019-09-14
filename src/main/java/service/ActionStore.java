package service;

import entity.Basket;
import entity.Category;
import entity.Product;
import entity.User;
import input.In;
import ui.UI;

import java.text.NumberFormat;
import java.util.*;

public class ActionStore {
    private UI ui;
    private In in;
    private User users;
    private Map<String, Category> categories;
    private String action="";
    private Map<String, User> userMap;

    public ActionStore(UI ui, In in) {
        this.ui = ui;
        this.in = in;
    }
    public void running() {
        ui.start();
        while (true){
            if (!action.equals("2")) {
                String[] actions = {"1-Registration", "2-catalogue of products","3-Exit"};
                System.out.println("Select action!");
                for (String s : actions) {
                    System.out.println(s);
                }
                action = in.read();
            }
            if (action.equals("1")) {
                ui.menu(action);
                createUser();
                if (users == null) {
                    System.out.println("Input 1 to register, please");
                    action = in.read();
                }
                else {
                    System.out.println("Input 2 to see catalogue");
                    action = in.read();
                }
            } else if (action.equals("2")) {
                ui.menu(action);
                String a = in.read();
                if (a.equals("1")) {
                    dressWoman();
                    System.out.println("Input number of category");
                    String b = in.read();
                    seeCategory(b);
                    if (users==null) {
                        System.out.println("At first, input 1 to register, please");
                        action = in.read();
                    } else {
                        System.out.println("Input number of product to put in the basket");
                        String c = in.read();
                        putInBasket(c);
                    }
                } else if (a.equals("2")) {
                    dressMan();
                    System.out.println("Input number of category");
                    String b=in.read();
                    seeCategory(b);
                    if (users==null) {
                        System.out.println("At first, input 1 to register, please");
                        action=in.read();
                    } else {
                        System.out.println("Input number of product to put in the basket");
                        String c = in.read();
                        putInBasket(c);
                    }
                }else if(a.equals("3")) {
                    action="1";
                } else if (a.equals("4")) {
                    System.out.println("There are all products in basket");
                    showBasket();
                } else if (a.equals("5")) {
                    buy();
                    cleanBasket();
                }
            } else if(action.equals("3")){
               ui.menu(action);
               break;
            }
        }
    }

    public void createUser() {
        String login = in.read();
        String password = in.read();

        if (userMap.get(login) == null) {
            if (UserCheck.verify(login, password)) {
                userMap.put(login, new User(login, password, new Basket()));
                users = userMap.get(login);
            } else System.out.println("You aren't registered");
        } else if (userMap.get(login).getLogin().equals(login) && userMap.get(login).getPassword().equals(password)) {
            System.out.println("Authentication is successful");
            users = userMap.get(login);
        } else if (userMap.get(login).getLogin().equals(login))
            System.out.println("Your password is incorrect");
        }

    public void createUserMap(){
        userMap = new HashMap<>();
        userMap.put("Pol3566", new User("Pol3566", "34567",new Basket()));
        userMap.put("Valerie31", new User("Valerie31", "345567",new Basket()));
        userMap.put("An208", new User("An208", "3344",new Basket()));
    }

    public void newProduct() {
        Map<String, Product> skirt = new TreeMap<>();
        Map<String, Product> blouse = new TreeMap<>();
        Map<String, Product> outerwear = new TreeMap<>();
        Map<String, Product> trousers = new TreeMap<>();
        Map<String, Product> tie = new TreeMap<>();
        skirt.put("1",new Product("skirt", 20, 5));
        skirt.put("2",new Product("skirt1", 50, 4));
        blouse.put("3",new Product("blouse1", 10, 3));
        blouse.put("4",new Product("blouse2", 30, 5));
        outerwear.put("5",new Product("coat", 100, 4));
        outerwear.put("6",new Product("jacket", 90, 3));
        trousers.put("7",new Product("trousers1", 60, 5));
        trousers.put("8",new Product("trousers2", 50, 4));
        tie.put("9",new Product("tie", 50, 3));
        tie.put("10", new Product("tie1", 60, 4));
        categories = new TreeMap<>();
        categories.put("1", new Category("Skirt", "w", skirt));
        categories.put("2",new Category("Blouse", "w", blouse));
        categories.put("3",new Category("Outerwear", "m", outerwear));
        categories.put("4",new Category("Trousers", "m", trousers));
        categories.put("5",new Category("Tie", "m", tie));
    }
    public void dressMan() {
        for (Map.Entry<String, Category> categoryEntry : categories.entrySet()) {
            if (categoryEntry.getValue().getSex().equals("m")) {
                System.out.println(categoryEntry.getKey()+" "+ categoryEntry.getValue().getName());
            }
        }
    }

    public void dressWoman() {
        for (Map.Entry<String, Category> categoryEntry : categories.entrySet()) {
            if (categoryEntry.getValue().getSex().equals("w")) {
                System.out.println(categoryEntry.getKey()+" "+ categoryEntry.getValue().getName());
            }
        }
    }

    public void seeCategory(String a){
        for (Map.Entry<String, Category> categoryEntry : categories.entrySet()) {
            if(categoryEntry.getKey().equals(a)){
                System.out.println(categoryEntry.getValue().getProducts());
            }
        }
    }

    public void putInBasket(String a) {
        for (Map.Entry<String, Category> categoryEntry : categories.entrySet()) {
            Map<String, Product> productMap = categoryEntry.getValue().getProducts();
            for (Map.Entry<String, Product> ProductEntry :productMap.entrySet()) {
                if (ProductEntry.getKey().equals(a)) {
                    users.getBasketUser().getBasket().add(ProductEntry.getValue());
                }
            }
        }
    }

    public void showBasket(){
        System.out.println(users.getBasketUser().getBasket());
    }

    public void buy(){
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("basket", locale);
        String value = rb.getString("key1");
        System.out.printf("%20s %n",value);
        String value1=rb.getString("key2");
        System.out.printf("%-25s %10s%n",value1,users.getBasketUser().getDateOfShopping());
        System.out.printf("%-25s %10s%n","Products","Price");
        System.out.println("------------------------------------");
        double sum=0;
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        for (int i = 0; i < users.getBasketUser().getBasket().size(); i++) {
            if (users.getBasketUser().getBasket().get(i)!=null) {
                System.out.printf("%-25s %10s%n",users.getBasketUser().getBasket().get(i).getName(),
                        numberFormat.format(users.getBasketUser().getBasket().get(i).getPrice()));
                sum=sum+users.getBasketUser().getBasket().get(i).getPrice();
            }
        }
        System.out.println("------------------------------------");
        String value2=rb.getString("key3");
        System.out.printf("%-25s %10s%n",value2,numberFormat.format(sum));
    }

    public void cleanBasket(){
        users.getBasketUser().getBasket().clear();
    }
}




