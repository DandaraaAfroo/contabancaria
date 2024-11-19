package conta.repository;

import conta.model.Conta;

public interface ContaRepository {
	
	public void procuraPorNome(int numero);
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int numero);
	
	public void sacar(int nuemro, float valor);
	public void depositar(int nuemro, float valor);
	public void transferir(int numeroOrigem, int numeroDestino, float valor);

}
