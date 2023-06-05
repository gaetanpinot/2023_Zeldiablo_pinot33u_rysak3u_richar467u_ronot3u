package gameLaby.laby;

public class Monstre extends Personnage implements Intelligence{

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    private String intelligence;
    public Monstre(int dx, int dy,int vie) {
        super(dx,dy,vie);
        intelligence=Intelligence.intelligence[(int)(Math.floor(Math.random()*Intelligence.intelligence.length))];
    }
    public Monstre(int dx, int dy,int vie,String intelligence) {
        super(dx,dy,vie);
        this.intelligence=intelligence;
    }


    public String getIntelligence(){
        return intelligence;
    }
    public void setIntelligence(String action){
        this.intelligence=action;
    }
}
