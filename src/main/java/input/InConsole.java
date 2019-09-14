package input;

import java.util.Scanner;

public class InConsole implements In {
    Scanner scanner;
    @Override
    public String read() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
