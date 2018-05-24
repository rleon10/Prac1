package ConDobles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import es.codeurjc.ais.tictactoe.Connection;
import es.codeurjc.ais.tictactoe.Player;
import es.codeurjc.ais.tictactoe.TicTacToeGame;
import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;

public class TestConDobleVictoriaPlayer2 {

	@Test
	public void VictoriaPlayer2() {
		
				
		TicTacToeGame game = new TicTacToeGame();
		Connection connection1 = mock(Connection.class);
		Connection connection2 = mock(Connection.class);
		game.addConnection(connection1);
		game.addConnection(connection2);
		Player Player1 = new Player(1,"0","Player1");
		Player Player2 = new Player(2,"X","Player2");
		
				
		reset(connection1);
		reset(connection2);
		
		
		game.addPlayer(Player1);
		game.addPlayer(Player2);
		verify(connection1,times(2)).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(Player1, Player2))); 
		verify(connection2,times(2)).sendEvent(eq(EventType.JOIN_GAME), argThat(hasItems(Player1, Player2))); 
		
		reset(connection1);
		reset(connection2);
		
		game.mark(0);
		ArgumentCaptor<Player> argument = ArgumentCaptor.forClass(Player.class); 
		verify(connection1).sendEvent(eq(EventType.SET_TURN), argument.capture()); 
		Object turn = argument.getValue();
		assertThat(turn).isEqualTo(Player2);
		verify(connection2).sendEvent(eq(EventType.SET_TURN), argument.capture());
		turn = argument.getValue();
		assertThat(turn).isEqualTo(Player2);
		
		reset(connection1);
		reset(connection2);
		
		game.mark(1);
		verify(connection1).sendEvent(eq(EventType.SET_TURN), argument.capture()); 
		turn = argument.getValue();
		assertThat(turn).isEqualTo(Player1);
		verify(connection2).sendEvent(eq(EventType.SET_TURN), argument.capture());
		turn = argument.getValue();
		assertThat(turn).isEqualTo(Player1);
		
		reset(connection1);
		reset(connection2);
		
		game.mark(2);
		verify(connection1).sendEvent(eq(EventType.SET_TURN), argument.capture()); 
		turn = argument.getValue();
		assertThat(turn).isEqualTo(Player2);
		verify(connection2).sendEvent(eq(EventType.SET_TURN), argument.capture());
		turn = argument.getValue();
		assertThat(turn).isEqualTo(Player2);
		
		reset(connection1);
		reset(connection2);
		
		game.mark(4);
		verify(connection1).sendEvent(eq(EventType.SET_TURN), argument.capture()); 
		turn = argument.getValue();
		assertThat(turn).isEqualTo(Player1);
		verify(connection2).sendEvent(eq(EventType.SET_TURN), argument.capture());
		turn = argument.getValue();
		assertThat(turn).isEqualTo(Player1);
		
		reset(connection1);
		reset(connection2);
		
		game.mark(5);
		verify(connection1).sendEvent(eq(EventType.SET_TURN), argument.capture()); 
		turn = argument.getValue();
		assertThat(turn).isEqualTo(Player2);
		verify(connection2).sendEvent(eq(EventType.SET_TURN), argument.capture());
		turn = argument.getValue();
		assertThat(turn).isEqualTo(Player2);
		
		reset(connection1);
		reset(connection2);
		
		game.mark(7);
		
		ArgumentCaptor<Object> solution = ArgumentCaptor.forClass(Object.class); 
		verify(connection1).sendEvent(eq(EventType.GAME_OVER), solution.capture()); 
		Object event = solution.getValue();
		assertThat(event).isNotEqualTo(null);
		verify(connection2).sendEvent(eq(EventType.GAME_OVER), solution.capture());
		event = solution.getValue();
		assertThat(event).isNotEqualTo(null);
	
}
}
