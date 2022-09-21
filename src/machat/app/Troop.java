/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machat.app;

/**
 *
 * @author samuel.machat
 */
public abstract class Troop {

    private int health;
    private int max_health;
    private int attack;
    private int speed;
    private int def_points;
    private int level = 1;
    private boolean alive = true;
    private String troopName;

    void die() {
        System.out.println(this.getTroopName() + " umrel.");
        this.alive = false;
    }

    void levelUp() {
        this.level++;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMax_health() {
        return max_health;
    }

    public void setMax_health(int max_health) {
        this.max_health = max_health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDef_points() {
        return def_points;
    }

    public void setDef_points(int def_points) {
        this.def_points = def_points;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTroopName() {
        return this.troopName;
    }
}
