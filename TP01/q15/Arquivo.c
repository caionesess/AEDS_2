#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;// n valores a serem lidos
    double valor;// armazena os valores

    //quantidade de números que serão gravados
    scanf("%d", &n);

    //abre o arquivo para escrita
    FILE *arquivo = fopen("numeros.bin", "wb");
    if (arquivo == NULL) {
        perror("Erro ao abrir arquivo p/ escrita");
        return 1; // encerra o programa com erro
    }

    //lê os valores e grava no arquivo
    for (int i = 0; i < n; i++) {
        scanf("%lf", &valor);
        fwrite(&valor, sizeof(double), 1, arquivo); //escreve o número no arquivo
    }

    fclose(arquivo); //fecha o arquivo

    //abre o arquivo para leitura
    arquivo = fopen("numeros.bin", "rb");
    if (arquivo == NULL) {
        perror("Erro ao abrir arquivo p/ leitura");
        return 1; // encerra o programa com erro
    }

    //posiciona o ponteiro do arquivo no último valor gravado
    fseek(arquivo, -sizeof(double), SEEK_END);

    //lê e imprime os valores do final p/ o início
    for (int i = 0; i < n; i++) {
        fread(&valor, sizeof(double), 1, arquivo); //lê um número do arquivo
        
        // %g remove zeros desnecessários
        printf("%g\n", valor);

        // move o ponteiro do arquivo para o próximo número (de trás para frente)
        fseek(arquivo, -2 * sizeof(double), SEEK_CUR);
    }

    fclose(arquivo); //fecha o arquivo

    return 0;
}