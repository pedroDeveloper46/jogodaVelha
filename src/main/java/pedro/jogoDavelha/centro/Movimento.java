package pedro.jogoDavelha.centro;

import pedro.jogoDavelha.Mock.MockMovimento;

public class Movimento {

	private int i;
	private int j;

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	private String mov;

	public Movimento(String move, MockMovimento mock) throws InvalidMoveException {
		this.mov = move;

		mock.setMov(move);

		String[] str = move.split(",");

		this.i = Integer.parseInt(str[0]);

		this.j = Integer.parseInt(str[1]);
		
		
		

	}

	public String retornaMovimento() {
		return mov;
	}

}
