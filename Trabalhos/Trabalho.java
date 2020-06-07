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
		
		imprimirResumo();
		
		
		ler.close();
	}
	
	
	
	private static String mensagemAuto(int valor) {
		
		String mensagem = "";
		
		switch(valor) {
		
			case 0:
				mensagem = "Devido ao elevado número de chamadas não podemos responder ao seu pedido de momento, por favor ligue mais tarde.";
				fim = true;
				resumoChamada[0][1] ="sim";
				break;
				
			case 1:
				mensagem = "Ligou para a linha de saúde 24, devido aos eventos recentes e ao tráfego resultante estamos a dar prioridade a casos de Covid-19.\n"
						 + "Se ligou devido ao Covid-19 prima 4, caso contrário, prima 0. Para cancelar, prima outra tecla.";
				break;
				
			case 2:
				mensagem = "Mensagem definida para como ficar seguro do Covid-19";
				fim = true;
				resumoChamada[3][1] ="sim";
				break;
				
			case 3:
				mensagem = "O virús Covid-19 apresenta como principais sintomas: tosse, febre(temperatura >= 38oC) e dificuldade respiratória (ex. falta de ar).\n"
						+ "Para continuar prima 2. Para cancelar, prima outra tecla.";
				resumoChamada[2][1] ="sim";
				break;
				
			case 4:
				mensagem = "Apresenta sintomas do virus covid-19, ou conhece alguém que apresenta sintomas?\n Se sim, prima 6, se não, prima 3.";
				resumoChamada[1][1] ="sim";
				break;
				
			case 5:
				mensagem = "Mensagem definida para como ficar seguro do Covid-19";
				fim = true;
				resumoChamada[5][1] ="sim";
				break;
				
			case 6:
				mensagem = "A pessoa em causa apresenta sintomas de febre(temperatura >= 38oC)?\n Se sim, prima 8, se não, prima 5.";
				resumoChamada[4][1] ="sim";
				break;
				
			case 7:
				mensagem = "Mensagem definida para como ficar seguro do Covid-19";
				fim = true;
				resumoChamada[7][1] ="sim";
				break;
				
			case 8:
				mensagem = "A pessoa em causa tosse com regularidade?\n Se sim, prima 9, se não, prima 7.";
				resumoChamada[6][1] ="sim";
				break;
				
			case 9:
				mensagem = "A sua chamada vai ser reencaminhada, por favor aguarde.";
				fim = true;
				resumoChamada[8][1] ="sim";
				break;	
		}
		
		
		return mensagem;
	}
	
	
}
