package LAB01Q02;

import java.util.*;

public class MaiusculaRec {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String texto = sc.nextLine();
            if(!(texto.equals("FIM")) && !(texto.isEmpty())){
                System.out.println(confereMaiuscula(texto, 0));
            }
        }
        sc.close();
    }

    public static int confereMaiuscula(String texto, int index){
        if (index >= texto.length()) {
            return 0; // Caso base: fim da string
        }
        int count = (texto.charAt(index) >= 'A' && texto.charAt(index) <= 'Z') ? 1 : 0;
        return count + confereMaiuscula(texto, index + 1); // Chamada recursiva
    }
}
