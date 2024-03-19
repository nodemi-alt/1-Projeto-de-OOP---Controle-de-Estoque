# 1-Projeto-de-OOP---Controle-de-Estoque
### Matheus Veríssimo 
RA - 00000850062  

Versão JVM usada : 21.0.2

## Observações
Em algumas partes mudei o locale para ingles, porque eu estou acostumado a " . " como separador decimal ao inves de " , "
Para tirar, e so remover todos os `scan.useLocale(Locale.ENGLISH); `
`System.out.println(Locale.getDefault());` para ver a definição padrão da região.


     
  
## Requisitos minimos :
- Um arquivo main sendo um switchcase simples e um array para armazenar as informações dos produtos, um menuzinho decente
- Um arquivo para a classe dos produtos, contendo as suas informações (quantidade, valor, tamanho ocupado), e todas as funções necessárias para as operações com os produtos
- Funções : Construtora, para criar novo objeto (produto), buscar posição do objeto no array, remover objeto do array, consultar objeto especifico, alterar dados do objeto, e algumas coisas auxiliares
  ![image](https://github.com/nodemi-alt/1-Projeto-de-OOP---Controle-de-Estoque/assets/163960947/c1b1b793-3085-406c-934b-6d0c17bc7cb8)

Ambos arquivos na pasta `src`.

## Requisitos adicionais :
- Função para visualizar todos os produtos registrados

  Muito conveniente, e ajuda a testar/identificar problemas
  
- Função para ver os dados totais do estoque
  
  Permite ver a quantidade total de produtos, o valor coletivo de todos os produtos, etc
  
  ![image](https://github.com/nodemi-alt/1-Projeto-de-OOP---Controle-de-Estoque/assets/163960947/fa33e408-01d9-486a-a791-c509a20bfb79)
  
  ![image](https://github.com/nodemi-alt/1-Projeto-de-OOP---Controle-de-Estoque/assets/163960947/820cdd9f-b32a-4851-905f-2f0cd24995ff)



## Qualidades agradaveis :
- Array aumenta de tamanho automaticamente para acomodar os objetos sendo salvos
- Try-catch em todos os scans, eliminando a maioria dos casos em que o programa explode por receber um input diferente do esperado <sub> talvez a significante custa de legibilidade e organização </sub>

  ![image](https://github.com/nodemi-alt/1-Projeto-de-OOP---Controle-de-Estoque/assets/163960947/5cd96e2c-3d60-4959-839e-1a5292d91a98)

## Requisitos que não implementei, mas queria ter implementado :
- Salvar os dados do array de produtos em um arquivo persistente
- Expandir a parte de tamanho ocupado pelos produtos : simulação do armazem em si, alterar o tamanho, estantes, etc 
