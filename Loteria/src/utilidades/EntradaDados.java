package utilidades;
import java.util.Scanner;
public class EntradaDados {
    //Classe de utilidade que implementa um scanner e metodos estaticos para separar responsabilidade
    private final static Scanner scan = new Scanner(System.in);

    public static String retornaString(){
        return scan.nextLine();
    }

    public static int retornaNumero(){
        return Integer.parseInt(scan.nextLine());
    }
}
