package gameLaby.laby;

public class Troll extends Monstre {


    public Troll(int dx, int dy, int vie) {
        super(dx,dy,vie);
    }
    public Troll(int dx, int dy, int vie,String i) {
        super(dx,dy,vie,i);
    }

    public void regenerer(){
        if(!this.etreMort() && this.getVie()<this.getMaxVie()){
            //on lui rajoute 1pv si sa vie n'a pas bougé : il n'a pas été attaqué dans ce tour
            this.ajouterVie(1);

        }
    }
}
