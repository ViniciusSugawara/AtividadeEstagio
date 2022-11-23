package dominio;

public class Bilhete {
    //Classe de dominio do bilhete
    private int[] numeros;

    public int[] getNumeros() {
        return numeros;
    }
    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }
    public String retornaNumeros(){
        String numerosBilhete = "";
        for(int numero : this.numeros){
            numerosBilhete += numero + ", ";
        }
        return numerosBilhete.substring(0, numerosBilhete.length() - 2);
    }
}
