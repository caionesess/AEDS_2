package q11;

import java.util.*;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //scanner para ler a entrada
        String texto;
        // continua lendo enquanto houver linhas e a entrada não for "FIM"
        while(scanner.hasNextLine() && !(texto = scanner.nextLine()).equals("FIM")){
            int resultado = maisLonga(texto);
            System.out.println(resultado);
        }
        scanner.close();
    }

    public static int maisLonga(String texto) {
        int maisLonga = 0;
        StringBuilder subString = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            boolean repetido = false;
            int posicaoRepetido = -1; // posição do caractere repetido

            // verifica se o caractere já existe na substring
            for (int j = 0; j < subString.length(); j++) {
                if (subString.charAt(j) == c && !repetido) {
                    repetido = true;
                    posicaoRepetido = j;
                }
            }

            if (!repetido) {
                subString.append(c); // adiciona o caractere se não é repetido
                int tamAtual = subString.length();
                if (tamAtual > maisLonga) { // verifica se a substring atual é maior que a maior substring
                    maisLonga = tamAtual; 
                }
            } else {
                //se o caractere é repetido, remove ele e os caracteres anteriores
                subString.delete(0, posicaoRepetido + 1);
                subString.append(c); // adiciona o novo caractere após remover os anteriores
            }
        }
        return maisLonga;
    }
}