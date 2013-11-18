package net.xaviersala.camells;

import acm.graphics.GImage;

public class CamellRapid extends Camell {

    public CamellRapid() {
        super();
        imatge = new GImage("rapid.jpg");
    }

      /**
     * Mou el camell en la direcció especificada. Però com que és un camell ràpid
     * en el cas en que la velocitat sigui la màxima es mou el doble de punts
     *
     * @param x
     *            píxels en la direcció x
     * @param y
     *            píxels en la direcció y
     */
    public final void mou(final double x, final double y) {
        double moviment = x;
        if (x == getMaximaVelocitat()) {
            moviment = x * 2;
        }
        super.mou(moviment, y);
    }

}
