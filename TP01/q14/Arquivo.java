package q14;

import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.*;

public class Arquivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.US); //separador decimal é o ponto e não a vírgula

        int n = scanner.nextInt();

        try {
            //cria um arquivo para escrita
            RandomAccessFile raf = new RandomAccessFile("pub.out", "rw");

            //escreve os valores no arquivo
            for (int i = 0; i < n; i++) {
                double valor = scanner.nextDouble(); //lê o valor
                raf.writeDouble(valor);//escreve o valor no arquivo
            }
            raf.close();//fecha o arquivo

            raf = new RandomAccessFile("pub.out", "r");//abre o arquivo para leitura
            long posicao = raf.length() - 8;//posição do último valor

            //lê os valores do arquivo
            while (posicao >= 0) {
                raf.seek(posicao);//posiciona o ponteiro no valor
                double valorLido = raf.readDouble();//lê o valor
                if(valorLido % 1 == 0){//verifica se o valor é inteiro
                    System.out.println((int)valorLido); //imprime o valor sem a parte decimal
                }else{
                    System.out.println(valorLido);//imprime o valor
                }
                posicao -= 8;//posiciona o ponteiro para o próximo valor. subtrai 8 bytes pois é o tamanho de um double
            }

            raf.close();//fecha o arquivo
        } catch (IOException e) {//trata exceções de I/O
            e.printStackTrace();// imprime nome da exceção, mensagem de erro e sequência das chamadas de métodos que deram erro
        }

        scanner.close();
    }
}


