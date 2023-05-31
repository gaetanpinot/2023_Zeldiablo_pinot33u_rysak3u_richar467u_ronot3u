package gameLaby.laby;

public class Actor {
    public static void main(String[] args) {
        Porte p=new Porte(0,0);
        Perso perso=new Perso(0,0,10);

        CaseFermeture c=new CaseFermeture(0,0,p);
        c.event(perso);
    }
}
