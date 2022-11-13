package loteria;
import java.util.List;
import java.util.Random;

public class Sorteio {
    // Classe que cuida exclusivamente do retorno de numeros
    private int[] numerosSorteados;
    private int limite;
    private Random rand = new Random();

    public Sorteio(int quantidadeNumeros, int limite){
        this.numerosSorteados = new int[quantidadeNumeros];
        this.limite = limite;
    }
    
    private boolean verificaRepeticao(int numero){
        for(int j = 0; j < numerosSorteados.length; j++){
            if(numerosSorteados[j] == numero){
                return true;
            }
        }
        return false;
    }
    
    public int[] realizaSorteio(){
        int i = 0;
        do{
            int numero = rand.nextInt(limite);
            if(!verificaRepeticao(numero)){
                numerosSorteados[i] = numero;
                System.out.println(numerosSorteados[i]);
                i++;
            }
        } while (i < numerosSorteados.length);
        return numerosSorteados;
    }
}
