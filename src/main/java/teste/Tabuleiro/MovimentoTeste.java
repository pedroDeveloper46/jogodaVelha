package teste.Tabuleiro;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pedro.jogoDavelha.Mock.MockMovimento;
import pedro.jogoDavelha.centro.InvalidMoveException;
import pedro.jogoDavelha.centro.Jogador;
import pedro.jogoDavelha.centro.Movimento;
import pedro.jogoDavelha.centro.Tabuleiro;

public class MovimentoTeste {
	
	
	public void deveriaFazerUmMovimento() throws Exception{
		
		Tabuleiro t = new Tabuleiro();
		
		MockMovimento m = new MockMovimento();
		
		Jogador jogador = new Jogador("Pedro", t, 'X' );
		
		Movimento movimento = jogador.InputMove(m);
		
		assertEquals(m.getMov(), movimento.retornaMovimento());
	}

}
