import java.util.ArrayList;
import java.util.Scanner;
//main loop
public class Gamemanager {
    private static ArrayList<Player> players = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Simple Game Character Manager!");

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Create new player");
            System.out.println("2. Attack monster with a player");
            System.out.println("3. Show player stats");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    createPlayer();
                    break;
                case 2:
                    attackMonster();
                    break;
                case 3:
                    showPlayerStats();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting game. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
//create player
private static void createPlayer() {
        System.out.print("Enter player name: ");
        String name = scanner.nextLine();
        // Defaults for new player
        Player p = new Player(name, 100, 10, 1);
        players.add(p);
        System.out.println("Player " + name + " created with 100 HP, 10 Attack, Level 1.");
    }
    //attack monster logic
    private static void attackMonster() {
        if (players.isEmpty()) {
            System.out.println("No players created yet.");
            return;
        }
        System.out.println("Select player to attack:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i).getName() + " (HP: " + players.get(i).getHealthPoints() + ")");
        }
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx < 0 || idx >= players.size()) {
            System.out.println("Invalid player selection.");
            return;
        }
        Player player = players.get(idx);
    
        if (!player.isAlive()) {
            System.out.println("Player is defeated and cannot fight.");
            return;
        }
    
        // Create a new monster for each fight
        Monster monster = new Monster("Goblin", 50, 10);
        System.out.println(player.getName() + " encounters a " + monster.getName() + "!");
    
        // Simple fight loop
        while (player.isAlive() && monster.isAlive()) {
            monster.takeDamage(player.getAttackPower());  // <-- fixed here
            if (monster.isAlive()) {
                monster.attackPlayer(player);
            }
        }
    
        if (player.isAlive()) {
            player.levelUp();
        }
    }
    //show player stats
    private static void showPlayerStats() {
        if (players.isEmpty()) {
            System.out.println("No players created yet.");
            return;
        }
        System.out.println("Select player to show stats:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i+1) + ". " + players.get(i).getName() );
        }
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx < 0 || idx >= players.size()) {
            System.out.println("Invalid player selection.");
            return;
        }
        players.get(idx).showStats();
    }
    
}