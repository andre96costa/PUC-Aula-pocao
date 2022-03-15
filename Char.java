import java.util.Random;

public class Char {
    private static final Random RANDOM = new Random();

    private String name;
    private int skill;
    private int defense;
    private int life;
    private Pocao pocao;

    public Char(String name, int skill, int defense, int life, Pocao pocao) {
        if (skill <= 0) {
            throw new IllegalArgumentException("A skill deve ser maior que zero!");
        }

        if (defense < 0) {
            throw new IllegalArgumentException("A defense deve ser maior que zero!");
        }

        if (life < 0) {
            throw new IllegalArgumentException("A life deve ser maior que zero!");
        }

        this.name = name == null ? "" : name;
        this.skill = skill;
        this.defense = defense;
        this.life = life;
        if (pocao == null) {
            if (RANDOM.nextInt(2) == 1) {
                this.pocao = new Pocao();
            }
        } else {
            this.pocao = new Pocao();
        }
        System.out.println(this.name + " " + this.life);
    }

    public static Char createGoblin() {
        String names[] = {"Jorge", "Neto", "Splitz", "Giblles", "Toink"};
        String surnames[] = {"Potter", "the weak", "one eyed", "chief", "cook"};

        String goblinName = names[RANDOM.nextInt(names.length)] + " "
        + surnames[RANDOM.nextInt(surnames.length)];

        int skill = 5 + RANDOM.nextInt(9);
        int defense = 1 + RANDOM.nextInt(4);
        //int life = 10 + RANDOM.nextInt(31);
        int life = 70;
        return new Char(goblinName, skill, defense, life, new Pocao());
    }

    public String getName() {
        return name;
    }

    public int getSkill() {
        return skill;
    }

    public int getDefense() {
        return defense;
    }

    public int getLife() {
        return life;
    }

    public boolean isAlive() {
        return life > 0;
    }

    public void attack(Char enemy) {
        if (!isAlive()) {
            return;
        }

        System.out.printf("%s ataca %s! ", name, enemy.name);
        int dice1 = RANDOM.nextInt(6) + 1;
        int dice2 = RANDOM.nextInt(6) + 1;
        int dice3 = RANDOM.nextInt(6) + 1;

        int roll = dice1 + dice2 + dice3;
        int target = skill - enemy.defense;
        if (roll <= target) {
            System.out.println("ACERTOU!");
            int damage = RANDOM.nextInt(6) + 1;
            enemy.takeDamage(damage);
        } else {
            System.out.println("ERRRRRROU !");
        }
        if (this.pocao != null && canDrinkPotion()) {
            int[] arr = {dice1, dice2, dice3};
            var hpRestored = this.pocao.restoreHp(arr);
            if (hpRestored > 0) {
                life += hpRestored;
                System.out.println(this.name + " restaurou " + hpRestored + " de vida. Vida total: " + this.life);
            }
        }
    }
    public void takeDamage(int damage) {
        life = life - damage;
        if (life < 0) {
            life = 0;
        }
        System.out.printf("%s levou %d de dano. Life: %s%n",
                name, damage, life);
    }

    private boolean canDrinkPotion() {
        if (this.life <= 2 || this.life <= (this.life * 0.25)) {
            return true;
        }
        return false;
    }
}
