#include <stdio.h>
#include <string.h>
#include <ctype.h>

int confereMaiuscula(const char *texto, int index);

int main() {
    char texto[100];

    while (fgets(texto, sizeof(texto), stdin)) {
        texto[strcspn(texto, "\n")] = '\0';

        if (strcmp(texto, "FIM") != 0 && strlen(texto) > 0) {
            printf("%d\n", confereMaiuscula(texto, 0));
        }
    }

    return 0;
}

int confereMaiuscula(const char *texto, int index) {
    if (index >= strlen(texto)) {
        return 0; // Caso base: fim da string
    }
    int count = isupper(texto[index]) ? 1 : 0;
    return count + confereMaiuscula(texto, index + 1);
}