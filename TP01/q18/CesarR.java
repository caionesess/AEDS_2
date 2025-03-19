package q18;

import java.util.*;

public class CesarR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//scanner para ler a entrada
        String texto;
        // enquanto houver linhas de texto e a linha não for "FIM"
        while (scanner.hasNextLine() && !(texto = scanner.nextLine()).equalsIgnoreCase("FIM")) {
            String textoCifrado = cifrar(texto);
            System.out.println(textoCifrado);
        }
        scanner.close();
    }

    public static String cifrar(String texto) {
        return cifrarRecursivo(texto, 0, new StringBuilder());//chama o método recursivo
    }

    private static String cifrarRecursivo(String texto, int indice, StringBuilder resultado) {
        if (indice == texto.length()) {//se o indice for igual ao tamanho do texto, retorna o texto cifrado
            return resultado.toString();//retorna o texto cifrado
        }
        
        char caractere = texto.charAt(indice);//pega o caractere na posição indice
        
        if (caractere > '~') {
            resultado.append(caractere);//se for um caracter especial, não cifra
        } else {
            resultado.append((char) (caractere + 3));//soma 3 ao valor do caracter
        }
        
        return cifrarRecursivo(texto, indice + 1, resultado);//chama o método recursivo
    }
}


