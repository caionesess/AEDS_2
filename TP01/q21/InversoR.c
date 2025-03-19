#include <stdio.h>
#include <string.h>

void inverter(char texto[], int i) {
    if (i < 0) { // caso base: se o índice for menor que 0,
        return;// encerra a função
    }
    printf("%c", texto[i]);// imprime o caractere na posição i
    inverter(texto, i - 1);// chama a função recursivamente com o índice decrementado
}

int main() {
    char texto[1000];

    // continua lendo enquanto houver linhas e a entrada não for "FIM"
    while (fgets(texto, sizeof(texto), stdin) && strcmp(texto, "FIM\n") != 0) {
        texto[strcspn(texto, "\n")] = '\0'; // remover quebra de linha
        inverter(texto, strlen(texto) - 1); // inverter a string
        printf("\n");
    }

    return 0;
}
