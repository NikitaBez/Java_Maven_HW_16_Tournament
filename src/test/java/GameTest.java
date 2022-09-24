import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Player player1 = new Player(1,"Ivan", 50);
    Player player2 = new Player(2,"Arnold", 30);
    Player player3 = new Player(3,"Alex", 40);
    Player player4 = new Player(4,"Gopnik", 40);

    @Test
    public void shouldShowTheWinnerIfTheFirstIsStronger () {

        Game game = new Game();
        game.registered(player1);
        game.registered(player2);
        game.registered(player3);
        game.registered(player4);

        int actual = game.round(player1.getName(), player2.getName());
        int expected = 1;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldShowTheWinnerIfTheSecondIsStronger() {

        Game game = new Game();
        game.registered(player1);
        game.registered(player2);
        game.registered(player3);
        game.registered(player4);

        int actual = game.round(player2.getName(), player3.getName());
        int expected = 2;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldShowTheWinnerIfBothAreEqual() {

        Game game = new Game();
        game.registered(player1);
        game.registered(player2);
        game.registered(player3);
        game.registered(player4);

        int actual = game.round(player3.getName(), player4.getName());
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void shouldShowTheWinnerIfSecondPlayerIsUnregistered() {

        Game game = new Game();
        game.registered(player1);
        game.registered(player2);
        game.registered(player3);
        game.registered(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player3.getName(), "Unregistered player");
        });
    }
    @Test
    public void shouldShowTheWinnerIfFirstPlayerIsUnregistered() {

        Game game = new Game();
        game.registered(player1);
        game.registered(player2);
        game.registered(player3);
        game.registered(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Unregistered player", player3.getName());
        });
    }
}