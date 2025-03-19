package q08;

import java.util.*;

public class Soma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner para ler a entrada
        String texto;
        // continua lendo enquanto houver linhas e a entrada não for "FIM"
        while (scanner.hasNextLine() && !(texto = scanner.nextLine()).equals("FIM")) {
            int resultado = Somar(texto, 0);
            System.out.println(resultado);
        }
        scanner.close();
    }

    public static int Somar(String texto, int i) {
        // passo base: se índice for igual ao comprimento da string, retorna 0
        if (i == texto.length()) {
            return 0;
        }
        char c = texto.charAt(i);
        int valor = c - '0'; //'0' tem o valor ASCII 48, então subtraindo '0' de qualquer     dígito de 0 a 9, obtemos o valor numérico
        return valor + Somar(texto, i + 1);
        // chama a função recursivamente para o próximo caractere
    }
}
