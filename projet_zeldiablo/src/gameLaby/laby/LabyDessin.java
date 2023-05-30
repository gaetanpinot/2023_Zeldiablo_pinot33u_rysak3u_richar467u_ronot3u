package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

public class LabyDessin implements DessinJeu {
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        Labyrinthe laby = ((LabyJeu)jeu).getLaby();

        final GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int taille=20;
        for (int i = 0; i < laby.getLength(); i++) {
            for (int j = 0; j < laby.getLengthY(); j++) {
                if(laby.getMur(i, j)){
                    gc.setFill(Color.BLACK);
                    gc.fillRect(i + i * taille, j + j * taille, taille, taille);
                }
                
                if(laby.pj.etrePresent(i, j)){
                    gc.setFill(Color.RED);
                    gc.fillRect(i + i * taille, j + j * taille, taille , taille);
                }
            }
        }
    }
}
