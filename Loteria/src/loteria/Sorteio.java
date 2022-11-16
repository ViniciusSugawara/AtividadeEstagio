package loteria;
import java.util.Random;

public class Sorteio {
    // Classe que cuida exclusivamente do retorno de numeros
    private int[] numerosSorteados;
    private int numeroMaximo;
    private Random rand = new Random();

    public Sorteio(int quantiaNumerosSorteados, int numeroMaximo){
        this.numerosSorteados = new int[quantiaNumerosSorteados];
        this.numeroMaximo = numeroMaximo;
    }
    
    private boolean verificaRepeticao(int numero){
        for(int i = 0; i < numerosSorteados.length; i++){
            if(numerosSorteados[i] == numero){
                return true;
            }
        }
        return false;
    }
    
    public void realizaSorteio(){
        int i = 0;
        do{
            int numero = rand.nextInt(numeroMaximo);
            if(!verificaRepeticao(numero)){
                numerosSorteados[i] = numero;
                i++;
            }
        } while (i < numerosSorteados.length);
        System.out.println(numerosSorteados[i - 1]);
    }

    public int[] getNumerosSorteados(){
        return this.numerosSorteados;
    }

    public String retornaNumerosSorteados(){
        String resultado = "";
        for(int numero : numerosSorteados){
            resultado += numero + ", ";
        }
        return resultado.substring(0, resultado.length()-2);
    }
}
