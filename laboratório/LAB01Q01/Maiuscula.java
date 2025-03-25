package LAB01Q01;

import java.util.*;

public class Maiuscula {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String texto = sc.nextLine();
            if(!(texto.equals("FIM")) && !(texto.isEmpty())){
                confereMaiuscula(texto);
            }
        }
        sc.close();
    }

    public static void confereMaiuscula(String texto){
        int cont = 0;
        for(int i = 0; i < texto.length(); i++){
            if(texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z'){
                cont++;
            }
        }
        System.out.println(cont);
    }
}
