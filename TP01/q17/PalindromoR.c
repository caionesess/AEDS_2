#include <stdio.h>
#include <string.h>

// função recursiva para verificar se uma string é um palíndromo
int verificarPalindromoRecursivo(char texto[], int inicio, int fim) {
    //ignora caracteres esopeciais 
    while (texto[inicio] > '~') 
        inicio++;
    while (texto[fim] > '~') 
        fim--;

    if (inicio >= fim) {
        return 1; //caso base: se os índices se cruzarem ou forem iguais, é um palíndromo
    }

    if (texto[inicio] != texto[fim]) {
        return 0; //se forem diferentes retorna falso
    }

    return verificarPalindromoRecursivo(texto, inicio + 1, fim - 1); //chamada recursiva com índices ajustados
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
            int ehPalindromo = verificarPalindromoRecursivo(texto, 0, strlen(texto) - 1);
            if (ehPalindromo) {
                printf("SIM\n");
            } else {
                printf("NAO\n");
            }
        }
    }

    return 0;
}
