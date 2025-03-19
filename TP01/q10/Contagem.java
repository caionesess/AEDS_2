package q10;

import java.util.*;

public class Contagem {
     public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in); //scanner para ler a entrada
        String texto;
        // continua lendo enquanto houver linhas e a entrada não for "FIM"
        while(scanner.hasNextLine() && !(texto = scanner.nextLine()).equals("FIM")){
            int resultado = Contar(texto);
            System.out.println(resultado);
        }
        scanner.close();
    }

    public static int Contar(String texto) {
        int cont = 0;
        for(int i = 0; i < texto.length(); i++){
            char c = texto.charAt(i);
            if(c == ' '){ // se o caractere for um espaço, incrementa o contador
                cont++;
            }
        }
        return cont + 1; //retorna cont + 1, pois a última palavra não é seguida de espaço
    }
}
