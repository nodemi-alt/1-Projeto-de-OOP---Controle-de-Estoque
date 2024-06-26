import java.util.Scanner;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.InputMismatchException;
 



@SuppressWarnings({"unused"}) 
public class Main
{
	
static void opcoes()
{
	System.out.println("\n\nBem vindo ao sistema de controle de estoque.\n\n>>> O que você quer fazer agora?\n 1 - Adicionar novo tipo de produto \n 2 - Consultar/alterar dados de um produto \n 3 - Ver todos os produtos \n 4 - Remover um produto \n 5 - Ver dados do estoque \n 0 - Sair do programa\n");
}

static void EnterPraContinuar(Scanner scan)
{
	String superfluo;
	System.out.println("\n   Aperte Enter para continuar.");
	superfluo = scan.nextLine();
}

public static void main(String[] args) 
{
	Scanner scan = new Scanner(System.in);
	int menu = 10;
	int limiteatual = 5; //
	int qtdDeProdutos = 0;
	Produto[] array;
	Produto[] arraycopia;
	array = new Produto[5];
	int retorno;
do 
{
	if (qtdDeProdutos > limiteatual-1) // se deus quiser, isso aumenta o tamanho do array o quanto for necessario. se deus quiser, isso nao destroi o conteudo do array. Nao sei. Faz 30 minutos que eu comecei a aprender java pela primeira vez 
	{
	 	arraycopia = Arrays.copyOf(array, qtdDeProdutos + limiteatual);
	 	array = Arrays.copyOf(arraycopia, qtdDeProdutos + limiteatual);	
	 	limiteatual = limiteatual*2;
		
	}
	opcoes();

		try {menu = scan.nextInt(); } 
			catch (InputMismatchException e)
			{ scan.next();
		  	menu = 10; }
		scan.nextLine();

	    switch (menu)
		{
			case 1 :
			retorno = Produto.novoproduto(qtdDeProdutos, array, scan);
			if (retorno == 1) { qtdDeProdutos++; }
			EnterPraContinuar(scan);
			break;

			case 2 :
			Produto.Consultar(qtdDeProdutos, array, scan);
			break;

			case 3 :
			Produto.MostrarTodos(qtdDeProdutos, array);
			EnterPraContinuar(scan);
			break;
			
			case 4 :
			retorno = Produto.remover(qtdDeProdutos, array, scan);
			if (retorno == 1) { qtdDeProdutos--; }
			EnterPraContinuar(scan);
			break;

			case 5 :
			Produto.Armazem(qtdDeProdutos, array);
			EnterPraContinuar(scan);
			break;

			case 0 :
			System.out.println(":(");
			break;

			default :
			System.out.print(">>> opçao invalida!");
		}


} while (menu != 0);

scan.close();
}
}
