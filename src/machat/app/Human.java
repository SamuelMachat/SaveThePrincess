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
public class Human extends Troop implements Bafable {

    private int health = 100;
    private int attack = 5;
    private int speed = 10;
    private int def_points = 0;
    private String troopName = "sedlak";
    private int level = 1;

    @Override
    public String getTroopName() {
        return troopName;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public int getDef_points() {
        return def_points;
    }

    @Override
    public void baf() {
        System.out.println(this.troopName + " se vydesil.");
        this.attack--;
    }

    void levelUp() {
        this.level++;
        if (this.level % 3 == 0) {
            this.attack += 2;
            this.def_points += 3;

        }
    }
}
