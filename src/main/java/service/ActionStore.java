package service;

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
    private User user;
    private String action="";
    private Service service;

    public ActionStore(UI ui, In in, Service service) {
        this.ui = ui;
        this.in = in;
        this.service = service;
    }

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
                user = service.createUser();
                System.out.println("Input 2 to see catalogue");
                action = in.read();
            } else if (action.equals("2")) {
                ui.menu(action);
                String a = in.read();
                if (a.equals("1")) {
                    service.dressWoman();
                    System.out.println("Input number of category");
                    String b = in.read();
                    service.seeCategory(b);
                    System.out.println("Input number of product to put in the basket");
                    String c = in.read();
                    service.addToBasket(user,c);
                } else if (a.equals("2")) {
                    service.dressMan();
                    System.out.println("Input number of category");
                    String b=in.read();
                    service.seeCategory(b);
                    System.out.println("Input number of product to put in the basket");
                    String c = in.read();
                    service.addToBasket(user,c);
                }else if(a.equals("3")) {
                    action="1";
                } else if (a.equals("4")) {
                    service.showBasket(user);
                    System.out.println("There are all products in basket");
                } else if (a.equals("5")) {
                  service.buy(user);
//                    cleanBasket();
                }
            } else if(action.equals("3")){
               ui.menu(action);
               break;
            }
        }
    }

//
//    public void buy(){
//        Locale locale = new Locale("en", "US");
//        ResourceBundle rb = ResourceBundle.getBundle("basket", locale);
//        String value = rb.getString("key1");
//        System.out.printf("%20s %n",value);
//        String value1=rb.getString("key2");
//        System.out.printf("%-25s %10s%n",value1,users.getOrderItem().getDateOfShopping());
//        System.out.printf("%-25s %10s%n","Products","Price");
//        System.out.println("------------------------------------");
//        double sum=0;
//        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
//        for (int i = 0; i < users.getOrderItem().getBasket().size(); i++) {
//            if (users.getOrderItem().getBasket().get(i)!=null) {
//                System.out.printf("%-25s %10s%n",users.getOrderItem().getBasket().get(i).getName(),
//                        numberFormat.format(users.getOrderItem().getBasket().get(i).getPrice()));
//                sum=sum+users.getOrderItem().getBasket().get(i).getPrice();
//            }
//        }
//        System.out.println("------------------------------------");
//        String value2=rb.getString("key3");
//        System.out.printf("%-25s %10s%n",value2,numberFormat.format(sum));
//    }

//    public void cleanBasket(){
//        users.getOrderItem().getBasket().clear();
//    }
}



