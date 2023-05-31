package gameLaby.laby;

public class ClePorte extends CaseDeclencheur {

    private Porte porte;

    public ClePorte(Porte porte, int x, int y){
        super(x, y);
        this.porte = porte;
    }

    @Override
    void event(Personnage p) {
        if(p.getX() == this.x && p.getY() == this.y){
            porte.setFerme(false);
        } else {
            porte.setFerme(true);
        }
    }
}
