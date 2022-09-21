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
public class Swordsman extends Human {

    private int attack = 5;
    private int speed = 7;
    private int def_points = 10;
    private String troopName = "rytir";
    private int level = 1;

    public Swordsman() {

    }

    public Swordsman(int level) {
        this.level = level;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getDef_points() {
        return def_points;
    }

    @Override
    public String getTroopName() {
        return troopName;
    }

    @Override
    public void baf() {
        System.out.println(this.troopName + " se hrozil.");
        this.def_points--;
    }

    @Override
    void levelUp() {
        this.level++;
        if (this.level % 3 == 0) {
            this.attack += 4;
            this.def_points += 1;
        }
    }
}
