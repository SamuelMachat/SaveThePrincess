/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machat.app;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import static machat.app.Main.rand;

/**
 *
 * @author samuel.machat
 */
public class Fellowship {

    ArrayList<Troop> troops = new ArrayList<Troop>();

    public void addTroop(Troop troop) {
        this.troops.add(troop);
    }

    public void train() {
        for (Troop troop : troops) {
            troop.levelUp();
        }
    }

    public ArrayList<Troop> getTroops() {
        return troops;
    }

    public void setTroops(ArrayList<Troop> troops) {
        this.troops = troops;
    }

    double getFellowshipFactor() {
        return this.troops.size() / 100 + 1;
    }

    public int getFightFactor() {
        int factor = 100;
        for (Troop troop : troops) {
            factor += troop.getAttack();
            factor += troop.getDef_points();
            factor += troop.getLevel();
            factor += troop.getHealth() / 100;
        }
        return factor;
    }

    void maybeDie() {
        try {
            for (Troop troop : this.troops) {
                if (rand.nextInt(15) > troop.getDef_points()) {
                    troop.die();
                    this.troops.remove(troop);
                }
            }
        } catch (ConcurrentModificationException e) {

        }
    }

    void flee() {
        try {
            for (Troop troop : troops) {
                if (rand.nextInt(15) > troop.getSpeed()) {
                    troop.die();
                    this.troops.remove(troop);
                }
            }
        } catch (ConcurrentModificationException e) {

        }
    }

    void viewStats() {
        System.out.println("STATISTIKY DRUZINY");
        System.out.println("Velikost skupiny " + this.troops.size());
        for (Troop troop : this.troops) {
            System.out.println(troop.getTroopName() + "\tLevel: " + troop.getLevel() + "\tZivoty: " + troop.getHealth());
        }
    }
}
