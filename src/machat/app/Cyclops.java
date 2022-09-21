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
public class Cyclops extends Monster {

    private int attack = 25;
    private int speed = 2;
    private int def_points = 9;
    private String troopName = "kyklop";

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

}
