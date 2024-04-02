import java.util.InputMismatchException;
import java.util.Locale; 
import java.util.Scanner;
@SuppressWarnings({"unused"}) 
public class Produto 
{
    String nome;
    int qtd;
    double valor;
    int espaco_ocupado;

public Produto(String nome, double valor, int espaco_ocupado)
    {   
        this.nome = nome;
        this.qtd = 0;
        this.valor = valor;
        this.espaco_ocupado = espaco_ocupado;
    }
static void EnterPraContinuar(Scanner scan)
    {
        String superfluo;
        System.out.println("\n>>> Aperte Enter para continuar.");
        superfluo = scan.nextLine();
    }

static int novoproduto(int qtdDeProdutos, Produto[] array, Scanner scan)
    {
        scan.useLocale(Locale.ENGLISH); 
	    String nome; double valor = 1; int espaco_ocupado = 1; int tentativa = 0;
	    System.out.println("\n>>> Insira o nome do produto que você quer adicionar :");
	        nome = scan.nextLine();
        if ((busca(nome, qtdDeProdutos, array) == -1))
            {
	        System.out.println(">>> Insira o valor do produto (use ponto como separador decimal):");
                    while (tentativa != 1){
	                try { valor = scan.nextDouble(); tentativa = 1; }
                    catch (InputMismatchException e) 
                    { scan.next(); valor = 1; System.out.println(">>> Erro : Entrava invalida, por favor insira um numero. Use ponto ao inves de virgula para decimal.");}
                    if (valor <= 0 ) 
                    { tentativa = 0 ; System.out.println(">>> Dar ao produto o valor de R$" + valor + " seria financialmente inviavel. Por favor insira outro valor."); }
                    }
            tentativa = 0;
	        System.out.println(">>> Insira o espaço necessário para armazenar cada unidade do produto :");	
                    while (tentativa != 1){
                    try  {espaco_ocupado = scan.nextInt(); tentativa = 1;}
                    catch (InputMismatchException e) 
                    { scan.next(); System.out.println(">>> Erro : Entrava invalida, por favor insira um numero."); } 
                    if (espaco_ocupado <= 0 ) 
                    { tentativa = 0 ; System.out.println(">>> O valor do espaço tem que ser positivo! "); }}
	        Produto produto = new Produto(nome, valor, espaco_ocupado);
	        array[qtdDeProdutos] = produto;
            System.out.println("\n>>> Produto '" + nome + "' adicionado com sucesso.");
            scan.nextLine();
            return 1;
            }
        else
        System.out.println("\n>>> Erro : O produto que você quer adicionar já existe.");	
        return 0;
    }

    
static int busca(String nomeprocurado, int qtdDeProdutos, Produto[] array)
    {   
        int i;
        for (i = 0; i<qtdDeProdutos; i++)
            {
            if (array[i].nome.equals(nomeprocurado)) 
            { return i;}
            }

    return -1;
    }

static int remover(int qtdDeProdutos, Produto[] array, Scanner scan)
{
    int retorno;
    String nomeprocurado;
    
    System.out.println("\n>>> Insira o nome do produto que você quer remover :");
    nomeprocurado = scan.nextLine();
    retorno = busca(nomeprocurado, qtdDeProdutos, array);
    if (retorno != -1)
    {
        if (array[retorno].qtd == 0)
        {
            for (int i = retorno; i < qtdDeProdutos; i++)
            {
                array[i] = array [i+1];
            }
            System.out.println("\n>>> Produto '" + nomeprocurado + "' removido com sucesso.");
            return 1;
        }
        else { System.out.println(">>> Voce so pode deletar um produto caso ele nao tenha nenhuma unidade em armazenamento."); 
               return 0; }

    }   
    else { System.out.println(">>> O produto procurado nao existe."); 
           return 0;  }

}


static void MostrarTodos(int qtdDeProdutos, Produto[] array)
    {
        if (qtdDeProdutos == 0)
        { System.out.println("\n>>>Não há nenhum produto para mostrar."); }
        else
        {
            System.out.print("\nNumero de cadastros : " + qtdDeProdutos);
            System.out.println("\n------------------------");
            for (int i = 0; i<qtdDeProdutos; i++)
            {  
                System.out.println(" Produto " + (i+1) + " - " + array[i].nome + "\n");
                System.out.println(" >> Quantia atual : " + array[i].qtd + " unidades");
                System.out.println(" >> Valor por unidade : R$" + array[i].valor);
                System.out.println(" >> Espaço ocupado/unidade : " + array[i].espaco_ocupado +"\n");
                System.out.println(" >> Valor total : R$" + (array[i].qtd*(array[i].valor)));
                System.out.println(" >> Espaço total ocupado : " + (array[i].qtd*(array[i].espaco_ocupado)));
                System.out.println("-------------------------");
            }
        }
    }
    
static void Consultar(int qtdDeProdutos, Produto[] array, Scanner scan)
    { 
    scan.useLocale(Locale.ENGLISH);
    int retorno;
    String nomeprocurado;
    int menu = 10;
    
    System.out.println("\n>>> Insira o nome do produto que você quer consultar :");
    nomeprocurado = scan.nextLine();
    retorno = busca(nomeprocurado, qtdDeProdutos, array);
    if (retorno != -1)

        { 
           
            do {
            System.out.println("\n-------------------------");
            System.out.println("Produto - " + array[retorno].nome + "\n");
            System.out.println(" >> Quantia atual : " + array[retorno].qtd + " unidades");
            System.out.println(" >> Valor por unidade : R$" + array[retorno].valor);
            System.out.println(" >> Espaço ocupado/unidade : " + array[retorno].espaco_ocupado +"\n");
            System.out.println(" >> Valor total : R$" + (array[retorno].qtd*(array[retorno].valor)));
            System.out.println(" >> Espaço total ocupado : " + (array[retorno].qtd*(array[retorno].espaco_ocupado)));
            System.out.println("---------------------------");
            System.out.println("\n>>> O que você quer fazer com o produto? \n 1 - Atualizar quantidade \n 2 - Atualizar valor \n 3 - Atualizar espaço ocupado \n 0 - voltar \n");

                try {menu = scan.nextInt(); } 
			    catch (InputMismatchException e)
			    { scan.next();
		  	    menu = 10; }
		  	    scan.nextLine();
            switch (menu)
		{
			case 1 :
			AlterarQTD(retorno, array, scan);
			scan.nextLine();
            break;

            case 2 :
			AlterarValor(retorno, array, scan);
			scan.nextLine();
            break;

            case 3 :
			AlterarEspaco(retorno, array, scan);
			scan.nextLine();
            break;

            case 0 : 
            break;

			default :
			System.out.println(">>> opçao invalida!");
		}

            } while (menu != 0);

    }   
    else
    System.out.println(">>> conta nao encontrada!");
    EnterPraContinuar(scan);
}

static void AlterarQTD(int n, Produto[] array, Scanner scan)
    {
        scan.useLocale(Locale.ENGLISH);
        int num = 1;
        int tentativa = 0;
        int tentativa2 = 0;
        System.out.println(">>> Insira a nova quantidade do produto, ou digite -1 para voltar.");
        do  {   
            tentativa2 = 0;
            tentativa = 0;
                while (tentativa != 1){
                try  {num = scan.nextInt(); tentativa = 1;}
                catch (InputMismatchException e) 
                { scan.next(); System.out.println(">>> Erro : Entrada invalida, por favor insira um numero.");} }
            if (num >= 0)
            { array[n].qtd = num;
              tentativa2 = -1; }
            else if (num == -1)
            { tentativa2 = -1; 
                System.out.println(">>> Alteraçao cancelada.\n"); }
            else 
            System.out.println(">>> Quantia invalida, a quantidade não pode ser negativa, tente novamente :\n");
            } while (tentativa2 != -1);

    }

static void AlterarValor(int n, Produto[] array, Scanner scan)
{
    scan.useLocale(Locale.ENGLISH);
    Double num = 1.0;
    int tentativa = 0;
    int tentativa2 = 0;
    System.out.println(">>> Insira o novo valor do produto, ou digite -1 para voltar.");
    do  {   
        tentativa2 = 0;
        tentativa = 0;
            while (tentativa != 1){
            try  {num = scan.nextDouble(); tentativa = 1;}
            catch (InputMismatchException e) 
            { scan.next(); System.out.println(">>> Erro : Entrada invalida, por favor insira um numero. use o ponto e nao virgula como separador decimal. ");} }
        if (num > 0)
        { array[n].valor = num;
          tentativa2 = -1; }
        else if (num == -1)
        { tentativa2 = -1; 
            System.out.println(">>> Alteraçao cancelada.\n"); }
        else 
        System.out.println(">>> Dar ao produto o valor de R$" + num + " seria financialmente inviavel. Por favor insira outro valor.");
        } while (tentativa2 != -1);

}

static void AlterarEspaco(int n, Produto[] array, Scanner scan)
{
    scan.useLocale(Locale.ENGLISH);
    int num = 1;
    int tentativa = 0;
    int tentativa2 = 0;
    System.out.println(">>> Insira o novo tamanho do produto, ou digite -1 para voltar.");
    do  {   
        tentativa2 = 0;
        tentativa = 0;
            while (tentativa != 1){
            try  {num = scan.nextInt(); tentativa = 1;}
            catch (InputMismatchException e) 
            { scan.next(); System.out.println(">>> Erro : Entrada invalida, por favor insira um numero.");} }
        if (num >= 0)
        { array[n].espaco_ocupado = num;
          tentativa2 = -1; }
        else if (num == -1)
        { tentativa2 = -1; 
            System.out.println(">>> Alteraçao cancelada.\n"); }
        else 
        System.out.println(">>> Quantia invalida, produtos infelizmente nao podem ocupar espaço negativo. Tente novamente :\n");
        } while (tentativa2 != -1);

}

static void Armazem(int qtdDeProdutos, Produto[] array)
    {
        int i;
        int contadorqtd = 0;
        double contadorvalor = 0;
        int contadorespaco = 0;
        for (i = 0; i < qtdDeProdutos; i++)
            {
                contadorqtd = contadorqtd + array[i].qtd;
                contadorvalor = contadorvalor + array[i].valor*array[i].qtd;
                contadorespaco = contadorespaco + array[i].espaco_ocupado*array[i].qtd;
            }
            System.out.println("\n\n Informaçoes do estoque : ");
            System.out.println("----------------------------------------- ");
            System.out.println(">>> Tipos produtos registrados : " + qtdDeProdutos);
            System.out.println(">>> Quantidade total de produtos em estoque : " + contadorqtd);
            System.out.println(">>> Valor coletivo dos produtos em estoque : " + contadorvalor);
            System.out.println(">>> Unidades de espaço ocupadas por todos os produtos em estoque : " + contadorespaco);
            System.out.println("----------------------------------------- ");

    }
}
