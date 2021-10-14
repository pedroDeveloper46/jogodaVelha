package pedro.jogoDavelha.centro;



import java.io.IOException;

import br.com.softblue.commons.io.Console;
import pedro.jogoDavelha.Constantes;
import pedro.jogoDavelha.Mock.MockJogador;
import pedro.jogoDavelha.Mock.MockMovimento;
import pedro.jogoDavelha.UI.UI;
import pedro.jogoDavelha.score.FileScoreManager;
import pedro.jogoDavelha.score.ScoreManager;

public class Game {
      
	private Tabuleiro tabuleiro = new Tabuleiro();
	private Jogador[] jogadores = new Jogador[Constantes.SIMBOLOS_JOGADORES.length];
	
	private int currentPlayer = -1;
	
	private ScoreManager score;
	
	private MockJogador mock;
	
	private MockMovimento mockM;
	
	public Game(MockJogador mock) {
		this.mock = mock;
		nextPlayer();
	}
	
	public Game() {
		
	}
	
	public int getCurrentPlayer() {
		return currentPlayer;
	}
	
	
     

	public void play() throws IOException {
    	 UI.titleOfGame();
    	 
    	 score = createScore();
    	 
    	 
    	 for (int i = 0; i < jogadores.length; i++) {
			 jogadores[i] = createPlayer(i);
		}
    	
    	 boolean gameEnd = false;
    	 Jogador proximoPlayer = nextPlayer();
    	 Jogador winner = null;
    	
       
    	 while(!gameEnd) {
    		 tabuleiro.printTabuleiro();
    		 boolean sequenceFound;
    		 try {
    			sequenceFound = proximoPlayer.play(mockM);
			} catch (InvalidMoveException e) {
				// TODO: handle exception
				System.out.println("ERRO: " + e.getMessage());
				continue;
			}
    		 
    		 if(sequenceFound) {
    			 gameEnd = true;
    			 winner = proximoPlayer;
    		 }else if(tabuleiro.isFull()) {
    			 gameEnd = true;
    		 }else {
    			 proximoPlayer = nextPlayer();
    		 }
    	 }
    	 
    	 if(winner == null) {
    		 System.out.println("DEU VELHA");
    	 }else {
    		 System.out.println("O JOGADOR " + winner.getNome() + " VENCEU");
    		 score.saveScore(winner);
    		 
    	 }
    	 
    	 tabuleiro.printTabuleiro();
    	 System.out.println("FIM DE JOGO");
    	 
    	 
    	 
    	 
    	 
     }
	
	private ScoreManager createScore() throws IOException {
		return new FileScoreManager();
	}
	
	
	private Jogador createPlayer(int index) {
		
		System.out.print("JOGADOR " + (index+1) +" => ");
		
		String nome = Console.readString();
		
		char symbol = Constantes.SIMBOLOS_JOGADORES[index];
		
		
		
		Jogador player = criaJogador(nome, tabuleiro, symbol);
		
		Integer historico = score.getScore(player);
		
		if(historico != null) {
			System.out.println("JOGADOR: " +player.getNome() + " possui " + historico + " pontos");
		}
		
		System.out.println("JOGADOR '" + nome + "' VAI USAR O SIMBOLO '" + symbol + "'" );
		
		return player;
		
		
	}
	
	public Jogador criaJogador(String nome, Tabuleiro tabuleiro, char symbol) {
		mock.setNome(nome);		
		return new Jogador(nome, tabuleiro, symbol);
	}
	
	private Jogador nextPlayer() {
		/*currentPlayer++;
		
		if(currentPlayer >= jogadores.length) {
			currentPlayer = 0;
		}*/
		
		currentPlayer = (currentPlayer + 1) % jogadores.length;
		
		mock.setIndex(currentPlayer);
		
		return jogadores[currentPlayer];
	}
     
    
}
