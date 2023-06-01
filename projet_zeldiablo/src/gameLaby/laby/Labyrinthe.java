package gameLaby.laby;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';


    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";
    public static final char MONSTRE='M';
    /**
     * attribut du personnage
     */
    public Perso pj;
    public Monstre monstre;

    /**
     * les murs du labyrinthe
     */
    public boolean[][] murs;
    public ArrayList<CaseDeclencheur> caseD;

    Porte p;

    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */



    static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        int[] res = {x, y};
        return res;
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];
        this.caseD=new ArrayList<>();
        this.pj = null;

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;

                    case MONSTRE:
                        this.murs[colonne][numeroLigne] = false;
                        this.monstre=new Monstre(colonne,numeroLigne,100);
                        break;
                    case PJ:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute PJ
                        this.pj = new Perso(colonne, numeroLigne,100);
                        break;

                    default:
                        throw new Error("caractere inconnu " + c);
                }

            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
        this.caseD=new ArrayList<>();

        //ajout de casse pieger aléatoire
        int [] coord=this.genererCoorValid();

        this.ajouterCaseDeclencheur(new CasePiege(coord[0],coord[1]));

        coord=this.genererCoorValid();

        this.p=new Porte(coord[0],coord[1]);

        coord=this.genererCoorValid();

        this.ajouterCaseDeclencheur(new CaseOuverture(coord[0],coord[1],this.p));

        coord=this.genererCoorValid();
        this.ajouterCaseDeclencheur(new CaseFermeture(coord[0],coord[1],this.p));
    }

    public void ajouterCaseDeclencheur(CaseDeclencheur c){
        this.caseD.add(c);
    }

    public int[] genererCoorValid(){
        int x =(int)Math.floor(Math.random()*this.getLength());
        int y =(int)Math.floor(Math.random()*this.getLengthY());
        while (getMur(x,y)||this.pj.etrePresent(x,y)||this.monstre.etrePresent(x,y)){
            x =(int)Math.floor(Math.random()*this.getLength());
            y =(int)Math.floor(Math.random()*this.getLengthY());
        }
        return new int[]{x,y};
    }


    public Labyrinthe(){
        this.murs=new boolean[10][10];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                this.murs[i][j]=false;
            }
        }

        for (int i=0;i<10;i++){
            this.murs[i][0]=true;
            this.murs[i][9]=true;
            this.murs[0][i]=true;
            this.murs[9][i]=true;
        }

        this.pj=new Perso(5,5,100);
        this.monstre=new Monstre(1,1,100);
        this.p=new Porte(1,1);
        this.caseD=new ArrayList<>();
    }



    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */

    public void deplacerPerso(String action, Personnage perso) {
        // case courante
        int[] courante = {perso.x, perso.y};

        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);

        // si c'est pas un mur, on effectue le deplacement
        if (!this.murs[suivante[0]][suivante[1]]&&!this.monstre.etrePresent(suivante[0],suivante[1])&&!this.pj.etrePresent(suivante[0],suivante[1])) {
            // on met a jour personnage
            if(!this.p.etrePresent(suivante[0],suivante[1])||((this.p.etrePresent(suivante[0],suivante[1])&&!this.p.etreFerme()))) {
                perso.x = suivante[0];
                perso.y = suivante[1];

            }

        }
        for(CaseDeclencheur c:caseD){
            c.event(this.pj);
            if(!(c instanceof CasePiege)) {
                c.event(this.monstre);
            }
        }

    }


    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * return mur en (i,j)
     * @param x
     * @param y
     * @return
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }
    public Monstre getMonstre(){
        return  this.monstre;
    }
    public Porte getPorte(){
        return p;
    }

    public void persoAttaquerMonstre(){
        if(this.pj.etreEnFace(monstre)){
            this.pj.attaquer(monstre);
        }
    }

}
