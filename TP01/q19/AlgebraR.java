package q19;

import java.util.*;

public class AlgebraR {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        preencherMapaBool(texto, arrayBool, 0, tamanho * 2 + 1, 0);
        return arrayBool;
    }

    static void preencherMapaBool(String texto, boolean[] arrayBool, int i, int max, int cont) {
        if (i >= max) {
            return;
        }
        if (texto.charAt(i) == '1') {
            arrayBool[cont] = true;
            preencherMapaBool(texto, arrayBool, i + 1, max, cont + 1);
        } else if (texto.charAt(i) == '0') {
            arrayBool[cont] = false;
            preencherMapaBool(texto, arrayBool, i + 1, max, cont + 1);
        } else {
            preencherMapaBool(texto, arrayBool, i + 1, max, cont);
        }
    }

    static String substituirOperadores(String texto, boolean[] arrayBool) {
        texto = substituirAND(texto);
        texto = substituirNOT(texto);
        texto = substituirOR(texto);
        texto = obterValorBool(texto, arrayBool);
        return limpaString(texto);
    }

    static String substituirAND(String texto) {
        return texto.replace("and", "^");
    }

    static String substituirNOT(String texto) {
        return texto.replace("not", "!");
    }

    static String substituirOR(String texto) {
        return texto.replace("or", "V");
    }

    static String obterValorBool(String texto, boolean[] arrayBool) {
        StringBuilder textoNovo = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char elemento = texto.charAt(i);
            if (elemento == 'A') {
                textoNovo.append(arrayBool[0] ? '1' : '0');
            } else if (elemento == 'B' && arrayBool.length > 1) {
                textoNovo.append(arrayBool[1] ? '1' : '0');
            } else if (elemento == 'C' && arrayBool.length > 2) {
                textoNovo.append(arrayBool[2] ? '1' : '0');
            } else {
                textoNovo.append(elemento);
            }
        }
        return textoNovo.toString();
    }

    static String limpaString(String texto) {
        return limpaStringRec(texto, 0, new StringBuilder()).toString();
    }

    static StringBuilder limpaStringRec(String texto, int i, StringBuilder textoNovo) {
        if (i >= texto.length()) {
            return textoNovo;
        }
        char c = texto.charAt(i);
        if (c != ' ' && c != ',') {
            textoNovo.append(c);
        }
        return limpaStringRec(texto, i + 1, textoNovo);
    }

    static String calculaExpressaoBool(String texto) {
        return calculaExpressaoBoolRec(texto, texto.length() - 1);
    }

    static String calculaExpressaoBoolRec(String texto, int i) {
        if (i < 0) {
            return texto;
        }
        char operadorAtual = texto.charAt(i);
        if (operadorAtual == '^') {
            texto = fazAND(texto, i);
        } else if (operadorAtual == 'V') {
            texto = fazOR(texto, i);
        } else if (operadorAtual == '!') {
            texto = fazNOT(texto, i);
        }
        return calculaExpressaoBoolRec(texto, i - 1);
    }

    static String fazAND(String texto, int indice) {
        return fazANDRec(texto, indice, 0, 0, new StringBuilder(), 0);
    }

    static String fazANDRec(String texto, int indice, int i, int contDigitos, StringBuilder textoNovo, int positivos) {
        if (i >= texto.length()) {
            return textoNovo.toString();
        }
        if (i == indice) {
            int indiceAtual = indice;
            while (indiceAtual < texto.length() && texto.charAt(indiceAtual) != ')') {
                char c = texto.charAt(indiceAtual);
                if (ehNumero(c)) {
                    contDigitos++;
                    if (c == '1') positivos++;
                }
                indiceAtual++;
            }
            textoNovo.append((positivos == contDigitos) ? '1' : '0');
            return fazANDRec(texto, indice, indiceAtual + 1, contDigitos, textoNovo, positivos);
        } else {
            textoNovo.append(texto.charAt(i));
            return fazANDRec(texto, indice, i + 1, contDigitos, textoNovo, positivos);
        }
    }

    static String fazOR(String texto, int indice) {
        return fazORRec(texto, indice, 0, 0, new StringBuilder(), 0);
    }

    static String fazORRec(String texto, int indice, int i, int contDigitos, StringBuilder textoNovo, int positivos) {
        if (i >= texto.length()) {
            return textoNovo.toString();
        }
        if (i == indice) {
            int indiceAtual = indice;
            while (indiceAtual < texto.length() && texto.charAt(indiceAtual) != ')') {
                char c = texto.charAt(indiceAtual);
                if (ehNumero(c)) {
                    contDigitos++;
                    if (c == '1') positivos++;
                }
                indiceAtual++;
            }
            textoNovo.append((positivos > 0) ? '1' : '0');
            return fazORRec(texto, indice, indiceAtual + 1, contDigitos, textoNovo, positivos);
        } else {
            textoNovo.append(texto.charAt(i));
            return fazORRec(texto, indice, i + 1, contDigitos, textoNovo, positivos);
        }
    }

    static String fazNOT(String texto, int indice) {
        return fazNOTRec(texto, indice, 0, 0, new StringBuilder());
    }

    static String fazNOTRec(String texto, int indice, int i, int contDigitos, StringBuilder textoNovo) {
        if (i >= texto.length()) {
            return textoNovo.toString();
        }
        if (i == indice) {
            while (indice < texto.length() && texto.charAt(indice) != ')') {
                char c = texto.charAt(indice);
                if (ehNumero(c)) {
                    contDigitos++;
                    textoNovo.append(c == '1' ? '0' : '1');
                }
                indice++;
            }
            return fazNOTRec(texto, indice, indice + contDigitos + 3, contDigitos, textoNovo);
        } else {
            textoNovo.append(texto.charAt(i));
            return fazNOTRec(texto, indice, i + 1, contDigitos, textoNovo);
        }
    }

    static boolean ehNumero(char c) {
        return Character.isDigit(c);
    }

    static boolean ehEspaco(char c) {
        return Character.isDigit(c) || c == '.' || c == ' ' || c == ',';
    }
}