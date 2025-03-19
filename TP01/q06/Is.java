package q06;

import java.util.*;

public class Is {
    public static void main (String[] args){
        Scanner scanner = new Scanner (System.in); //scanner para ler a entrada
        String texto;

        // continua lendo enquanto houver linhas e a entrada não for "FIM"
        while(scanner.hasNextLine() && !(texto = scanner.nextLine()).equals("FIM")){
            String palavra = Metodos(texto);
            System.out.println(palavra);
        }
        scanner.close();
    }

    public static String Metodos(String texto){
        //cria um construtor de string para concatenar as respostas
        StringBuilder palavra = new StringBuilder();

        //verifica se é vogal
        if(Vogal(texto)){
            palavra.append("SIM ");
        } else {
            palavra.append("NAO ");
        }
        //verifica se é consoante
        if(Consoante(texto)){
            palavra.append("SIM ");
        } else {
            palavra.append("NAO ");
        }
        //verifica se é um número inteiro
        if(Inteiro(texto)){
            palavra.append("SIM ");
        } else {
            palavra.append("NAO ");
        }
        //verifica se é u número real
        if(Real(texto)){
            palavra.append("SIM");
        } else {
            palavra.append("NAO");
        }

        return palavra.toString(); //retorna a string com as respostas
    }
    
    private static boolean Vogal(String texto){
        int cont = 0;
        for(int i = 0; i < texto.length(); i++){
            char c = texto.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                cont++;
            }
        }
        if(cont == texto.length()){ // verifica se todos os caracteres são vogais
            return true;
        } else {
            return false;
        }
    }
    
    private static boolean Consoante(String texto){
        int cont = 0;
        for(int i = 0; i < texto.length(); i++){
            char c = texto.charAt(i);
            if (((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) && (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U')){
                cont++;
            }
        }
        if(cont == texto.length()){ // verifica se todos os caracteres são consoantes
            return true;
        } else {
            return false;
        }
    }

    private static boolean Inteiro(String texto){ 
        int cont = 0;
        for(int i = 0; i < texto.length(); i++){
            char c = texto.charAt(i);
            if (c >= '0' && c <= '9'){
                cont++;
            }
        }
        if(cont == texto.length()){ // verifica se todos os caracteres são números
            return true;
        } else {
            return false;
        }
    }

    private static boolean Real(String texto){
        int cont = 0;
        int ponto = 0;
        for(int i = 0; i < texto.length(); i++){
            char c = texto.charAt(i);
            if (c >= '0' && c <= '9'){
                cont++;
            } else if (c == ',' || c == '.'){
                cont++;
                ponto++;
            }
        }
        // verifica se todos os caracteres são número e se há no máximo um ponto ou vírgula
        if((cont == texto.length()) && (ponto <= 1)){
            return true;
        } else {
            return false;
        }
    }
}
