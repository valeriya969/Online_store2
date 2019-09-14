package service;

public class UserCheck {
    public static boolean verify(String login, String password) {
        try {
            if (login.length()>20){
                throw new WrongLoginException("Your login is more than 20 symbols");
            }
            if(password.length()>20) {
                throw new WrongPasswordException("Wrong password");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }finally {
            System.out.printf("Login %s, password %s%n",login,password);
        }
        return true;
    }
}
