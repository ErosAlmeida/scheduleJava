import java.util.Scanner;

public class Console {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readString() {
        return SCANNER.nextLine();
    }
    public static char readChar() {
        return SCANNER.nextLine().charAt(0);
    }
    public static int readInt() {
        String str = readString();

        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException(
                    str + " não é um int válido"
            );
        }
    }
}


