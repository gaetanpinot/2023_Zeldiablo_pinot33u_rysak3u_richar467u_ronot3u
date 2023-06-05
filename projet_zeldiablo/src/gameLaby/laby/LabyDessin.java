package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.awt.image.BufferedImage;

public class LabyDessin implements DessinJeu {
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        Labyrinthe laby = ((LabyJeu) jeu).getLaby();

        final GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int taille = 52;
        for (int i = 0; i < laby.getLength(); i++) {
            for (int j = 0; j < laby.getLengthY(); j++) {
                for (CaseDeclencheur c : laby.caseD) {
                    if (c instanceof CasePiege) {
                        if (((CasePiege) (c)).getPasserDessus()) {
                            gc.drawImage(new Image("/pik.png"), c.getX() * taille, c.getY() * taille);
                        }
                    }
                }

                if (laby.getMur(i, j)) {
                    gc.drawImage(new Image("/mur.png"), i * taille, j * taille);
                } else if (laby.pj.etrePresent(i, j)) {
                    gc.drawImage(new Image("/heroNoDamage.png"), i * taille, j * taille);
                } else if (laby.monstrePresent(i, j)) {
                    Monstre tempM = laby.monstreEnXY(i, j);
                    if (tempM instanceof Fantome) {
                        gc.drawImage(new Image("/phantome.png"), i * taille, j * taille);
                    } else if (tempM instanceof Troll) {
                        if (tempM.getAttaque()) {
                            gc.drawImage(new Image("/monstreFrappe.png"), i * taille, j * taille);
                        } else {
                            gc.drawImage(new Image("/monstrefrappepas.png"), i * taille, j * taille);
                        }
                    } else {
                        gc.drawImage(new Image("/monstre.png"), i * taille, j * taille);
                    }
                } else if (laby.getPorte().etreFerme() && laby.getPorte().etrePresent(i, j)) {
                    gc.drawImage(new Image("/mur.png"), i * taille, j * taille);
                } else if(!laby.getPorte().etreFerme() && laby.getPorte().etrePresent(i, j)){
                    gc.drawImage(new Image("/porte.png"), i * taille, j * taille);
                } else {
                    gc.drawImage(new Image("/sol.png"), i * taille, j * taille);
                }
            }

            if (laby.etreFini()) {
                gc.setFill(Color.YELLOW);
                gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gc.setFill(Color.BLACK);
                gc.fillText("Fin du jeu", canvas.getWidth() / 2, canvas.getHeight() / 2);
            }
        }
    }
}