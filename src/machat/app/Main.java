/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machat.app;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author samuel.machat
 */
public class Main {

    // objekt pro čtení vstupů
    public static Scanner in = new Scanner(System.in);
    // základní parametry hry
    static boolean end = false;
    static Fellowship fellowship = new Fellowship();
    static int day = 1;
    static int path_max = 7;
    static int path = 7;
    static int dayLimit = 10;
    static int fellowshipSpeed = 1;
    static boolean looked = false;
    static Random rand = new Random();
    static String choice;

    public static void main(String[] args) {
        System.out.println("Vitejte ve hre Zachran princeznu");
        while (!end) {
            System.out.println("HLAVNI MENU");
            System.out.println("1. Necht zapocne dobrodruzstvi!");
            System.out.println("2. O hre");
            System.out.println("0. Konec");
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Za cestou ke svemu ctnostnemu cili se ti nepodarilo pobrat moc odvazlivcu. Ale jak se rika \"Dva jsou vic nez jeden!\"");
                    fellowship.addTroop(new Swordsman());
                    fellowship.addTroop(new Human());
                    while (!end) {
                        if (path > 0) {
                            viewPlayingMenu();
                        } else {
                            end = true;
                            if (day > dayLimit) {
                                System.out.println("Prisel jsi do hradu, prosel vsechny pavuciny, ale princezna nikde. Az najednou na posteli jsi zahledl papir se vzkazem: Uz me nebavilo cekat, tak jsem sla pryc. S pozdravem Princezna");
                            } else {
                                System.out.println("Dosel jsi do cile a zachranil princeznu!");
                            }
                        }
                    }
                    break;
                case "2":

                    System.out.println("O HRE");
                    System.out.println("Cilem hry je probojovat se svou druzinou az do hradu a tam zachranit princeznu. Dej si pozor, abys neprisel prilis pozde.");
                    System.out.println("Zadejte libovolny znak pro Zpet");
                    choice = in.nextLine();

                    break;
                case "0":
                    System.out.println("Navidenou pri dalsim hrani");
                    end = true;
                    break;
                default:
                    System.out.println("Neplatny vstup");
            }
        }
        in.close();
    }

    public static void viewFightMenu(Fellowship enemies) {
        enemies.viewStats();
        fellowship.viewStats();

        System.out.println("1. Bojovat");
        System.out.println("2. Vzdat se");
        System.out.println("3. Utect");
        boolean fighting = true;
        while (fighting) {
            choice = in.nextLine();
            switch (choice) {
                case "1":
                    // bojovy system
                    fellowship.getFightFactor();
                    enemies.getFightFactor();
                    if (fellowship.getFightFactor() > enemies.getFightFactor() || rand.nextInt(100) <= 5) {
                        enemies.maybeDie();
                        if (enemies.getTroops().isEmpty()) {
                            System.out.println("Rozdrtili jste je, jen se po nich prasi.");
                        } else {
                            System.out.println("Uspesne jsi porazil nepratele, ale par jich jeste zbylo. Co s nimi udelas?");
                            viewCatchMenu(enemies);
                        }
                        fellowship.train();
                    } else {
                        fellowship.maybeDie();
                        if (fellowship.getTroops().isEmpty()) {
                            System.out.println("Tva druzina byla drtive porazena.");
                            end = true;
                        } else {
                            System.out.println("Boj jste prohrali. Co budes delat dal?");
                            viewFightMenu(enemies);
                        }
                    }
                    fighting = false;
                    break;
                case "2":
                    System.out.println("Vzdal ses a skreti te s radosti slupli.");
                    end = true;
                    fighting = false;
                    break;
                case "3":
                    fellowship.flee();
                    path++;
                    if (fellowship.getTroops().isEmpty()) {
                        System.out.println("Cela tva druzina byla pochytana a snedena.");
                        end = true;
                    }
                    System.out.println("Podarilo se ti utect");
                    fighting = false;
                    break;
                default:
                    System.out.println("Neplatny vstup");
            }
        }
    }

    public static void viewPlayingMenu() {
        System.out.println("DEN " + day);
        System.out.println("1. Jit dal");
        System.out.println("2. Trenovat a vyspat se");
        System.out.println("3. Rozhlednout se");
        System.out.println("4. Statistiky druziny");
        System.out.println("0. Konec hry");
        choice = in.nextLine();
        switch (choice) {
            case "1":
                goToPrincess();
                break;
            case "2":
                goSleep();
                break;
            case "3":
                if (looked) {
                    System.out.println("Uz se neni na co koukat.");
                } else {
                    lookAround();
                    looked = true;
                }
                break;
            case "4":
                fellowship.viewStats();
                break;
            case "0":
                System.out.println("Navidenou pri dalsim hrani");
                end = true;
                break;
            default:
                System.out.println("Neplatny vstup");
        }
    }

    public static void lookAround() {
        fellowship.getTroops().size();
        getRandBonus(fellowship);
    }

    public static void goSleep() {
        fellowship.train();
        System.out.println("Druzina potrenovala a krasne se vyspala.");
        day++;
        looked = false;
    }

    public static void goToPrincess() {
        System.out.println("A jsi opet o krok dal k princezne.");
        path = path - fellowshipSpeed;

        if (rand.nextInt(1000) * fellowship.getFellowshipFactor() > 500) {
            System.out.println("Potkal jsi zle skrety, kteri ti nedaji pokoj, dokud si z tebe neudelaji veceri.");

            Fellowship enemies = new Fellowship();
            int enemies_n = (path_max - path) / 3 + 1;

            for (int i = 0; i < enemies_n; i++) {

                if (rand.nextInt(100) < 70) {
                    enemies.addTroop(new OrcWarrior());
                } else {
                    enemies.addTroop(new Cyclops());
                }
            }
            for (Troop troop : fellowship.getTroops()) {
                if (troop instanceof Bafable) {
                    ((Bafable) troop).baf();
                }
            }
            viewFightMenu(enemies);

        } else {
            System.out.println("Cesta byla klidna a nic zvlastniho se nestalo.");
        }

        day++;
        looked = false;
    }

    private static void getRandBonus(Fellowship fellowship) {
        if (rand.nextInt(1000) * fellowship.getFellowshipFactor() > 500) {
            Swordsman troop = new Swordsman(rand.nextInt(5) + 1);
            fellowship.addTroop(troop);
            System.out.println("Potkal jsi pocestneho a ten se k tobe pridal.");
        } else {
            System.out.println("Nikde nic.");
        }
    }

    private static void viewCatchMenu(Fellowship enemies) {
        System.out.println("1. Zabit");
        System.out.println("2. Pokusit se presvedcit, at se pridaji k tobe");
        System.out.println("0. Konec hry");
        choice = in.nextLine();
        switch (choice) {
            case "1":
                for (Troop troop : enemies.getTroops()) {
                    troop.die();
                }
                break;
            case "2":
                for (Troop troop : enemies.getTroops()) {
                    fellowship.addTroop(troop);
                }
                break;
            case "0":
                System.out.println("Navidenou pri dalsim hrani");
                end = true;
                break;
            default:
                System.out.println("Neplatny vstup");
        }
    }

}
