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

        if(laby.pj.estACoter(laby.monstre)){
            laby.monstre.attaquer(laby.pj);
        } else{
            String [] action={Labyrinthe.GAUCHE,Labyrinthe.DROITE,Labyrinthe.HAUT,Labyrinthe.BAS};
            this.laby.deplacerPerso(action[(int) Math.floor(Math.random() * action.length)], this.laby.getMonstre());
        }

        if(clavier.space){
            laby.persoAttaquerMonstre();
        }

        if (clavier.droite) {
            laby.deplacerPerso(laby.DROITE, laby.pj);

        }
        if (clavier.gauche) {
            laby.deplacerPerso(laby.GAUCHE, laby.pj);

        }
        if (clavier.haut) {
            laby.deplacerPerso(laby.HAUT, laby.pj);


        }
        if (clavier.bas) {
            laby.deplacerPerso(laby.BAS, laby.pj);


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
