#include <stdio.h>
#include <string.h>
#include <ctype.h>

int confereMaiuscula(const char *texto);

int main() {
    char texto[100];

    while (fgets(texto, sizeof(texto), stdin)) {
        texto[strcspn(texto, "\n")] = '\0';

        if (strcmp(texto, "FIM") != 0 && strlen(texto) > 0) {
            printf("%d\n", confereMaiuscula(texto));
        }
    }

    return 0;
}

int confereMaiuscula(const char *texto) {
    int count = 0;
    for (int i = 0; i < strlen(texto); i++) {
        if (isupper(texto[i])) {
            count++;
        }
    }
    return count;
}