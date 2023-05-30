import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Monstre;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class TestMonstre {
    @Test
    public void testMonstredansPerso() throws IOException {
        Labyrinthe laby=new Labyrinthe("./fichierTest/laby0Test.txt");
        int x=laby.getMonstre().getX();
        int y=laby.getMonstre().getY();

        laby.deplacerPerso(Labyrinthe.GAUCHE,laby.getMonstre());
        int x2=laby.getMonstre().getX();
        int y2=laby.getMonstre().getY();

        assertEquals(x,x2,"le monstre ne devrait pas avoir bouger");
        assertEquals(y,y2,"le monstre ne devrait pas avoir bouger");
    }
    @Test
    public void testMonstredansMur()throws IOException{
        Labyrinthe laby=new Labyrinthe("./fichierTest/laby0Test.txt");
        int x=laby.getMonstre().getX();
        int y=laby.getMonstre().getY();

        laby.deplacerPerso(Labyrinthe.DROITE,laby.getMonstre());
        int x2=laby.getMonstre().getX();
        int y2=laby.getMonstre().getY();

        assertEquals(x,x2,"le monstre ne devrait pas avoir bouger");
        assertEquals(y,y2,"le monstre ne devrait pas avoir bouger");
    }
    @Test
    public void deplacementOK()throws IOException{
        Labyrinthe laby=new Labyrinthe("./fichierTest/laby0Test.txt");
        int x=laby.getMonstre().getX();
        int y=laby.getMonstre().getY()-1;

        laby.deplacerPerso(Labyrinthe.HAUT,laby.getMonstre());
        int x2=laby.getMonstre().getX();
        int y2=laby.getMonstre().getY();

        assertEquals(x,x2,"le monstre ne devrait pas avoir bouger sur l'axe x");
        assertEquals(y,y2,"le monstre devrait avoir bouger d'un cran en haut");
    }
}
