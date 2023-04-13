import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void roundWhenPlayer1IsStrongerThanPlayer2() {
        Player player1 = new Player(1, "Olya", 45);
        Player player2 = new Player(2, "Petya", 34);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Olya", "Petya");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void roundWhenPlayer2IsStrongerThanPlayer1() {
        Player player1 = new Player(1, "Olya", 12);
        Player player2 = new Player(2, "Petya", 23);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Olya", "Petya");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void roundWhenPlayer1IsEqualInStrengthToPlayer2() {
        Player player1 = new Player(1, "Olya", 23);
        Player player2 = new Player(2, "Petya", 23);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Olya", "Petya");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void player1IsNotRegistered() {
        Player player1 = new Player(1, "Olya", 45);
        Player player2 = new Player(2, "Petya", 34);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Misha", "Petya");
        });
    }

    @Test
    public void player2IsNotRegistered() {
        Player player1 = new Player(1, "Olya", 45);
        Player player2 = new Player(2, "Petya", 34);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Olya", "Masha");
        });
    }

}
