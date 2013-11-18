package net.xaviersala.camells;

import acm.graphics.GImage;

public class CamellNormal extends Camell {
    /**
     * Imatges possibles dels camells.
     */
    private String[] imatgesCamells = {"vermell.jpg", "verd.jpg", "groc.jpg",
            "blau.jpg", "negre.jpg", "taronja.jpg", "rosa.jpg" };

      public CamellNormal() {
            super();

            int triaColor = (int) (Math.random() * imatgesCamells.length);
            imatge = new GImage(imatgesCamells[triaColor]);
        }
}
