#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>
#include <conio.h>
#include <ctype.h>
#include<locale.h>
#define MAX_LENGHT 100
#define MAX_STRING 3*MAX_LENGHT
#define MAX_LINE 100

// Tipo correspondente ao CSV
typedef struct fileCSV{
      char fNome[MAX_LENGHT];
      char mNome[MAX_LENGHT];
      char lNome[MAX_LENGHT];
}fileCSV;

    //Pegando os dados


// Read no Arquivo
int readFile(FILE **pArquivo, char stringOutput[MAX_LINE][MAX_STRING]){
   int contador = 0;
   while (!feof(*pArquivo))
    {
      fscanf(*pArquivo,"%s", stringOutput[contador]);
      contador++;
    }
    return contador;
}


int main()
{
    setlocale(LC_ALL, "Portuguese");//habilita a acentuação para o português

    FILE *arq;
    int aux,i,j=0;
    float *valores = malloc(sizeof(float)*5000);
    char stringOutput[MAX_LINE][MAX_STRING];
    arq = fopen("distribuicaoEstado.csv","r");
    aux=readFile(&arq,stringOutput);
    for(i=3;i <= aux;i++)
        {
                printf("Registros : %s\n", stringOutput[i],valores);
                valores[j]= (float)stringOutput[i][0];
                printf("TESTANDO VALOR:%f \n",valores[j]);
                j++;
                i=i+1;
        }

    //printf("TESTANDO VALORES: %s ",stringOutput[5]);
    fclose(arq);


return 0;
}
