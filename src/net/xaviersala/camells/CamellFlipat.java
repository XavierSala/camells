package net.xaviersala.camells;

import acm.graphics.GImage;

/**
 * Classe que permet definir un camell flipat. Els camells
 * flipats es caracteritzen perquè avancen un cop endavant
 * i un altre enrere.
 *
 * @author xavier
 *
 */
public class CamellFlipat extends Camell {

    /**
     * Determina cap a on hem de moure.
     */
    private int movimentAFer;

    /**
     * Creació d'un camell flipat.
     */
    public CamellFlipat() {
        super();
        imatge = new GImage("flipat.jpg");
        // El primer cop endavant
        movimentAFer  = 1;
    }

    /**
    * Mou el camell en la direcció especificada. Però com que és un camell
    * flipat avaça un cop endavant i un cop enrere
    *
    * @param x
    *            píxels en la direcció x
    * @param y
    *            píxels en la direcció y
    */
   public final void mou(final double x, final double y) {
       double moviment = x *  movimentAFer;
       // El proper cop al revés
       movimentAFer = movimentAFer * -1;
       super.mou(moviment, y);
   }

}
