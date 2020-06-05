package Trabalhos;
/**
 * Interface BinTree
 * Representacao em Java do Tipo de Dados Abstracto Arvore Binaria
 * 
 * 
 */
public interface BinTree {
	
	/**
	 * Insere um numero na arvore
	 * 
	 * @param num  número a inserir
	 * @throws IllegalArgumentException  se já existir o 'num' na árvore
	 */
	public void inserir( int num );
	
	
	/**
	 * Procura um determinado numero na arvore
	 * 
	 * @param num
	 * @return retorna uma referência para o nó que armazena o valor 'num' se existir
	 *                 ou null se o 'num' não existir na árvore
	 */
	public NoBinTree procurar( int num );
	
	
	

}
