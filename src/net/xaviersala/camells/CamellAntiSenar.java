package net.xaviersala.camells;

import acm.graphics.GImage;

public class CamellAntiSenar extends Camell {

    public CamellAntiSenar() {
        super();
        imatge = new GImage("antisenar.jpg");
    }

    /**
    * Mou el camell en la direcció especificada. Però com que és un camell
    * antisenar si el valor és senar avança 2 píxels
    *
    * @param x
    *            píxels en la direcció x
    * @param y
    *            píxels en la direcció y
    */
   public final void mou(final double x, final double y) {
       double moviment = x;
       if (x % 2 != 0 ) {
           moviment = 2;
       }
       super.mou(moviment, y);
   }


}
