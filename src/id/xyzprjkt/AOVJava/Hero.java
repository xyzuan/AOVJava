package id.xyzprjkt.AOVJava;

public abstract class Hero {

    private double healthPoint;
    private double attackDamage;
    private double realDamage;
    private double defense;
    private int level = 1;
    private boolean lifeStatus = true;
    public double damageKontol;

    public void attack (
        // Hero Name Params
        String p1_name, String p2_name,

        // Calculate realDamage Params
        double p1_attackDamage, double p2_defense,

        // Health Target Params
        double p2_health){

        System.out.printf("\n=== %s Turn ===\n", p1_name); spawnIntro();
        reviewDamage(p1_attackDamage, p2_defense);
        damageKontol = p2_health - getRealDamage();
        System.out.printf("%s HP Remaining : %.1f\n", p2_name, damageKontol);
    }

    public abstract void initHero();
    public void reviewDamage(double attackDamage, double defense){
        setRealDamage(attackDamage - defense);
    }

    public void checkStatus(String hero){
        System.out.println("\n=== " + hero + " ===");
        System.out.printf("Level : %d\n", getLevel());
        System.out.printf("Attack damage\t\t : %.1f\t\t Life status : %b\nHealth point\t\t : %.1f\t\t Defense : %.1f\n",
                           getAttackDamage(), isLifeStatus(), getHealthPoint(), getDefense());
    }
    public abstract void spawnIntro();

    public abstract void upLevel(int level);

    // Setter Getter
    public double getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(double healthPoint) {
        this.healthPoint = healthPoint;
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isLifeStatus() {
        return lifeStatus;
    }

    public void setLifeStatus(boolean lifeStatus) {
        this.lifeStatus = lifeStatus;
    }

    public double getRealDamage() {
        return realDamage;
    }

    public void setRealDamage(double realDamage) {
        this.realDamage = realDamage;
    }
}
