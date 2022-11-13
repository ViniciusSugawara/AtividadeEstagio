package loteria;
import java.util.Scanner;
public class EntradaDados {
    private final static Scanner scan = new Scanner(System.in);

    public static String retornaString(){
        return scan.nextLine();
    }

    public static int retornaNumero(){
        return scan.nextInt();
    }
}
