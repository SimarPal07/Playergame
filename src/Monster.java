public class Monster {
    private String name;
    private int healthPoints;
    private int attackPower;

    public Monster(String name, int healthPoints, int attackPower) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
    }

    public void takeDamage(int amount) {
        healthPoints -= amount;
        if (healthPoints < 0) healthPoints = 0;
        System.out.println(name + " takes " + amount + " damage, HP is now " + healthPoints);
        if (healthPoints == 0) {
            System.out.println(name + " has been defeated!");
        }
    }

    public void attackPlayer(Player player) {
        System.out.println(name + " attacks " + player.getName() + " for " + attackPower + " damage.");
        player.takeDamage(attackPower);
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
}
