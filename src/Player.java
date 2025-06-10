//player class
class Player {
    private String name;
    private int healthPoints;
    private int attackPower;
    private int level;

    public Player(String name, int healthPoints, int attackPower, int level) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
        this.level = level;
    }

    public String getName() {
        return name;
    }
    
    public int getHealthPoints() {
        return healthPoints;
    }

    public int getAttackPower(){
        return attackPower;
    }

//take damage
    public void takeDamage(int amount) {
        healthPoints -= amount;
        if (healthPoints < 0) healthPoints = 0;
        System.out.println(name + " takes " + amount + " damage, HP is now " + healthPoints);
        if (healthPoints == 0) {
            System.out.println(name + " has been defeated!");
        }
    }
//level up
    public void levelUp() {
        level++;
        attackPower += 5;
        healthPoints += 20;
        System.out.println(name + " leveled up to level " + level + "! Attack power and HP increased.");
    }

    public void showStats() {
        System.out.println("Player: " + name);
        System.out.println("HP: " + healthPoints);
        System.out.println("Attack Power: " + attackPower);
        System.out.println("Level: " + level);
    }
//check if alive
    public boolean isAlive() {
        return healthPoints > 0;
    }
}
