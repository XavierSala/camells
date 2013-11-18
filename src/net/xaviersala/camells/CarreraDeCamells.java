/**
 * Programa que simula la carrera de camells amb gràfics fent servir la
 * llibreria de l'ACM.
 */
package net.xaviersala.camells;

import acm.program.GraphicsProgram;

/**
 * @author Xavier Sala
 *
 */
public class CarreraDeCamells extends GraphicsProgram {

    /**
     * ID pels applets.
     */
    private static final long serialVersionUID = -4972515381147605183L;

    /**
     * Tipus de camells que tenim
     */
    static final int TIPUSCAMELLS = 5;
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
            pistaDeCarreres.afegirCamell(creaCamell());
        }

        pistaDeCarreres.iniciaCarrera();

    }

    /**
     * Crea un camell dels tipus disponibles de forma aleatòria.
     * @return El camell creat
     */
    private Camell creaCamell() {
        Camell retorn = null;

        TipusCamells quin = TipusCamells.randomCamell();
        switch (quin) {
            case CAMELL_NORMAL:
                retorn = new CamellNormal();
                break;
            case CAMELL_FLIPAT:
                retorn = new CamellFlipat();
                break;
            case CAMELL_FONDISTA:
                retorn = new CamellFondista();
                break;
            case CAMELL_RAPID:
                retorn = new CamellRapid();
                break;
            case CAMELL_ANTISENAR:
                retorn = new CamellAntiSenar();
                break;
            default:
                retorn = new CamellNormal();
        }
        return retorn;
    }

}
