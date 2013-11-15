package net.xaviersala.camells;

import acm.graphics.GImage;

/**
 * Classe que implementa els camells.
 * @author xavier
 *
 */
public class Camell {
    /**
     * Comptador de camells.
     */
    private static int lastID = 1;

    /**
     * Identificador del camell.
     */
    private int id;
    /**
     * Imatge del camell.
     */
    private GImage imatge;
    /**
     * Lloc al que ha d'arribar el camell per estar en la meta.
     */
    private double objectiu;

    /**
     * Constructor del camell.
     * @param imatgeDelCamell Imatge que represetarà el camell.
     */
    public Camell(final String imatgeDelCamell) {
        if (imatgeDelCamell != null) {
            this.imatge = new GImage(imatgeDelCamell);
        } else {
            this.imatge = new GImage("default.jpg");
        }
        objectiu = -1;
        id = lastID;
        lastID++;
    }

    /**
     * @return id del camell
     */
    public final int getID() {
        return id;
    }
    /**
     * @return Retorna la imatge del camell.
     */
    public final GImage getImatge() {
        return imatge;
    }

    /**
     * @return posicioX
     */
    public final double getPosicioX() {
        return imatge.getX();
    }
    /**
     * Defineix la posició del camell.
     * @param x posició X
     * @param y posició Y
     */
    public final void setPosicio(final double x, final double y) {
        imatge.setLocation(x, y);
    }

    /**
     * Mou el camell en la direcció especificada.
     * @param x píxels en la direcció x
     * @param y píxels en la direcció y
     */
    public final void mou(final double x, final double y) {
        imatge.move(x,  y);
    }

    /**
     * Defineix on està la línea de meta.
     * @param x posició de la meta
     */
    public final void setObjectiu(final double x) {
        objectiu = x - imatge.getWidth();
    }

    /**
     * @return Retorna si hem arribat a la meta o no
     */
    public final boolean heArribat() {
        return (imatge.getX() > objectiu);
    }

    /**
     * Si ha arribat retorna els punts que li han sobrat al camell.
     * @return Retorna quants punts li han sobrat al camell.
     */
    public final double getPuntsDeSobres() {
        return (imatge.getX() - objectiu);
    }
}
