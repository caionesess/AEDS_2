package q03;

import java.util.*;

public class Cesar {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String texto;

        // enquanto houver linhas de texto e a linha não for "FIM"
        while (scanner.hasNextLine() && !(texto = scanner.nextLine()).equalsIgnoreCase("FIM")) {
            String textoCifrado = cifrar(texto);
            System.out.println(textoCifrado);
        }
        scanner.close();
    }

    public static String cifrar(String texto) {
        String resultado = ""; // variável que armazenará o texto cifrado
        
        int tam = texto.length();
		int letra ;// variável que armazenará o valor da letra cifrada
		for(int i = 0;  i < tam; i++){
            if(texto.charAt(i) > '~'){
                resultado = resultado + texto.charAt(i);//se for um caracter especial, não cifra
                continue; 
            }
		    letra = (int)texto.charAt(i) + 3;//soma 3 ao valor do caracter
			resultado = resultado + (char)letra; //concatena o caracter cifrado
		}
		return resultado.toString();//retorna o texto cifrado
    }
}

