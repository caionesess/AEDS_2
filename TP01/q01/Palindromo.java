package q01;

import java.util.*;

public class Palindromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //scanner para ler a entrada
        String texto;
        
        // continua lendo enquanto houver linhas e a entrada não for "FIM"
        while (scanner.hasNextLine() && !(texto = scanner.nextLine()).equals("FIM")) {
            boolean ehPalindromo = verificarPalindromo(texto);
            
            if (ehPalindromo) { //imprime a resposta
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
        }
        
        scanner.close();
    }
    
    public static boolean verificarPalindromo(String texto) {
        int inicio = 0;//inicializa os índices
        int fim = texto.length() - 1;
        
        while (inicio < fim) {
            if (texto.charAt(inicio) != texto.charAt(fim)) {//compara os caracteres
                return false;// se forem diferentes retorna falso
            }
            inicio++;//se forem iguais anda com os índices
            fim--;
        }
        
        return true;//se a palavra for de fato um palíndromo retorna verdadeiro
    }
}


