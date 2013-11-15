/**
 * Programa que simula la carrera de camells amb gràfics fent servir la
 * llibreria de l'ACM.
 */
package net.xaviersala.camells;

import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.program.GraphicsProgram;

/**
 * @author Xavier
 *
 */
public class Camells extends GraphicsProgram {

    /**
     * ID pels applets.
     */
    private static final long serialVersionUID = -4972515381147605183L;

    /**
     * Número de camells de la carrera.
     */
    static final int NUMCAMELLS = 6;
    /**
     * Posició de la pantalla on comença la carrera.
     */
    static final int POSICIOINICIAL = 10;
    /**
     * Línia d'arribada.
     */
    static final double POSICIOFINAL = 900;
    /**
     * Separació entre els camells.
     */
    static final int SEPARACIO = 70;
    /**
     * Píxels coma màxim que pot anar un camell.
     */
    static final int VELOCITATMAXIMA = 10;

    /**
     * Temps per començar.
     */
    static final int TIMESTART = 2000;
    /**
     * Temps d'espera entre passades.
     */
    static final int TIMEPAUSE = 80;
    /**
     * Imatges dels camells que es triaran aleatòriament.
     */
    private String[] imatgesCamells = {
            "vermell.jpg",
            "verd.jpg",
            "groc.jpg",
            "blau.jpg",
            "negre.jpg",
            "taronja.jpg",
            "rosa.jpg" };

    /**
     * Programa principal.
     */
    public void run() {
        ArrayList<Camell> camells = new ArrayList<Camell>();
        GImage estrella = null;
        int posicio =  POSICIOINICIAL;

        GLabel text = new GLabel("Preparats ");
        text.setLocation((getWidth() - text.getWidth()) / 2,
                (getHeight() - text.getHeight()) / 2);
        text.setFont("Serif-bold-40");

        estrella = new GImage("star2.jpg");
        estrella.setLocation(POSICIOFINAL, POSICIOINICIAL);
        add(estrella);

        for (int i = 0; i < NUMCAMELLS; i++) {
            GLine linia = new GLine(0, posicio - POSICIOINICIAL,
                    getWidth(), posicio - POSICIOINICIAL);
            linia.setColor(Color.GRAY);
            add(linia);

            int triaColor = (int) (Math.random() * imatgesCamells.length);
            Camell camellTemp = new Camell(imatgesCamells[triaColor]);
            camellTemp.setPosicio(POSICIOINICIAL, posicio);
            camellTemp.setObjectiu(POSICIOFINAL);
            camells.add(camellTemp);
            posicio += SEPARACIO;
            add(camellTemp.getImatge());
        }

        GLine liniaArribada = new GLine(POSICIOFINAL, 0,
                POSICIOFINAL, getHeight());
        liniaArribada.setColor(Color.RED);
        add(liniaArribada);

        add(text);
        pause(TIMESTART);
        remove(text);

        // Començar la carrera
        boolean finalCarrera = false;
        double posicioPrimer = 0f;

        while (!finalCarrera) {
            // Ronda
            pause(TIMEPAUSE);
            for (Camell candidat: camells) {
                double moviment = Math.random() * VELOCITATMAXIMA;
                candidat.mou(moviment, 0);
                if (candidat.heArribat()) {
                    finalCarrera = true;
                }

                if (candidat.getPosicioX() > posicioPrimer) {
                    posicioPrimer = candidat.getPosicioX();
                    estrella.setLocation(POSICIOFINAL,
                            ((candidat.getID() * 2) - 1) * SEPARACIO / 2);
                }
            }
        }


        for (Camell candidat: camells) {
            if (candidat.getPosicioX() == posicioPrimer) {
                // és un guanyador
                text  = new GLabel("Guanyador");
                text.setFont("Serif-bold-25");
                text.setColor(Color.RED);
                text.setLocation(getWidth() / 2,
                        ((candidat.getID() * 2) - 1) * SEPARACIO / 2);
                add(text);
            }
        }
    }

    /**
     * Construcció de la finestra.
     */
    public final void init() {
        setSize((int) POSICIOFINAL + VELOCITATMAXIMA * 2,
                NUMCAMELLS * SEPARACIO);
    }
}
