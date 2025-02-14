#include <stdio.h>
void rt (int *, int *, int *);
void print (int, int, int);

int main (){

    int n = 5;
    int a = 10;
    int b = 20;

    for (int i = 0; i < 3; i++){
        for (int j = 0; j < 2; j++){
            a--;
        }
    }           // n° de subtrações = 6 = 3 * 2 * 1 (n° de decrementos no laço interno)

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