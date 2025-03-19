package q13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.*;

public class Html {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner para ler a entrada
        boolean continuar = true;
        int[] ch = {225, 233, 237, 243, 250, 224, 232, 236, 242, 249, 227, 245, 226, 234, 238, 244, 251}; // códigos ASCII dos caracteres a serem contados

        // continua lendo enquanto houver linhas e a entrada não for "FIM"
        while (continuar && scanner.hasNextLine()) {
            String nomePagina = scanner.nextLine();

            if (nomePagina.equals("FIM")) {
                continuar = false; // encerra o loop na próxima iteração
            } else if (scanner.hasNextLine()) {
                String urlHtml = scanner.nextLine();
                String conteudoHtml = lerConteudoUrl(urlHtml);
                int[] cont = new int[25];

                // contagem dos padrões "<br>" e "<table>"
                cont[23] = contarOcorrencias(conteudoHtml, "<br>");
                cont[24] = contarOcorrencias(conteudoHtml, "<table>");

                // remover todas as ocorrências de <br> e <table> para não contar como caracteres
                conteudoHtml = conteudoHtml.replace("<br>", "").replace("<table>", "");

                for (int i = 0; i < conteudoHtml.length(); i++) {
                    char c = conteudoHtml.charAt(i);
                    switch (c) {
                        case 'a': cont[0]++; break;
                        case 'e': cont[1]++; break;
                        case 'i': cont[2]++; break;
                        case 'o': cont[3]++; break;
                        case 'u': cont[4]++; break;
                        case '\u00e1': cont[5]++; break; // á
                        case '\u00e9': cont[6]++; break; // é
                        case '\u00ed': cont[7]++; break; // í
                        case '\u00f3': cont[8]++; break; // ó
                        case '\u00fa': cont[9]++; break; // ú
                        case '\u00e0': cont[10]++; break; // à
                        case '\u00e8': cont[11]++; break; // è
                        case '\u00ec': cont[12]++; break; // ì
                        case '\u00f2': cont[13]++; break; // ò
                        case '\u00f9': cont[14]++; break; // ù
                        case '\u00e3': cont[15]++; break; // ã
                        case '\u00f5': cont[16]++; break; // õ
                        case '\u00e2': cont[17]++; break; // â
                        case '\u00ea': cont[18]++; break; // ê
                        case '\u00ee': cont[19]++; break; // î
                        case '\u00f4': cont[20]++; break; // ô
                        case '\u00fb': cont[21]++; break; // û
                        default:
                            if (c >= 'b' && c <= 'z' && c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                                cont[22]++;
                            }
                    }
                }

                // imprime a contagem de cada caractere e padrão
                System.out.printf("a(%d) e(%d) i(%d) o(%d) u(%d) %c(%d) %c(%d) %c(%d) %c(%d) %c(%d) %c(%d) %c(%d) %c(%d) %c(%d) %c(%d) %c(%d) %c(%d) %c(%d) %c(%d) %c(%d) %c(%d) %c(%d) consoante(%d) <br>(%d) <table>(%d) %s%n",
                    cont[0],cont[1],cont[2],cont[3],cont[4],(char)ch[0],
                    cont[5],(char)ch[1],cont[6],(char)ch[2],cont[7],(char)ch[3],cont[8],(char)ch[4],cont[9],
                    (char)ch[5],cont[10],(char)ch[6],cont[11],(char)ch[7],cont[12],(char)ch[8],cont[13],(char)ch[9],cont[14],
                    (char)ch[10],cont[15],(char)ch[11],cont[16],(char)ch[12],cont[17],(char)ch[13],cont[18],(char)ch[14],cont[19],
                    (char)ch[15],cont[20],(char)ch[16],cont[21],cont[22],
                    cont[23],cont[24],
                    nomePagina);
            } else {
                continuar = false; // encerra caso não tenha próxima linha após nomePagina
            }
        }

        scanner.close();
    }

    private static String lerConteudoUrl(String urlString) {
        StringBuilder resultado = new StringBuilder(); // inicializa um StringBuilder para armazenar o conteúdo da URL

        try {
            URI uri = new URI(urlString); // cria um objeto URI com a string fornecida
            URL url = uri.toURL();       // converte o URI em URL
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream())); // abre um stream para leitura

            String linha;
            while ((linha = reader.readLine()) != null) { // lê cada linha do conteúdo da URL
                resultado.append(linha).append("\n");     // adiciona a linha ao resultado com quebra de linha
            }

            reader.close(); // fecha o BufferedReader

        } catch (Exception e) { 
            System.err.println("Erro ao acessar URL: " + urlString + " - " + e.getMessage());
        }

        return resultado.toString(); 
    }

    private static int contarOcorrencias(String texto, String padrao) {
        int cont = 0;
        int comprimentoTexto = texto.length();
        int comprimentoPadrao = padrao.length();

        for (int i = 0; i <= comprimentoTexto - comprimentoPadrao; i++) {
            boolean corresponde = true;// assume que o padrão corresponde ao texto

            for (int j = 0; j < comprimentoPadrao && corresponde; j++) {// verifica se o padrão corresponde ao texto
                if (texto.charAt(i + j) != padrao.charAt(j)) {// se os caracteres não correspondem
                    corresponde = false;// o padrão não corresponde ao texto
                }
            }

            if (corresponde) {
                cont++;// incrementa o contador de ocorrências
            }
        }

        return cont;
    }
}
