import dao.CategoryDAO;
import dao.OrderItemDAO;
import dao.ProductDAO;
import dao.UserDAO;
import input.InConsole;
import service.ActionStore;
import service.Service;
import ui.UIconsole;

public class Main {
    public static void main(String[] args) {
        Service service=new Service(new InConsole(),new UserDAO(),new CategoryDAO(),
                new ProductDAO(), new OrderItemDAO());
        ActionStore action = new ActionStore(new UIconsole(), new InConsole(),service);
        action.running();
    }
}
