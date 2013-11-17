/**
 * Programa que simula la carrera de camells amb gràfics fent servir la
 * llibreria de l'ACM.
 */
package net.xaviersala.camells;

import acm.program.GraphicsProgram;

/**
 * @author Xavier
 *
 */
public class CarreraDeCamells extends GraphicsProgram {

    /**
     * ID pels applets.
     */
    private static final long serialVersionUID = -4972515381147605183L;

    /**
     * Número de camells de la carrera.
     */
    static final int NUMCAMELLS = 6;
    /**
     * Línia d'arribada.
     */
    static final double POSICIOFINAL = 900;

    /**
     * Programa principal.
     */
    public final void run() {

        Pista pistaDeCarreres = new Pista(this, POSICIOFINAL);
        for (int i = 0; i < NUMCAMELLS; i++) {
            pistaDeCarreres.afegirCamell(new Camell());
        }

        pistaDeCarreres.iniciaCarrera();

    }

}
