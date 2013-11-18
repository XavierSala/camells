package net.xaviersala.camells;

import acm.graphics.GImage;

public class CamellFondista extends Camell {
    public CamellFondista() {
        super();
        imatge = new GImage("fondista.jpg");
    }

    /**
    * Mou el camell en la direcció especificada. Però com que és un camell fondista
    * sempre obtindrà valors entre 5 i 15
    *
    * @param x
    *            píxels en la direcció x
    * @param y
    *            píxels en la direcció y
    */
   public final void mou(final double x, final double y) {
       double moviment = x;
       if (x<5) {
           moviment = 5;
       }
       
       if (x>15) {
    	   moviment = 15;
       }
       super.mou(moviment, y);
   }


}
