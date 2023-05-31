package gameLaby.laby;

public class CasePiege extends CaseDeclencheur{
    boolean ammorce;

    public CasePiege(int dx,int dy){
        super(dx,dy);
        ammorce=true;
    }

    @Override
    public void event(Personnage p) {
        if(p.etrePresent(this.getX(),this.getY())){
            if(ammorce){
                System.out.println("boom");
                ammorce=false;
                p.ajouterVie(-10);
            }
        }else {
            ammorce=true;
        }
    }


}
