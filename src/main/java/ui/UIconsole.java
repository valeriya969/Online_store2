package ui;

public class UIconsole implements UI {
    @Override
    public void start() {
        System.out.println("Hello! It's online-store!");
    }

    @Override
    public void menu(String a) {
        if (a.equals("1")){
            System.out.println("Input login");
            System.out.println("Input password");
        }else if (a.equals("2")){
            System.out.println("1-Women's clothing 2-Men's clothing 3-back 4-show Basket 5-to buy");
        }else if (a.equals("3")){
            System.out.println("We will be glad to see you again!");
        }
    }

    @Override
    public void end() {
    }
}
