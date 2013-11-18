package net.xaviersala.camells;

import acm.graphics.GImage;

/**
 * Classe per la creació de camells estàndard.Es mouen la quantitat
 * de punts que se'ls especifiquin.
 *
 * @author xavier
 *
 */
public class CamellNormal extends Camell {
    /**
     * Imatges possibles dels camells.
     */
    private String[] imatgesCamells = {"vermell.jpg", "verd.jpg", "groc.jpg",
            "blau.jpg", "negre.jpg", "taronja.jpg", "rosa.jpg" };

    /**
     * Creació d'un camell.
     */
      public CamellNormal() {
            super();

            int triaColor = (int) (Math.random() * imatgesCamells.length);
            imatge = new GImage(imatgesCamells[triaColor]);
        }
}
