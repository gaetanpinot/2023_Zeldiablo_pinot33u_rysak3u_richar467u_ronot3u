package gameLaby.laby;

public class Porte extends CaseDeclencheur{

    private boolean ferme;



    public Porte(int x, int y){
        super(x,y);
        ferme = false;
    }

    @Override
    void event(Personnage p) {

    }

    public boolean etreFerme() {
        return ferme;
    }

    public void setFerme(boolean ferme) {
        this.ferme = ferme;
    }



}
