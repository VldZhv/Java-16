import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void shouldRegisterPlayer() {
        Player player1 = new Player(1, "Вася", 10);
        Player player2 = new Player(2, "Петя", 15);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Player foundPlayer1 = game.findRegisteredPlayer("Вася");
        Player foundPlayer2 = game.findRegisteredPlayer("Петя");

        Assertions.assertEquals(player1, foundPlayer1);
        Assertions.assertEquals(player2, foundPlayer2);
    }

    @Test
    public void player1Wins() {
        Player player1 = new Player(1, "Вася", 10);
        Player player2 = new Player(2, "Петя", 7);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int result = game.round("Вася", "Петя");

        Assertions.assertEquals(1, result);
    }

    @Test
    public void player2Wins() {
        Player player1 = new Player(1, "Вася", 10);
        Player player2 = new Player(2, "Петя", 15);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int result = game.round("Вася", "Петя");

        Assertions.assertEquals(2, result);
    }

    @Test
    public void draw() {
        Player player1 = new Player(1, "Вася", 10);
        Player player2 = new Player(2, "Петя", 10);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int result = game.round("Вася", "Петя");

        Assertions.assertEquals(0, result);
    }

    @Test
    public void notRegisteredPlayers() {
        Player player1 = new Player(1, "Вася", 10);
        Player player2 = new Player(2, "Петя", 15);

        Game game = new Game();
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Вася", "Петя"));
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Петя", "Вася"));
    }
}
