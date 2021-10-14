package teste.Tabuleiro;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import pedro.jogoDavelha.Mock.MockTabuleiro;
import pedro.jogoDavelha.centro.Tabuleiro;

public class TabuleiroTeste {
	
	@Test
	public void deveriaLimparTabuleiro() throws Exception{
		
		MockTabuleiro mock = new MockTabuleiro();
		
		Tabuleiro tabuleiro = new Tabuleiro(mock);
		
		assertArrayEquals(mock.getTabuleiro(), tabuleiro.limpar());
		
		
		
	}

}
