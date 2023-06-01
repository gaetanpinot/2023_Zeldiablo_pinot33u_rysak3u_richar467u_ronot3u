package gameLaby.laby;

public class Monstre extends Personnage implements Intelligence{

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    String intelligence;
    public Monstre(int dx, int dy,int vie) {
        super(dx,dy,vie);
        intelligence=Intelligence.intelligence[(int)(Math.floor(Math.random()*Intelligence.intelligence.length))];
    }
}
