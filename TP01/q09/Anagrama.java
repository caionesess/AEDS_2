package q09;

import java.util.*;

public class Anagrama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in); //scanner para ler a entrada
        String texto;
        int A = 195; // valor de Ã em ASCII
        // continua lendo enquanto houver linhas e a entrada não for "FIM"
        while(scanner.hasNextLine() && !(texto = scanner.nextLine()).equals("FIM")){
            boolean resultado = Separar(texto);
            if(resultado){
                System.out.println("SIM");
            } else {
                System.out.println("N" + (char)A + "O");
            }
        }
        scanner.close();
    }

    public static boolean Separar(String texto){
        // cria duas strings vazias
        StringBuilder palavraUm = new StringBuilder();
        StringBuilder palavraDois = new StringBuilder();

        for(int i = 0; texto.charAt(i) != ' '; i++){ // enquanto o caractere não for um espaço, adiciona o caractere à primeira string
            palavraUm.append(texto.charAt(i));
        }
        // cria um contador para contar os espaços
        int cont = 0;
        for(int i = 0; i < texto.length(); i++){ 
            if(texto.charAt(i) == ' '){
                cont++;
            } else if(cont == 2){ // pega a string a partir do segundo espaço
                palavraDois.append(texto.charAt(i)); 
            }
        }
        // retorna o resultado da função ehAnagrama
        return ehAnagrama(palavraUm.toString(), palavraDois.toString());
    }

    public static boolean ehAnagrama(String palavraUm, String palavraDois) {
        // se o tamanho das strings forem diferentes, retorna "NAO"
        if (palavraUm.length() != palavraDois.length()) {
            return false;
        }
        // cria um vetor onde cada registro corresponde a uma letra do alfabeto
        int[] contagem = new int[26];
        // percorre as strings
        for (int i = 0; i < palavraUm.length(); i++) {
            // transforma o caractere em um número de 0 a 25
            int contUm = transformaChar(palavraUm.charAt(i));
            int contDois = transformaChar(palavraDois.charAt(i));
            
            if (contUm != -1) {
                contagem[contUm]++; // incrementa o contador da letra
            }
            
            if (contDois != -1) {
                contagem[contDois]--; // decrementa o contador da letra
            }
        }//com essa lógica, se as strings forem anagramas, todos os registros do vetor serão 0
        
        for (int i = 0; i < contagem.length; i++) { // se algum registro for diferente de 0, retorna "NAO"
            if (contagem[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    private static int transformaChar(char c) {
        // transforma os caracteres maiusculos e minusculos em um número de 0 a 25
        if (c >= 'A' && c <= 'Z') {
            return c - 'A'; // retorna a posição da letra no alfabeto
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a'; // retorna a posição da letra no alfabeto
        }
        return -1; // caractere não alfabético
    }
}
