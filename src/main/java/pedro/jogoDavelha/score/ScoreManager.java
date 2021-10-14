package pedro.jogoDavelha.score;

import java.io.IOException;

import pedro.jogoDavelha.centro.Jogador;

public interface ScoreManager {
	
	public Integer getScore(Jogador jogador);
	
	public void saveScore(Jogador jogador) throws IOException;

}
