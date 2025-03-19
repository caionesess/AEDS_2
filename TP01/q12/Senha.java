package q12;

import java.util.*;

public class Senha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //scanner para ler a entrada
        String texto;
        // continua lendo enquanto houver linhas e a entrada não for "FIM"
        while(scanner.hasNextLine() && !(texto = scanner.nextLine()).equals("FIM")){
            String resultado = ehValida(texto);
            System.out.println(resultado);
        }
        scanner.close();
    }

    public static String ehValida(String texto){
        boolean condicoes[] = new boolean[5]; // array de booleanos
        condicoes[0] = texto.length() >= 8; // registro 0 = tamanho maior ou igual a 8
        for(int i = 0; i < texto.length(); i++){
            char c = texto.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                condicoes[1] = true; //registro 1 = tem letra maiúscula
            } else if(c >= 'a' && c <= 'z'){
                condicoes[2] = true; //registro 2 = tem letra minúscula
            } else if(c >= '0' && c <= '9'){
                condicoes[3] = true; //registro 3 = tem número
            } else if (c >= '!' && c <= '/' || c >= ':' && c <= '@' || c >= '[' && c <= '`' || c >= '{' && c <= '~'){
                condicoes[4] = true; //registro 4 = tem caractere especial
            }
        }
        for(int i = 0; i < condicoes.length; i++){
            if(!condicoes[i]){
                return "NAO"; //se alguma condição não for atendida, retorna "NAO"
            }
        }
        return "SIM";
    }
}
