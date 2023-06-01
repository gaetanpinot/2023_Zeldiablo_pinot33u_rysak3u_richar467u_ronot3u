package gameLaby.laby;

public class Troll extends Monstre implements Intelligence{

    String intelligence;
    public Troll(int dx, int dy,int vie) {
        super(dx,dy,vie);
        intelligence=Intelligence.intelligence[(int)(Math.floor(Math.random()*Intelligence.intelligence.length))];
    }
}
