#include <stdio.h>
#include <string.h>
#include <ctype.h>

// função recursiva que soma os dígitos numéricos da string
int Somar(char texto[], int i) {
    // passo base: se índice for igual ao comprimento da string, retorna 0
    if (i == strlen(texto)) {
        return 0;
    }
    char c = texto[i];
    int valor = isdigit(c) ? c - '0' : 0; // verifica se o caractere é um dígito antes de somar
    return valor + Somar(texto, i + 1); 
    // chama a função recursivamente para o próximo caractere
}

int main() {
    char texto[1000];

    // scanner para ler a entrada
    while (fgets(texto, sizeof(texto), stdin)) {
        texto[strcspn(texto, "\n")] = '\0'; // remove a quebra de linha do final da string

        // continua lendo enquanto houver linhas e a entrada não for "FIM"
        if (strcmp(texto, "FIM") != 0) {
            int resultado = Somar(texto, 0);
            printf("%d\n", resultado);
        }
    }

    return 0;
}
