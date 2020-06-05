package Trabalhos;

public class BinSearchTree implements BinTree {

	private NoBinTree raiz;

	// Métodos da Interface BinTree
	@Override
	public void inserir(int num) {

		raiz = inserir(raiz, num);

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
