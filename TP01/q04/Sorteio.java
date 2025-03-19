package q04;

import java.util.*;

public class Sorteio {
    // realiza a substituição dos caracteres sorteados
    public static String substituir(String texto, char alvo, char novoChar, int tamanho) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            if (texto.charAt(i) == alvo) {
                resultado.append(novoChar); // adiciona o caractere substituído
            } else {
                resultado.append(texto.charAt(i)); // adiciona o caractere original
            }
        }
        return resultado.toString();
    }

    //método sobrecarregado que chama o método acima automaticamente com o tamanho da string
    public static String substituir(String texto, char alvo, char novoChar) {
        return substituir(texto, alvo, novoChar, texto.length());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //scanner para ler a entrada
        Random gerador = new Random();
        gerador.setSeed(4);//semente para gerar números aleatórios

        String texto;
        // continua lendo enquanto houver texto e a entrada não for "FIM"
        while (scanner.hasNextLine() && !(texto = scanner.nextLine()).equals("FIM")) {
            char letraOriginal = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            char letraSubstituta = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));

            // substitui os caracteres na texto atual e exibe o resultado
            String textoAlterado = substituir(texto, letraOriginal, letraSubstituta);
            System.out.println(textoAlterado);
        }
        scanner.close();
    }
}


