package net.xaviersala.camells;

import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;

/**
 * Defineix la pista de carreres.
 *
 * @author xavier
 *
 */
public class Pista {
    /**
     * Posició de la pantalla on comença la carrera.
     */
    static final int POSICIOINICIAL = 10;

    /**
     * Separació entre els camells.
     */
    static final int SEPARACIO = 70;
    /**
     * Temps per començar.
     */
    static final int TIMESTART = 2000;
    /**
     * Temps d'espera entre passades.
     */
    static final int TIMEPAUSE = 80;
    /**
     * Lloc en el que s'ha de pintar.
     */
    private CarreraDeCamells pantalla = null;
    /**
     * Camells que participen en la carrera.
     */
    private ArrayList<Camell> camells = null;
    /**
     * Lloc en el que està la línia d'arribada de la pista.
     */
    private double liniaFinal = 0;
    /**
     * Estrella que segueix el que va primer.
     */
    private GImage estrella = null;

    /**
     * Crea una pista de la mida especificada.
     *
     * @param c
     *            pantalla on s'ha de pintar tot
     * @param mida
     *            mida de la pantalla
     */
    public Pista(final CarreraDeCamells c, final double mida) {
        pantalla = c;
        camells = new ArrayList<Camell>();
        liniaFinal = mida;
    }

    /**
     * Afegeix un camell a la pista.
     *
     * @param manel
     *            camell a afegir
     */
    public final void afegirCamell(final Camell manel) {
        if (manel != null) {
            manel.setPosicio(POSICIOINICIAL, (camells.size() * SEPARACIO)
                    + POSICIOINICIAL);
            camells.add(manel);
            pantalla.add(manel.getImatge());
        }
    }

    /**
     * Començar la carrera.
     */
    public final void iniciaCarrera() {

        double camellMesRapid = 0f;

        pantalla.setSize((int) liniaFinal + POSICIOINICIAL * 2, camells.size()
                * SEPARACIO);

        pintaPantalla();
        preparatsLlestos();
        camellMesRapid = aCorrer();
        mostraResultat(camellMesRapid);
    }

    /**
     * Comença la carrera.
     *
     * @return retorna fins a on ha arribat el cavall més ràpid
     */
    private double aCorrer() {
        boolean finalCarrera = false;
        double posicioPrimer = 0L;

        while (!finalCarrera) {
            // Ronda
            pantalla.pause(TIMEPAUSE);
            for (Camell candidat : camells) {
                int velocitatMaxima = candidat.getMaximaVelocitat();
                double moviment = GameHelper.obtenirNumero(velocitatMaxima);
                candidat.mou(moviment, 0);
                if (candidat.getPosicio() >= liniaFinal) {
                    finalCarrera = true;
                }

                if (candidat.getPosicio() > posicioPrimer) {
                    posicioPrimer = candidat.getPosicio();
                    estrella.setLocation(liniaFinal,
                            ((candidat.getID() * 2) - 1) * SEPARACIO / 2);
                }
            }
        }
        return posicioPrimer;
    }

    /**
     * Pinta la pantalla i afegeix l'estrella de seguiment.
     */
    private void pintaPantalla() {

        estrella = new GImage("star2.jpg");
        estrella.setLocation(liniaFinal, POSICIOINICIAL);
        pantalla.add(estrella);

        int posicio = POSICIOINICIAL;
        // Pinta camells i les línies
        for (int i = 0; i < camells.size(); i++) {
            GLine linia = new GLine(0, posicio - POSICIOINICIAL, liniaFinal,
                    posicio - POSICIOINICIAL);
            linia.setColor(Color.GRAY);
            pantalla.add(linia);
            posicio += SEPARACIO;
        }

        // Pinta la línia d'arribada
        GLine liniaArribada = new GLine(liniaFinal, 0, liniaFinal, SEPARACIO
                * camells.size());
        liniaArribada.setColor(Color.RED);
        pantalla.add(liniaArribada);

    }

    /**
     * Posa preparats a la pista i s'espera...
     */
    private void preparatsLlestos() {
        GLabel text = new GLabel("Preparats ");
        text.setLocation((pantalla.getWidth() - text.getWidth()) / 2,
                (pantalla.getHeight() - text.getHeight()) / 2);
        text.setFont("Serif-bold-40");
        pantalla.add(text);
        pantalla.pause(TIMESTART);
        pantalla.remove(text);
    }

    /**
     * Mostra el resultat.
     *
     * @param camellMesRapid
     *            A on ha arribat el camell més ràpid
     */
    private void mostraResultat(final double camellMesRapid) {
        GLabel text = null;

        for (Camell candidat : camells) {
            if (candidat.getPosicio() == camellMesRapid) {
                // és un guanyador
                text = new GLabel("Guanyador");
                text.setFont("Serif-bold-25");
                text.setColor(Color.RED);
                text.setLocation(pantalla.getWidth() / 2,
                        ((candidat.getID() * 2) - 1) * SEPARACIO / 2);
                pantalla.add(text);
            }
        }
    }
}
