import input.InConsole;
import service.ActionStore;
import ui.UIconsole;

public class Main {
    public static void main(String[] args) {
        ActionStore action = new ActionStore(new UIconsole(), new InConsole());
        action.newProduct();
        action.createUserMap();
        action.running();
    }
}
