public class App {
    public static void main(String[] args) throws Exception {
        int dados[] = {4,3,8,2,4,1,5,9,1,7,5,9,6,7,6,2,1};   //Dados que vão ser utilizados
        //int dados[] = {1,3,4,7,6,4,3,6,8,3,4,1,8,3,4,9,8}; //Dados como da aula para testes
        int cont[] = new int[4];                             //Onde fica armazenado os 4 contadores que contam as vezes que foram acessados os dados
        int contCache[] = new int [4];                       //Contador que realiza o registro do que menos foi acessado 
        int cache[] = new int[4];                            //Lista do cache
        int lista[][] = new int[4][dados.length];            //lista do quantas vezes foram acessados os valores

        for (int x = 0; x < dados.length; x++){              //For para pecorrer todos os dados
            if (cont[0] == 0){                               //Verifica se tem algum dado na posição 0 do cache
                cache[0]=dados[x];                           //Se estiver fazio, adiona o dado na cache
                cont[0]++;                                   //incrementa o contador de acessos a posição 0 da cache
                contCache[0] = x;                            //Adiona o valor da posição do dado para fins de comparação de menos acessado
            } else if (cont[1] == 0){                        //Verifica se tem algum dado na posição 1 do cache
                cache[1]=dados[x];
                cont[1]++;
                contCache[1] = x;
            } else if (cont[2] == 0){                        //Verifica se tem algum dado na posição 2 do cache
                cache[2]=dados[x];
                cont[2]++;
                contCache[2] = x;
            } else if (cont[3] == 0){                        //Verifica se tem algum dado na posição 3 do cache
                cache[3]=dados[x];
                cont[3]++;
                contCache[3] = x;
            }else if (cache[0] == dados[x]){                 //Verifica se o dado que está na posição 0 da cache é igual o dado na posição x
                cont[0]++;                                   //Se for igual, incrementa o valor para mostrar multipls acessos
                contCache[0] = x;                            //Adiona o valor da posição do dado para fins de comparação de menos acessado
            }else if (cache[1] == dados[x]){                 //Verifica se o dado que está na posição 1 da cache é igual o dado na posição x 
                cont[1]++;
                contCache[1] = x;
            }else if (cache[2] == dados[x]){                 //Verifica se o dado que está na posição 2 da cache é igual o dado na posição x 
                cont[2]++;
                contCache[2] = x;
            }else if (cache[3] == dados[x]){                 //Verifica se o dado que está na posição 3 da cache é igual o dado na posição x 
                cont[3]++;
                contCache[3] = x;
            }else if (cont[0] == cont[1] && cont[1] == cont[2] && cont[2] == cont[3]){  //Verifica se o númeor de acessos ao dados são iguais em todas posições
                int indiceMenor = 0, contUltimo = Integer.MAX_VALUE;                    //Variáveis auxiliares
                for (int y = 0; y < contCache.length; y++){                             //For percorrer a var contCache que tem as posição x de alteração
                    if (contCache[y] < contUltimo){                                     //If para comparação de qual foi a mais tempo sem acesso (x menor)
                        contUltimo = contCache[y];                                      //Se for menor, contUltimo recebe o menor valor
                        indiceMenor = y;                                                //Registra o indice do menor valor
                    }
                }
                cache[indiceMenor]=dados[x];                                            //Coloca o valor do dado x onde tem mais tempo sem alterção
                contCache[indiceMenor] = x;                                             //Adiona o valor da posição do dado para fins de comparação de mais tempo sem alterção
                cont[indiceMenor] = 1;                                                  //Volta o contador para 1
            } else {
                int indiceMenor = 0, contUltimo = Integer.MAX_VALUE;                    //Variáveis auxiliares
                for (int y = 0; y < cont.length; y++){                                  //For percorrer a var cont que tem o número de acessos
                    if (cont[y] < contUltimo){                                          //If para comparação dos números de acessos
                        contUltimo = cont[y];                                           //Se for menor, contUltimo recebe o menor valor
                        indiceMenor = y;                                                //Registra o indice do menor valor
                    }
                }
                for (int i = 0; i < cont.length; i++){                                  //For que percorre a var cont tem o número de acessos
                    if (cont[i] == cont[indiceMenor]){                                  //If que compara se tem contadores de acesso iguais
                        if (contCache[i] < contCache[indiceMenor]){                     //If que compara entre os contadores iguais qual é a lteração mais antiga
                            indiceMenor = i;                                            //Se for mais antiga, registra essa 
                        }
                    }
                }
                cache[indiceMenor]=dados[x];                                            //Coloca o valor do dado x onde tem mais tempo sem alterção
                contCache[indiceMenor] = x;                                             //Adiona o valor da posição do dado para fins de comparação de mais tempo sem alterção
                cont[indiceMenor] = 1;                                                  //Volta o contador para 1

            }
        
            lista[0][x] = cont[0];                                                      //Armazena os passos na lista
            lista[1][x] = cont[1];
            lista[2][x] = cont[2];
            lista[3][x] = cont[3];

        }


        for (int l = 0; l < lista.length; l++){ 
            System.out.print("["); 
            for (int c = 0; c < lista[0].length; c++){ 
                System.out.print(lista[l][c] + ", "); //imprime caracter a caracter
            }  
            System.out.println("]"); //muda de linha
        }

        for (int l = 0; l < cache.length; l++){ 
            System.out.println("[" + cache[l] + "]"); 
        }
    }
}
