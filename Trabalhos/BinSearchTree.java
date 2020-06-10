package Trabalhos;

public class BinSearchTree implements BinTree {

	private NoBinTree raiz;

	// Métodos da Interface BinTree
	@Override
	public void inserir(int num) {

		raiz = inserir(raiz, num);

	}	
	
	public boolean atendedorHandler(int valor) {
		
		return atendedorHandler(raiz, valor);
	}
	
	private  boolean atendedorHandler(NoBinTree no, int valor) {
		
		if(no.getFilhoEsquerda() != null && no.getFilhoDireita() != null)
			if(no.getFilhoEsquerda().getValor() == valor || no.getFilhoDireita().getValor() == valor)
				return true;
		
		
		return false;
	}
	
	public String mensagemAuto(String [][] resumoChamada, boolean fim) {
		int valor=raiz.getValor();
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
	
	
	public void imprimirResumo(String [][] resumoChamada) {
		
		System.out.println("");
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		System.out.println("Resumo da Chamada:");
		
		for(int i = 0; i < resumoChamada.length; i++) {
		
			if(resumoChamada[i][1] == "sim")
				System.out.println(resumoChamada[i][0]);
		};	
		System.out.println("Chamada terminada.");
		System.out.println("------------------------------------------------------------------------------------------------------------------");
	
	}

	@Override
	public NoBinTree procurar(int num) {
		
		return procurar(raiz, num);
	}
	
	private NoBinTree inserir(NoBinTree no, int num) {
		if (no == null) {
			return new NoBinTree(num);
		}

		if (num < no.getValor()) {
			no.setFilhoEsquerda(inserir(no.getFilhoEsquerda(), num));
		} else if (num > no.getValor()) {
			no.setFilhoDireita(inserir(no.getFilhoDireita(), num));
		}

		return no;
	}
	
	private NoBinTree procurar(NoBinTree no, int num)
	{
		if(no == null) {
			return null;
		}
		
		if(num < no.getValor()) {
			
			return procurar(no.getFilhoEsquerda(), num);
			
		}else if(num > no.getValor()) {
			
			return procurar(no.getFilhoDireita(), num);
			
		} else {
			
			return no;
		}
	}

	public String preOrdem() {
		if (raiz == null) {
			return "arvore vazia";
		}

		return preOrdem(raiz);
	}

	public String preOrdem(NoBinTree no) {
		String retorno = "";

		if(no != null) {
			
			retorno += no.getValor() + " ";	
		}
		
		if(no.getFilhoEsquerda() != null) {
			retorno += preOrdem(no.getFilhoEsquerda());
		}
		
		if(no.getFilhoDireita() != null) {
			retorno += preOrdem(no.getFilhoDireita());
		}
		
		return retorno;

	}
	
	public NoBinTree getRaiz() {	
		return raiz;
	}
	
	public void mudarRaiz(int valor) {
		
		if(this.raiz.getFilhoEsquerda().getValor() == valor)
			this.raiz = this.raiz.getFilhoEsquerda();
		else
			this.raiz = this.raiz.getFilhoDireita();
	}
	

}
