package gameLaby.laby;

public class CasePiege implements CaseDeclencheur{
    private boolean ammorce;
    public CasePiege(){
        ammorce=true;
    }

    @Override
    public int event() {
        if(ammorce){
            ammorce=false;
            return 10;
        }
        return 0;
    }

    @Override
    public void persoPart() {
        ammorce=true;
    }
}
