package org.centrale.domain;

import org.centrale.domain.PierreFeuilleCiseaux.Ciseaux;
import org.centrale.domain.PierreFeuilleCiseaux.Feuille;
import org.centrale.domain.PierreFeuilleCiseaux.Hand;
import org.centrale.domain.PierreFeuilleCiseaux.Pierre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPierreFeuilleCiseaux {

    @Test 
    public void jeuEgalite(){
        Hand p = new Pierre();
        Hand f = new Feuille();
        Hand c = new Ciseaux();
        Assertions.assertEquals(p.playWith(new Pierre()), 0);
        Assertions.assertEquals(f.playWith(new Feuille()), 0);
        Assertions.assertEquals(c.playWith(new Ciseaux()), 0);
    }

}
