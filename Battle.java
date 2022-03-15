public class Battle {
    public static void main(String[] args) {
        var hero = new Char("Knight", 14, 5, 80, null);
        var enemy = Char.createGoblin();

        System.out.println("Nome do heroi: " + hero.getName());
        System.out.println("Nome do inimigo: " + enemy.getName());

        //BATALHA ATE A MORTE!!!!
        int turno = 1;
        //Enquanto o heroi e o inimigo estao vivos
        while (hero.isAlive() && enemy.isAlive()) {
            System.out.println("TURNO " + turno);
            hero.attack(enemy);
            enemy.attack(hero);
            turno++;
            System.out.println();
        }

        var winner = hero.getLife() > 0 ? hero : enemy;
        System.out.println(winner.getName() + " venceu!");
    }
}
