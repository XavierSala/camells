package net.xaviersala.camells;

import acm.graphics.GImage;

/**
 * Classe que defineix el comportament dels camells fondistes.
 *
 * Els camells fondistes no avancen mai a màxima velocitat però
 * tampoc a la mínima.
 *
 * @author xavier
 *
 */
public class CamellFondista extends Camell {

    /**
     * Velocitat mínima a la que pot anar.
     */
    static final int MINIMAVELOCITAT = 5;
    /**
     * Velocitat màxima a la que pot anar.
     */
    static final int MAXIMAVELOCITAT = 15;
    /**
     * Creació d'un camell fondista.
     */
    public CamellFondista() {
        super();
        imatge = new GImage("fondista.jpg");
    }

    /**
    * Mou el camell en la direcció especificada. Però com que és un camell
    * fondista sempre obtindrà valors entre 5 i 15.
    *
    * @param x
    *            píxels en la direcció x
    * @param y
    *            píxels en la direcció y
    */
   public final void mou(final double x, final double y) {
       double moviment = x;
       if (x < MINIMAVELOCITAT) {
           moviment = MINIMAVELOCITAT;
       }

       if (x > MAXIMAVELOCITAT) {
           moviment = MAXIMAVELOCITAT;
       }
       super.mou(moviment, y);
   }


}
