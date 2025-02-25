#include <stdio.h>
/*Faça um método que receba um número inteiro n e efetue o número de
subtrações pedido em:
a) 3n + 2n^2
*/
void funcaoA(int n, int a, int b, int c, int d){
    for(int i = 0; i < n; i++){
        a--, b--, c--;
    }
                                                //O(n) + O(n²)
    for(int i = 0; i < n; i++){                 //O(n²)
        for(int j = 0; j < n; j++){
            c--;
            d--;
        }
    }
    printf("ok");
}
// b) 5n + 4n^3
void funcaoB(int n, int a, int b, int c, int d, int e){
    for(int i = 0; i < n; i++){
        a--, b--, c--, d--, e--;
    }
                                                //O(n) + O(n³)
    for(int i = 0; i < n; i++){                 //O(n³)
        for(int j = 0; j < n; j++){
            for(int k = 0; k < n; k++){
                a--, b--, c--, d--;
            }
        }
    }
    printf("ok");
}
// c) lg(n) + n
void funcaoC(int n, int a, int b){
    for(int i = n; i > 0; i/=2){
        a--;
    }                                           //O(lg n) + O(1)
    for(int i = 0; i < n; i++){                 //O(lg n)
       b--; 
    }
    printf("ok");
}
// d) 2n^3 + 5
void funcaoD(int n, int a, int b, int c, int d, int e){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            for(int k = 0; k < n; k++){         //O(n³) + O(1)
                a--, b--;                       //O(n³)
            }
        }
    }
    a--, b--, c--, d--, e--;
    printf("ok");
}
//e) 2n^4 + 2n^2 + n/2
void funcaoE(int n, int a, int b, int c, int d, int e){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            for(int k = 0; k < n; k++){
                for(int l = 0; l < n; l++){     //O(n⁴) + O(n²) + O(n)
                    a--, b--;                   //O(n⁴)
                }
            }
        }
    }
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            c--, d--;
        }
    }
    for(int i = 0; i < n/2; i++){
        e--;
    }
    printf("ok");
}
//f) lg(n) + 5 lg(n)
void funcaoF(int n, int a, int b, int c, int d, int e){
    for(int i = n; i > 0; i/=2){
        a--;
    }                                           //O(log n) + O(log n) = O(2 x log n)
    for(int j = n; j > 0; j/=2){                //O(log n)
        a--, b--, c--, d--, e--;
    }
    printf("ok");
}
int main(){
    int n = 10;
    int a = 500;
    int b = 500;
    int c = 550;
    int d = 500;
    int e = 500;

    funcaoA(n,a,b,c,d);
    //funcaoB(n,a,b,c,d,e);
    //funcaoC(n,a,b);
    //funcaoD(n,a,b,c,d,e);
    //funcaoE(n,a,b,c,d,e);
}
