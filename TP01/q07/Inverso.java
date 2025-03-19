package q07;

import java.util.*;

public class Inverso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in); //scanner para ler a entrada
        String texto;
        // continua lendo enquanto houver linhas e a entrada não for "FIM"
        while(scanner.hasNextLine() && !(texto = scanner.nextLine()).equals("FIM")){
            String palavraInvertida = Inverter(texto);
            System.out.println(palavraInvertida);
        }
        scanner.close();
    }

    public static String Inverter(String texto){
        // cria um construtor de string para armazenar a string invertida
        StringBuilder palavraInvertida = new StringBuilder();

        // percorre a string de trás para frente e adiciona cada caractere ao construtor
        for(int i = texto.length() - 1; i >= 0; i--){
            char c = texto.charAt(i);
            palavraInvertida.append(c);
        }
        return palavraInvertida.toString();
    }
}