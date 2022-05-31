package id.xyzprjkt.AOVJava;

public abstract class Hero {

    private double healthPoint;
    private double attackDamage;
    private double defense;
    private int level;
    private boolean lifeStatus;

    void attack(){};

    void reviewDamage(){
        double realDamage = getAttackDamage() - getDefense();
    };

    void checkStatus(){};
    abstract void spawnIntro();

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
}
