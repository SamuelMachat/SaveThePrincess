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
public abstract class Monster extends Troop {

    private int health = 300;
    private int attack = 10;
    private int speed = 5;
    private int def_points = 3;
    private String troopName = "prisera";

    @Override
    public int getHealth() {
        return health;
    }


    @Override
    public String getTroopName() {
        return troopName;
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

}
