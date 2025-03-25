package P01Q01;

import java.util.*;

public class Natal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] idiomas = new String[n];
        String[] mensagens = new String[n];
        for(int i = 0; i < n; i++){
            idiomas[i] = sc.nextLine();
            mensagens[i] = sc.nextLine();
        }

        int m = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < m; i++){
            String nome = sc.nextLine();
            String idioma = sc.nextLine();
            System.out.println(nome);
            System.out.println(acharMensagem(idiomas, mensagens, idioma));
            System.out.println();
        }
        sc.close();
    }
    public static String acharMensagem(String[] idiomas, String[] mensagens, String idioma){
        for(int i = 0; i < idiomas.length; i++){
            if(idiomas[i].equals(idioma)){
                return mensagens[i];
            }
        }
        return "Idioma nao encontrado";
    }
}
