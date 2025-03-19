package q16;

import java.util.*;

public class PalindromoR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //scanner para ler a entrada
        String texto;
        
        // continua lendo enquanto houver linhas e a entrada não for "FIM"
        while (scanner.hasNextLine() && !(texto = scanner.nextLine()).equals("FIM")) {
            boolean ehPalindromo = verificarPalindromo(texto, 0, texto.length() - 1);
            
            if (ehPalindromo) { //imprime a resposta
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
        }
        
        scanner.close();
    }
    
    public static boolean verificarPalindromo(String texto, int inicio, int fim) {
        if (inicio >= fim) { //caso base: se os índices se cruzarem ou forem iguais
            return true; //se chegou aqui, é um palíndromo
        }
        
        if (texto.charAt(inicio) != texto.charAt(fim)) { //compara os caracteres
            return false; //se forem diferentes retorna falso
        }
        
        return verificarPalindromo(texto, inicio + 1, fim - 1); //chamada recursiva com índices ajustados
    }
}

