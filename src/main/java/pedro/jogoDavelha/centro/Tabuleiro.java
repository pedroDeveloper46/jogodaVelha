package pedro.jogoDavelha.centro;

import pedro.jogoDavelha.Constantes;
import pedro.jogoDavelha.Mock.MockTabuleiro;


public class Tabuleiro {
	
	private MockTabuleiro mock;
       
	private char[][] Matriz;
	
	public char[][] getMatriz() {
		return Matriz;
	}

	public void setMatriz(char[][] matriz) {
		Matriz = matriz;
	}

	public Tabuleiro() {
		Matriz = new char[Constantes.TABULEIRO_SIZE][Constantes.TABULEIRO_SIZE];
		limpar();
	}
	
	public Tabuleiro(MockTabuleiro mock) {
		Matriz = new char[Constantes.TABULEIRO_SIZE][Constantes.TABULEIRO_SIZE];
		mock.setTabuleiro(limpar());
	}
	
	
	
	public char[][] limpar() {
		for (int i = 0; i < Matriz.length; i++) {
			for (int j = 0; j < Matriz.length; j++) {
				Matriz[i][j] = ' ';
			}
		}
		
		return Matriz;
	}
	
	public boolean isFull() {
		for (int i = 0; i < Matriz.length; i++) {
			for (int j = 0; j < Matriz.length; j++) {
			       if(Matriz[i][j] == ' ') {
			            return false;    	   
			       }
			}
		}
		
		return true;
	}
	
	public void printTabuleiro() {
		 for (int i = 0; i < Matriz.length; i++) {
			  for (int j = 0; j < Matriz.length; j++) {
				   System.out.print(Matriz[i][j]);
				   if(j != (Matriz.length - 1)) {
					   System.out.print(" | ");
				   }
			  }
		   
			System.out.println();
			if(i != (Matriz.length - 1)) {
		    	System.out.println("---------");
		    }
			  
		}
	}
	
	public boolean jogar(Jogador player, Movimento move)  throws InvalidMoveException{
		int i = move.getI();
		int j = move.getJ();
		
		if(i < 0 || j < 0 || i >= Constantes.TABULEIRO_SIZE || j >= Constantes.TABULEIRO_SIZE) {
			throw new InvalidMoveException("Jogada fora do intervalo do tabuleiro");
		}
		if(Matriz[i][j] != ' ') {
			throw new InvalidMoveException("Essa jogada já foi realizada");
		}
		
		Matriz[i][j] = player.getSimbolo();
		
		return checksRows(player) || checksCols(player) || checkDiagonal1(player) || checkDiagonal2(player);
		
	}
	
	private boolean checksRows(Jogador jogador) {
		for(int i = 0; i < Constantes.TABULEIRO_SIZE; i++) {
			if(checkRow(i, jogador)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	private boolean checkRow(int i, Jogador player) {
		char symbol = player.getSimbolo();
		
		for (int j = 0; j < Constantes.TABULEIRO_SIZE; j++) {
			if (Matriz[i][j] != symbol) {
				return false;
			}
		}
		
		return true;
	}	
	
	private boolean checkCol(int j, Jogador player) {
		char symbol = player.getSimbolo();
		
		for (int i = 0; i < Constantes.TABULEIRO_SIZE; i++) {
			if (Matriz[i][j] != symbol) {
				return false;
			}
		}
		
		return true;
	}
	private boolean checksCols(Jogador jogador) {
		for(int j = 0; j < Constantes.TABULEIRO_SIZE; j++) {
			if(checkCol(j, jogador)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	private boolean checkDiagonal1(Jogador jogador) {
		char symbol = jogador.getSimbolo();
		
		for (int i = 0; i < Matriz.length; i++) {
			if(Matriz[i][i] != symbol) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkDiagonal2(Jogador jogador) {
		char symbol = jogador.getSimbolo();
		int lastLine = Constantes.TABULEIRO_SIZE -1;
		
		//linha= 2 - 1 - 0
	    //coluna= 0 - 1 - 2
		for(int i = lastLine, j = 0; i >= 0; i--, j++) {
			if(Matriz[i][j] != symbol) {
				return false;
			}
		}
		
		return true;
		
		
	}
	
}
