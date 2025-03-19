package q20;

import java.util.*;

public class IsR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //scanner para ler a entrada
        String texto;

        // continua lendo enquanto houver linhas e a entrada não for "FIM"
        while (scanner.hasNextLine() && !(texto = scanner.nextLine()).equals("FIM")) {
            String palavra = Metodos(texto);
            System.out.println(palavra);
        }
        scanner.close();
    }

    public static String Metodos(String texto) {
        //cria um construtor de string para concatenar as respostas
        StringBuilder palavra = new StringBuilder();

        //verifica se é vogal
        if (Vogal(texto, 0)) {
            palavra.append("SIM ");
        } else {
            palavra.append("NAO ");
        }
        //verifica se é consoante
        if (Consoante(texto, 0)) {
            palavra.append("SIM ");
        } else {
            palavra.append("NAO ");
        }
        //verifica se é um número inteiro
        if (Inteiro(texto, 0)) {
            palavra.append("SIM ");
        } else {
            palavra.append("NAO ");
        }
        //verifica se é um número real
        if (Real(texto, 0, 0)) {
            palavra.append("SIM");
        } else {
            palavra.append("NAO");
        }

        return palavra.toString();//retorna a string com as respostas
    }

    private static boolean Vogal(String texto, int i) {
        if (i == texto.length()) {// caso base: percorreu toda a string
            return true;
        }
        char c = texto.charAt(i);
        if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
              c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')) {
            return false;// se encontrar um caractere que não seja vogal, retorna falso
        }
        return Vogal(texto, i + 1); //chamada recursiva para o próximo caractere
    }

    private static boolean Consoante(String texto, int i) {
        if (i == texto.length()) { //caso base: percorreu toda a string
            return true;
        }
        char c = texto.charAt(i);
        if (!(((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) && 
              (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' &&
               c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U'))) {
            return false; //se encontrar um caractere que não seja consoante, retorna falso
        }
        return Consoante(texto, i + 1);// chamada recursiva para o próximo caractere
    }

    private static boolean Inteiro(String texto, int i) {
        if (i == texto.length()) { //caso base: percorreu toda a string
            return true;
        }
        char c = texto.charAt(i);
        if (!(c >= '0' && c <= '9')) { 
            return false; // se encontrar um caractere que não seja número, retorna falso
        }
        return Inteiro(texto, i + 1); //chamada recursiva para o próximo caractere
    }

    private static boolean Real(String texto, int i, int ponto) {
        if (i == texto.length()) {// caso base: percorreu toda a string
            return ponto <= 1; //verifica se há no máximo um ponto ou vírgula
        }
        char c = texto.charAt(i);
        if (!(c >= '0' && c <= '9') && !(c == ',' || c == '.')) { 
            return false;//se encontrar um caractere que não seja número ou separador decimal, retorna falso
        }
        if (c == ',' || c == '.') { 
            ponto++; //incrementa o contador de pontos ou vírgulas
        }
        return Real(texto, i + 1, ponto); //chamada recursiva para o próximo caractere
    }
}

