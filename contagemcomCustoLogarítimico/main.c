#include <stdio.h>
void rt (int *, int *, int *);
void print (int, int, int);

int main (){

    int n = 31;
    int a = 1;
    int b = 20;

    /* Temos um custo logarítmico quando a estrutura de repetição reduzir
    sistematicamente o escopo de busca pela metade*/
    for (int i = n; i > 0; i /= 2){
        a *= 2;
    }       // n° de multiplicações = log(n) + 1

    /* Por exemplo: n = 8 ⇒ 4 vezes
    n = 16 ⇒ 5 vezes
    n = 64 ⇒ 7 vezes */
    /* Quando n não é uma potência de 2, o n° de multiplicações será:  piso de [lg(n)] + 1 */
    print(n,a,b);
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