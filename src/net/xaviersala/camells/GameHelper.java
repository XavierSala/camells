package net.xaviersala.camells;

/**
 * Opcions d'ajuda pel joc.
 *
 * @author xavier
 *
 */
public final class GameHelper {

    /**
     * Constructor que impedeix que la classe es crei.
     */
    private GameHelper() {

    }

    /**
     * Funció que retorna un valor double aleatòri entre 0 i el valor.
     *
     * @param maxim
     *            valor màxim.
     * @return el número
     */
    public static double obtenirNumero(final int maxim) {
        return (int) (Math.random() * maxim);
    }

}
