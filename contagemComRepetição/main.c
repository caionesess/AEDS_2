#include <stdio.h>
void rt (int *, int *, int *);
void print (int, int, int);

int main (){

    int n = 5;
    int a = 10;
    int b = 20;

/* Temos n iterações quando o contador da estrutura de repetição começa com
zero, repete enquanto menor que n e é incrementado em uma unidade */
    for(int i = 0; i < n; i++){
        a--; b--;
    }
        // n° de subtrações = 2n

    print(n,a,b);
    rt(&n,&a,&b);

    for (int i = 3; i < n; i++){
        a--;
    }
        // n° de subtrações = (n - 3)

    print(n,a,b);
    rt(&n,&a,&b);

/*Temos (n-a) iterações quando o contador da estrutura de repetição começa
com a, repete enquanto menor que n e é incrementado em uma unidade*/
    
    int i = 0;
    while (i < 3){
        i++;
        b--;
    }
        // n° de subtrações = 3

    print(n,a,b);
    rt(&n,&a,&b);


    i = 0;
    do {
        i++;
        b--;
    } while (i < 3);
        // n° de subtrações = 3

    print(n,a,b);
    rt(&n,&a,&b);
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