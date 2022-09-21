/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machat.app;

/**
 *
 * @author samac
 */
public class OrcWarrior extends Monster {

    private int attack = 20;
    private int speed = 3;
    private int def_points = 8;
    private String troopName = "skreti valecnik";

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
