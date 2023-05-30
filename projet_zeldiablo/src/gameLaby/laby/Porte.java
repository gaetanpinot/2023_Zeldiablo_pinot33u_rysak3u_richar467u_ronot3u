package gameLaby.laby;

public class Porte implements CaseDeclencheur{

    private boolean ferme;
    int x, y;


    public Porte(int x, int y){
        this.x = x;
        this.y = y;
        ferme = false;
    }

    public boolean etreFerme() {
        return ferme;
    }

    public void setFerme(boolean ferme) {
        this.ferme = ferme;
    }

    @Override
    public void event() {
        
    }
}
