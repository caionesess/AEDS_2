package q05;

import java.util.*;

public class Algebra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//scanner para ler a entrada
        while (true) {
            String texto = scanner.nextLine();

            // verifica se a entrada é "0" para encerrar o programa
            if (ehZero(texto)) {
                scanner.close();
                break;
            }

            // obtém o mapa booleano a partir do texto
            boolean[] mapaBool = obterMapaBool(texto);
            // substitui os operadores e valores booleanos no texto
            texto = substituirOperadores(texto, mapaBool);
            // calcula a expressão booleana e imprime o resultado
            System.out.println(calculaExpressaoBool(texto));
        }
    }

    static boolean ehZero(String texto) {
        // verifica se o texto é "0"
        return texto.equals("0");
    }

    static boolean[] obterMapaBool(String texto) {
        // obtém o tamanho do mapa booleano a partir do primeiro caractere do texto
        int tamanho = Integer.parseInt(String.valueOf(texto.charAt(0)));
        boolean[] arrayBool = new boolean[tamanho];
        int cont = 0;

        // preenche o array booleano com os valores do texto
        for (int i = 0; i < tamanho * 2 + 1; i++) {
            if (texto.charAt(i) == '1') {
                arrayBool[cont++] = true;
            } else if (texto.charAt(i) == '0') {
                arrayBool[cont++] = false;
            }
        }
        return arrayBool;
    }

    static String substituirOperadores(String texto, boolean[] arrayBool) {
        // substitui os operadores lógicos no texto
        texto = substituirAND(texto);
        texto = substituirNOT(texto);
        texto = substituirOR(texto);
        // substitui os valores booleanos no texto
        texto = obterValorBool(texto, arrayBool);
        // limpa a string de espaços e vírgulas
        return limpaString(texto);
    }

    static String substituirAND(String texto) {
        // substitui "and" por "^"
        return texto.replace("and", "^");
    }

    static String substituirNOT(String texto) {
        // substitui "not" por "!"
        return texto.replace("not", "!");
    }

    static String substituirOR(String texto) {
        // substitui "or" por "V"
        return texto.replace("or", "V");
    }

    static String obterValorBool(String texto, boolean[] arrayBool) {
        String textoNovo = "";
        int qtd = arrayBool.length;

        // substitui as variáveis booleanas pelos seus valores no array
        for (char elemento : texto.toCharArray()) {
            if (elemento == 'A') {
                textoNovo += arrayBool[0] ? '1' : '0';
            } else if (elemento == 'B' && qtd > 1) {//verifica se a quantidade de variáveis é maior que 1
                textoNovo += arrayBool[1] ? '1' : '0';
            } else if (elemento == 'C' && qtd > 2) {
                textoNovo += arrayBool[2] ? '1' : '0';
            } else {
                textoNovo += elemento;//se não for uma variável, mantém o caractere
            }
        }
        return textoNovo;
    }

    static String limpaString(String texto) {
        String textoNovo = "";
        int indiceNovo = 0;

        // remove espaços e vírgulas do início da string
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == 'V' || texto.charAt(i) == '!' || texto.charAt(i) == '^') {
                indiceNovo = i;
                break;
            }
            if (!ehEspaco(texto.charAt(i))) {
                textoNovo += texto.charAt(i);
            }
        }

        // remove espaços e vírgulas do restante da string
        for (int i = indiceNovo; i < texto.length(); i++) {
            if (texto.charAt(i) != ' ' && texto.charAt(i) != ',')
                textoNovo += texto.charAt(i);
        }
        return textoNovo;
    }

    static String calculaExpressaoBool(String texto) {
        // conta a quantidade de operadores na expressão
        int operadoresQtd = 0;
        for (int i = 0; i < texto.length(); i++)
            if ("^V!".indexOf(texto.charAt(i)) >= 0)
                operadoresQtd++;

        // armazena os índices dos operadores na expressão
        int[] indicesOperadores = new int[operadoresQtd];
        int posicaoIndice = 0;

        for (int i = texto.length() - 1; i >= 0; i--)
            if ("^V!".indexOf(texto.charAt(i)) >= 0)
                indicesOperadores[posicaoIndice++] = i;

        // aplica os operadores na expressão
        for (int i : indicesOperadores) {
            char operadorAtual = texto.charAt(i);

            if (operadorAtual == '^')
                texto = fazAND(texto, i);
            else if (operadorAtual == 'V')
                texto = fazOR(texto, i);
            else if (operadorAtual == '!')
                texto = fazNOT(texto, i);
        }

        return texto;
    }

    static String fazAND(String texto, int indice) {
        StringBuilder textoNovo = new StringBuilder();
        int i = 0;

        // aplica o operador AND na expressão
        while (i < texto.length()) {
            if (i == indice) {
                int contDigitos = 0, positivos = 0;
                int indiceAtual = indice;

                while (texto.charAt(indiceAtual) != ')') {
                    char c = texto.charAt(indiceAtual);
                    if (ehNumero(c)) {
                        contDigitos++;
                        if (c == '1') positivos++;
                    }
                    indiceAtual++;
                }
                textoNovo.append((positivos == contDigitos) ? '1' : '0');
                i = indiceAtual + 1;
            } else {
                textoNovo.append(texto.charAt(i));
                i++;
            }
        }
        return textoNovo.toString();
    }

    static String fazOR(String texto, int indice) {
        StringBuilder textoNovo = new StringBuilder();
        int i = 0;

        // aplica o operador OR na expressão
        while (i < texto.length()) {
            if (i == indice) {
                int contDigitos = 0, positivos = 0;
                int indiceAtual = indice;

                while (texto.charAt(indiceAtual) != ')') {
                    char c = texto.charAt(indiceAtual);
                    if (ehNumero(c)) {
                        contDigitos++;
                        if (c == '1') positivos++;
                    }
                    indiceAtual++;
                }
                textoNovo.append((positivos > 0) ? '1' : '0');
                i += contDigitos + 3;
            } else {
                textoNovo.append(texto.charAt(i));
                i++;
            }
        }
        return textoNovo.toString();
    }

    static String fazNOT(String texto, int indice) {
        StringBuilder textoNovo = new StringBuilder();
        int i = 0;

        // aplica o operador NOT na expressão
        while (i < texto.length()) {
            if (i == indice) {
                int contDigitos = 0;
                while (texto.charAt(indice) != ')') {
                    char c = texto.charAt(indice);
                    if (ehNumero(c)) {
                        contDigitos++;
                        textoNovo.append(c == '1' ? '0' : '1');
                    }
                    indice++;
                }
                i += contDigitos + 3;
            } else {
                textoNovo.append(texto.charAt(i));
                i++;
            }
        }
        return textoNovo.toString();
    }

    static boolean ehNumero(char c) {
        // verifica se o caractere é um dígito
        return Character.isDigit(c);
    }

    static boolean ehEspaco(char c) {
        // verifica se o caractere é um dígito, ponto, espaço ou vírgula
        return Character.isDigit(c) || c == '.' || c == ' ' || c == ',';
    }
}


