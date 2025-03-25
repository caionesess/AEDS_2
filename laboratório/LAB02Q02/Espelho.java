import java.util.*;

public class Espelho{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);

        while(sc.hasNextLine()){
            String texto = sc.nextLine();
            separaString(texto);
            
        }
        sc.close();
    }

    public static void separaString(String texto){
        int cont = 0;
        String inicio = "";
        String fim = "";
        for(int i = 0; i < texto.length(); i++){
            if(texto.charAt(i) == ' '){
                cont++;
            } else if(cont == 0){
                inicio += texto.charAt(i);
            } else {
                fim += texto.charAt(i);
            }
        }
        int inicioInt = Integer.parseInt(inicio);
        int fimInt = Integer.parseInt(fim);
        espelhar(inicioInt, fimInt);
    }

    public static void espelhar (int inicio, int fim){
        StringBuilder crescente = new StringBuilder();
        for(int i = inicio; i <= fim; i++){
            crescente.append(i);
        }
        String invertida = new StringBuilder(crescente).reverse().toString();
        System.out.println(crescente.toString() + invertida);
    }
}