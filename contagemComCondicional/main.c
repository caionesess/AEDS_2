#include <stdio.h>
void rt (int *, int *, int *);
void print (int, int, int);

int main (){

    int n = 5, a = 10, b = 15, c = 20, d = 25;
    int i = 30, j = 35;

        // [melhor caso - 3] ~ (pior caso - 5)
    if (a - 5 < b - 3){ // [2] ~ (2)
        i--;
        --b;
        a -= 3; // (3)
    } else {
        j--;    // [1]
    }

        // [melhor caso - 5] ~ (pior caso - 7)
    if (a - 5 < b - 3 || c - 1 < d - 3){ // [2] ou [4] ~ (4)
        i--;
        --b;
        a -= 3; // [3] ~ (3)
    } else {
        j--; // [1]
    }

    /*Em operadores OR, se o primeiro for verdadeiro, a segunda comparação não é executada.
    Em operadores AND, se o primeiro for falso, a segunda comparação não é executada.*/
}

/*--------------------------------------------------------------------------------------*/
void rt (int *n, int *a, int *b){
    *n = 5;
    *a = 10;
    *b = 15;
}

void print (int n, int a, int b){
    printf("n = %d, a = %d, b = %d\n", n, a, b);
}