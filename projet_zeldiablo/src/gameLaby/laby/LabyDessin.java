package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

public class LabyDessin implements DessinJeu {
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        Labyrinthe laby = ((LabyJeu) jeu).getLaby();

        final GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int taille = 40;
        for (int i = 0; i < laby.getLength(); i++) {
            for (int j = 0; j < laby.getLengthY(); j++) {
                if (laby.getMur(i, j)) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(i * taille, j * taille, taille, taille);
                }

                if (laby.pj.etrePresent(i, j)) {
                    if(laby.pj.getAttaque()){
                        gc.setFill(Color.DARKBLUE);
                    }else {
                        gc.setFill(Color.RED);
                    }
                    gc.setGlobalAlpha((double) laby.pj.getVie()/laby.pj.getMaxVie());
                    gc.fillOval(i * taille, j * taille, taille, taille);
                }
                gc.setGlobalAlpha(1);

                if (laby.monstrePresent(i, j)) {
                    Monstre tempM=laby.monstreEnXY(i,j);
                    if(tempM.getAttaque()){
                        gc.setFill(Color.BLACK);
                    }else {
                        gc.setFill(Color.DARKGREEN);
                    }
                    gc.setGlobalAlpha((double) tempM.getVie() /tempM.getMaxVie());

                    gc.fillOval(i * taille, j * taille, taille, taille);
                    if(tempM.etreMort()){
                        gc.setFill(Color.WHITE);
                        gc.fillOval(i * taille, j * taille, taille, taille);
                    }
                }
                gc.setGlobalAlpha(1);

                if (laby.getPorte().etreFerme()&& laby.getPorte().etrePresent(i,j)) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(i * taille, j * taille, taille, taille);

                }

                for (CaseDeclencheur c:laby.caseD) {
                    if (c instanceof CasePiege){
                        if(((CasePiege) (c)).getPasserDessus()){
                            gc.setFill(Color.BROWN);
                            gc.fillRect(c.getX() * taille, c.getY() * taille, taille, taille);
                        }
                    }
                }
            }
        }
        if(laby.etreFini()){
            gc.setFill(Color.YELLOW);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.setFill(Color.BLACK);
            gc.fillText("Fin du jeu", canvas.getWidth()/2, canvas.getHeight()/2);
        }
    }
}
