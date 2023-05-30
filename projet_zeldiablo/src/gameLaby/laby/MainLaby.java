package gameLaby.laby;

import moteurJeu.MoteurJeu;

import java.io.IOException;

public class MainLaby {
    public static void main(String[] args) throws IOException {


        int width = 800;
        int height = 600;
        int pFPS = 10;

        LabyJeu lj=new LabyJeu();
        lj.laby=new Labyrinthe("labySimple/labydefaut.txt");
        LabyDessin ld=new LabyDessin();

        MoteurJeu.setTaille(width,height);
        MoteurJeu.setFPS(100);

        MoteurJeu.launch(lj,ld);



    }
}
