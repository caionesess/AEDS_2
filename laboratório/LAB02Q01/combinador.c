#include <stdio.h>
#include <string.h>

void combinar(char *str1, char *str2, char *resultado) {
    int i = 0, j = 0, k = 0;
    while (str1[i] != '\0' && str2[j] != '\0') {
        resultado[k++] = str1[i++];
        resultado[k++] = str2[j++];
    }
    while (str1[i] != '\0') {
        resultado[k++] = str1[i++];
    }
    while (str2[j] != '\0') {
        resultado[k++] = str2[j++];
    }
    resultado[k] = '\0';
}

int main() {
    char str1[50], str2[50], resultado[100];
    
    while (scanf("%s %s", str1, str2) == 2) {
        combinar(str1, str2, resultado);
        printf("%s\n", resultado);
    }

    return 0;
}
