package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

public class LabyJeu implements Jeu {

    public Labyrinthe getLaby() {
        return laby;
    }

    public Labyrinthe laby;


    @Override
    public void update(double secondes, Clavier clavier) {
        if (clavier.droite) {
            laby.deplacerPerso(laby.DROITE);
        }
        if (clavier.gauche) {
            laby.deplacerPerso(laby.GAUCHE);
        }
        if (clavier.haut) {
            laby.deplacerPerso(laby.HAUT);
        }
        if (clavier.bas) {
            laby.deplacerPerso(laby.BAS);
        }


    }

    @Override
    public void init() {

    }

    @Override
    public boolean etreFini() {
        return laby.etreFini();
    }
}
