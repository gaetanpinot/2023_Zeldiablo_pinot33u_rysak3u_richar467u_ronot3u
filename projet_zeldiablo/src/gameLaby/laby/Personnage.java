package gameLaby.laby;

public class Personnage {
    /**
     * position du personnage
     */
    int x, y,vie;

    final int maxVie;
    public String orientation;


    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Personnage(int dx, int dy,int vie) {
        this.x = dx;
        this.y = dy;
        this.vie=vie;
        this.orientation=Labyrinthe.BAS;
        this.maxVie=vie;
    }

    /**
     * permet de savoir si le personnage est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.x == dx && this.y == dy);
    }

    // ############################################
    // GETTER
    // ############################################

    /**
     * @return position x du personnage
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y du personnage
     */
    public int getY() {
        //getter
        return this.y;
    }
    public void ajouterVie(int i){
        this.vie+=i;
    }
    public int getVie(){
        return vie;
    }

    public int getMaxVie(){return maxVie;}


    public boolean estACoter(Personnage p){
        return (p.etrePresent(this.x+1,this.y)||p.etrePresent(this.x-1,this.y)||p.etrePresent(this.x,this.y+1)||p.etrePresent(this.x,this.y-1));
    }
}
