package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

public class LabyJeu implements Jeu {

    private Labyrinthe laby;


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
        try {
            laby = new Labyrinthe("labySimple/laby1.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean etreFini() {
        return laby.etreFini();
    }
}
