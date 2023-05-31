package gameLaby.laby;

public abstract class CaseDeclencheur {


     int x,y;





     public CaseDeclencheur(int dx,int dy){
          x=dx;
          y=dy;
     }
     abstract void event(Personnage p);
     public int getY() {
          return y;
     }
     public int getX() {
          return x;
     }

}
