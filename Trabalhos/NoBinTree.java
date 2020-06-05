package Trabalhos;


public class NoBinTree {
	
	private int valor;
	private NoBinTree filhoEsquerda;
	private NoBinTree filhoDireita;

	// Acessores 
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public NoBinTree getFilhoEsquerda() {
		return filhoEsquerda;
	}
	public void setFilhoEsquerda(NoBinTree filhoEsquerda) {
		this.filhoEsquerda = filhoEsquerda;
	}
	public NoBinTree getFilhoDireita() {
		return filhoDireita;
	}
	public void setFilhoDireita(NoBinTree filhoDireita) {
		this.filhoDireita = filhoDireita;
	}
	
	
	// Construtores
	public NoBinTree(int valor) {
		this.valor = valor;
		this.filhoEsquerda = null;
		this.filhoDireita = null;
	}
	
	public int altura()
	{
		return altura(this);
	}
	
	public int altura(NoBinTree no)
	{
		if(no == null) {
			return 0;
		}
		
		int eAltura = altura(no.getFilhoEsquerda()); 
		
        int dAltura = altura(no.getFilhoDireita());
        
        return eAltura > dAltura ? eAltura+1 : dAltura+1;
	}
	
	// Override toString
	@Override
	public String toString() {
		return String.format("[%d , %s, %s ]\n",  this.valor, this.filhoEsquerda, this.filhoDireita );
	}
	
	
	
	
}
