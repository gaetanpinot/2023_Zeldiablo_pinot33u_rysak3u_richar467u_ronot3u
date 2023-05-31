import gameLaby.laby.Labyrinthe;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
public class TestPersonnage {
    @Test
    public void testEstACoterOk()throws IOException{
        Labyrinthe l=new Labyrinthe("fichierTest/laby0Test.txt");
        assertTrue(l.pj.estACote(l.getMonstre()),"le mosntre est à coté du personnage");
    }
    @Test
    public void testEstACoterKO()throws IOException{
        Labyrinthe l=new Labyrinthe("fichierTest/laby2Test.txt");
        assertFalse(l.pj.estACote(l.getMonstre()),"le monstre n'est pas à coté du personnage");
    }
}
