package Trabalhos;

import java.util.Scanner;

public class Trabalho {

	static boolean fim = false;
	
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
		
		System.out.println(mensagemAuto(navegador.getRaiz().getValor()));
		if(fim == false)
			resposta = ler.nextInt();
		
		if(fim == false) {
			if(atendedorHandler(navegador.getRaiz(),resposta))
				navegador.mudarRaiz(resposta);
			else { 
				System.out.println("*Chamada desligada*");
				fim = true;
			}
		}
		
		}while (fim == false);
		
		
		
		ler.close();
	}
	
	private static boolean atendedorHandler(NoBinTree no, int valor) {
		
		if(no.getFilhoEsquerda() != null && no.getFilhoDireita() != null)
			if(no.getFilhoEsquerda().getValor() == valor || no.getFilhoDireita().getValor() == valor)
				return true;
		
		
		return false;
	}
	
	private static String mensagemAuto(int valor) {
		
		String mensagem = "";
		
		switch(valor) {
		
			case 0:
				mensagem = "Devido ao elevado número de chamadas não podemos responder ao seu pedido de momento, por favor ligue mais tarde.";
				fim = true;
				break;
				
			case 1:
				mensagem = "Ligou para a linha de saúde 24, devido aos eventos recentes e ao tráfego resultante estamos a dar prioridade a casos de Covid-19."
						+ "Se ligou devido ao Covid-19 prima 4, caso contrário, prima 0. Para cancelar, prima outra tecla.";
				break;
				
			case 2:
				mensagem = "Mensagem definida para como ficar seguro do Covid-19";
				fim = true;
				break;
				
			case 3:
				mensagem = "O virús Covid-19 apresenta como principais sintomas: tosse, febre(temperatura >= 38oC) e dificuldade respiratória (ex. falta de ar)."
						+ "Para continuar prima 2. Para cancelar, prima outra tecla.";
				break;
				
			case 4:
				mensagem = "Apresenta sintomas do virus covid-19, ou conhece alguém que apresenta sintomas? Se sim, prima 6, se não, prima 3.";
				break;
				
			case 5:
				mensagem = "Mensagem definida para como ficar seguro do Covid-19";
				fim = true;
				break;
				
			case 6:
				mensagem = "A pessoa em causa apresenta sintomas de febre(temperatura >= 38oC)? Se sim, prima 8, se não, prima 5.";
				break;
				
			case 7:
				mensagem = "Mensagem definida para como ficar seguro do Covid-19";
				fim = true;
				break;
				
			case 8:
				mensagem = "A pessoa em causa tosse com regularidade? Se sim, prima 9, se não, prima 7.";
				break;
				
			case 9:
				mensagem = "A sua chamada vai ser reencaminhada, por favor aguarde.";
				fim = true;
				break;	
		}
		
		
		return mensagem;
	}

}
