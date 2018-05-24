package Unitarias;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import es.codeurjc.ais.tictactoe.TicTacToeGame.Cell;
import es.codeurjc.ais.tictactoe.Board;

public class TestVictoriaPlayer2 {
	
	@Test
	public void VictoriaPlayer2(){
		Board tablerojuego= new Board();
		
		Cell pos0 = tablerojuego.getCell(0);
		pos0.setActive(true);
		pos0.setValue("Player1");
		
		Cell pos1 = tablerojuego.getCell(1);
		pos1.setActive(true);
		pos1.setValue("Player2");
		
		Cell pos2 = tablerojuego.getCell(2);
		pos2.setActive(true);
		pos2.setValue("Player1");
		
		Cell pos4 = tablerojuego.getCell(4);
		pos4.setActive(true);
		pos4.setValue("Player2");
		
		Cell pos5 = tablerojuego.getCell(5);
		pos5.setActive(true);
		pos5.setValue("Player1");
		
		Cell pos7 = tablerojuego.getCell(7);
		pos7.setActive(true);
		pos7.setValue("Player2");
		
		int[] solution = {1,4,7};
		int[] x = tablerojuego.getCellsIfWinner("Player2");
		assertThat(solution).isEqualTo(x);
	}

}
