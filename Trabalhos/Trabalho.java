package Trabalhos;

import java.util.Scanner;

public class Trabalho {

	static boolean fim = false;
	static String [][] resumoChamada = {
  									   {"Ligou devido a um assunto não relacionado ao Covid-19.","?"},{"Ligou devido ao vírus Covid-19.","?"},
    								   {"Não apresenta sintomas.","?"},{"Foi informado dos cuidados a ter com o vírus.","?"},
  									   {"Apresenta sintomas do vírus ou, conhece alguém que apresenta os sintomas.","?"},{"Foi informado dos cuidados a ter com o vírus.","?"},
  									   {"Declarou febre como sintoma apresentado.","?"},{"Foi informado dos cuidados a ter com o vírus.","?"},
    								   {"Declarou tosse regular como sintoma apresentado. Chamada reencaminhada para um operador.","?"}
  									   };
									   //ordem -> 0,4,3,2,6,5,8,7,9
	
	public static void main(String[] args) {

		
		Scanner ler = new Scanner(System.in);

		BinSearchTree atendedor = new BinSearchTree();
		BinSearchTree navegador = atendedor;
		
		int resposta = 0;
		
		atendedor.inserir(1);
		atendedor.inserir(0);
		atendedor.inserir(4);
		atendedor.inserir(3);
		atendedor.inserir(2);
		atendedor.inserir(6);
		atendedor.inserir(5);
		atendedor.inserir(8);
		atendedor.inserir(7);
		atendedor.inserir(9);
		
		
		do {
		
		System.out.println(navegador.mensagemAuto(resumoChamada,fim));
		if(fim == false)
			resposta = ler.nextInt();
		
		if(fim == false) {
			if(navegador.atendedorHandler(resposta))
				navegador.mudarRaiz(resposta);
			else { 
				System.out.println("*Chamada desligada*");
				fim = true;
			}
		}
		
		}while (fim == false);
		
		navegador.imprimirResumo(resumoChamada);
		
		
		ler.close();
	}
	
	
	
	

}
