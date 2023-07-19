import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> registeredPlayers = new ArrayList<>();

    public void register(Player player) {
        registeredPlayers.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findRegisteredPlayer(playerName1);
        Player player2 = findRegisteredPlayer(playerName2);

        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("Оба игрока должны быть зарегистрированы");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

    public Player findRegisteredPlayer(String playerName) {
        for (Player player : registeredPlayers) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }
}
