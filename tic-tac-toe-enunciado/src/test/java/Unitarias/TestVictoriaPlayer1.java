package Unitarias;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import es.codeurjc.ais.tictactoe.TicTacToeGame.Cell;
import es.codeurjc.ais.tictactoe.Board;


public class TestVictoriaPlayer1 {
	
	@Test
	public void VictoriaPlayer1(){
		Board tablerojuego = new Board();
		

		Cell pos0 = tablerojuego.getCell(0);
		pos0.setActive(true);
		pos0.setValue("Player1");
		

		Cell pos4 = tablerojuego.getCell(4);
		pos4.setActive(true);
		pos4.setValue("Player2");
		

		Cell pos3 = tablerojuego.getCell(3);
		pos3.setActive(true);
		pos3.setValue("Player1");
		

		Cell pos5 = tablerojuego.getCell(5);
		pos5.setActive(true);
		pos5.setValue("Player2");
		

		Cell pos6 = tablerojuego.getCell(6);
		pos6.setActive(true);
		pos6.setValue("Player1");
		

		
		
		
		int[] solution = {0,3,6};
		int[] x = tablerojuego.getCellsIfWinner("Player1");
		assertThat(solution).isEqualTo(x);
		
	}

}
