#include <stdio.h>
#include <string.h>

// função para verificar se uma string é um palíndromo
int verificarPalindromo(char texto[]) {
    int inicio = 0;
    int fim = strlen(texto) - 1;

    while (inicio < fim) {
        /* 
        a tabela ASCII só tem letras simples mas o UTF-8 inclui letras com acento e símbolos especiais:
        0xxx xxxx (0-127): caracteres ASCII padrão
        110x xxxx 10xx xxxx (128-2047): caracteres de 2 bytes
        caso o caractere seja uma letra especial, pula para o próximo
        */
        while ((texto[inicio] & 0xC0) == 0x80) 
            inicio++;
        while ((texto[fim] & 0xC0) == 0x80) 
            fim--;
        if (texto[inicio] != texto[fim]) {
            return 0; //se forem diferentes retorna falso
        }
        inicio++;
        fim--;
    }
    return 1; //se a palavra for um palíndromo retorna verdadeiro
}

int main() {
    char texto[500];

    //"flag" de continuação para o loop
    int continuar = 1;
    while (continuar && fgets(texto, 500, stdin)) { //enquanto continuar e houver linhas de entrada
        int tamanho = strlen(texto);

        if (tamanho > 0 && texto[tamanho - 1] == '\n') { //se a ultima posição for quebra de linha, substitui por "null"
            texto[tamanho - 1] = '\0';
        }
        
        //se a string for "FIM" troca o estado de continuar para 0
        if (strcmp(texto, "FIM") == 0) {
            continuar = 0;
        } else {
            int ehPalindromo = verificarPalindromo(texto);
            if (ehPalindromo) {
                printf("SIM\n");
            } else {
                printf("NAO\n");
            }
        }
    }
    

    return 0;
}