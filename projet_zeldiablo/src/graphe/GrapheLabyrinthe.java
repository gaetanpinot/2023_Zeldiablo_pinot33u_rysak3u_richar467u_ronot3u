package graphe;



import gameLaby.laby.Labyrinthe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * classe Labyrinthe Graphe
 */
public class GrapheLabyrinthe implements Graphe{
    private Labyrinthe laby;

    /**
     * Créer un nouveau graphe Labyrinthe
     *
     * @param nom nom du fichier
     * @throws IOException exception lié au In/OUT du fichier
     */
    public GrapheLabyrinthe(String nom) throws IOException {
        this.laby=new Labyrinthe(nom);
    }
    public GrapheLabyrinthe(Labyrinthe l){
        this.laby=l;
    }

    @Override
    public List<String> listeNoeuds() {
        ArrayList<String> a=new ArrayList<>();
        for (int i=0;i<this.laby.getLength();i++){
            for(int j=0;j<this.laby.getLengthY();j++){
                if(!this.laby.getMur(i,j)){
                    a.add("("+i+","+j+")");
                }
            }
        }
        return a;
    }

    @Override
    public List<Arc> suivants(String n)  {
        ArrayList<Arc>a=new ArrayList<>();
        n=n.replace("(","");
        n=n.replace(")","");
        String [] s=n.split(",");
        int i=Integer.parseInt(s[0]);
        int j=Integer.parseInt(s[1]);
        int[] dir=Labyrinthe.getSuivant(i,j,Labyrinthe.GAUCHE);
        try {


            if (!this.laby.getMur(dir[0], dir[1])) {
                a.add(new Arc("(" + dir[0] + "," + dir[1] + ")", 1.0));
            }
            dir = Labyrinthe.getSuivant(i, j, Labyrinthe.DROITE);
            if (!this.laby.getMur(dir[0], dir[1])) {
                a.add(new Arc("(" + dir[0] + "," + dir[1] + ")", 1.0));
            }
            dir = Labyrinthe.getSuivant(i, j, Labyrinthe.HAUT);
            if (!this.laby.getMur(dir[0], dir[1])) {
                a.add(new Arc("(" + dir[0] + "," + dir[1] + ")", 1.0));
            }
            dir = Labyrinthe.getSuivant(i, j, Labyrinthe.BAS);
            if (!this.laby.getMur(dir[0], dir[1])) {
                a.add(new Arc("(" + dir[0] + "," + dir[1] + ")", 1.0));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return a;

    }

   static public int[] extraireCoordonnees(String n){
        n=n.replace("(","");
        n=n.replace(")","");
        String [] s=n.split(",");
        return new int[]{Integer.parseInt(s[0]),Integer.parseInt(s[1])};
    }
    public Labyrinthe getLaby(){
        return this.laby;
    }
}
