import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.tournament.Game;
import ru.netology.tournament.NotRegisteredException;
import ru.netology.tournament.Player;

public class GameTest {
    Game games = new Game();
    Player player1 = new Player(126, "Name1", 256);
    Player player2 = new Player(362, "Name2", 241);
    Player player3 = new Player(69, "Name3", 85);
    Player player4 = new Player(365, "Name4", 65);
    Player player5 = new Player(254, "Name5", 256);
    Player player6 = new Player(25, "Name6", 154);
    Player player7 = new Player(256, "Name7", 89);
    Player player8 = new Player(78, "Name8", 204);
    Player player9 = new Player(156, "Name9", 96);
    Player player10 = new Player(158, "Name10", 256);

    @BeforeEach
    public void setUp() {
        games.registration(player1);
        games.registration(player2);
        games.registration(player3);
        games.registration(player4);
        games.registration(player5);
        games.registration(player6);
        games.registration(player7);
        games.registration(player8);
        games.registration(player9);
        games.registration(player10);

    }

    @Test
    public void gameNumberOne() {                          // игра между 5-м и 2-м игроком, выигрывает 5-й
        int expected = 1;
        int actual = games.round("Name5", "Name2");
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void gameNumberTwo() {                          // игра между 9-м и 6-м игроком, выигрывает 6-й
        int expected = 2;
        int actual = games.round("Name9", "Name6");
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void gameNumberThree() {                          // игра между 1-м и 5-м игроком, ничья
        int expected = 0;
        int actual = games.round("Name1", "Name5");
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void firstPlayerWithoutRegistration() {                              // первый игрок без регистрации
        Assertions.assertThrows(NotRegisteredException.class, () -> {

            games.round("Name11", "Name5");
        });
    }

    @Test
    public void secondPlayerWithoutRegistration() {                                 // второй игрок без регистрации
        Assertions.assertThrows(NotRegisteredException.class, () -> {

            games.round("Name1", "Name20");
        });
    }

}
