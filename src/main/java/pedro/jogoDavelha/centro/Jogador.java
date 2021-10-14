package pedro.jogoDavelha.centro;

import br.com.softblue.commons.io.Console;
import pedro.jogoDavelha.Mock.MockMovimento;

public class Jogador {
	private String nome;

	private Tabuleiro tabuleiro;
	private char simbolo;

	private MockMovimento mock;

	public Movimento InputMove(MockMovimento mock) throws InvalidMoveException {

		System.out.println(getNome() + " DIGITE A SUA JOGADA");
		
		String move = Console.readString();
		
		mock.setMov(move);
		
		Movimento m = new Movimento(move, mock);
		
		return m;
		// ou poderia ser tbm => return new Movimento(move);

	}

	public boolean play(MockMovimento mock) throws InvalidMoveException {
		Movimento m = InputMove(mock);
		return tabuleiro.jogar(this, m);
	}

	public Jogador(String nome, Tabuleiro tabuleiro, char simbolo) {

		this.nome = nome;
		this.tabuleiro = tabuleiro;
		this.simbolo = simbolo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public char getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}
}
