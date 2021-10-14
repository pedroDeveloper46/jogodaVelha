package teste.Tabuleiro;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pedro.jogoDavelha.Mock.MockJogador;
import pedro.jogoDavelha.centro.Game;
import pedro.jogoDavelha.centro.Jogador;
import pedro.jogoDavelha.centro.Tabuleiro;

public class JogadorTeste {
	
	
	@Test
	public void deveriaCriarUmJogador() throws Exception{
		
		Tabuleiro t = new Tabuleiro();
		
		MockJogador mock = new MockJogador();
		
		Game game = new Game(mock);
		
		Jogador j = game.criaJogador("Pedro", t, 'X');
		
		assertEquals(mock.getNome(), j.getNome());
		
		
		
	}
	
	@Test
	public void deveriaRetornarOProximoJogador() throws Exception{
		
		MockJogador mock = new MockJogador();
		
		Game game = new Game(mock);
		
		assertEquals(mock.getIndex(), game.getCurrentPlayer());
		
	}

}
