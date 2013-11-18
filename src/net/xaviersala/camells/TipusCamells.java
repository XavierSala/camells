/**
 *
 */
package net.xaviersala.camells;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author xavier
 *
 */
public enum TipusCamells {

          /**
           *  Camell normal que avança tal com li diuen.
           */
          CAMELL_NORMAL,
          /**
           * Camell flipat que va endavant i enrere.
           */
          CAMELL_FLIPAT,
          /**
           * Camell que va al doble si arriba al màxim.
           */
          CAMELL_RAPID,
          /**
           * Camell que va sempre a velocitat mitjana.
           */
          CAMELL_FONDISTA,
          /**
           * Camell que només avança normalment amb els valors senars.
           */
          CAMELL_ANTISENAR;

          /**
           * Llista dels tipus de camells.
           */
          private static final List<TipusCamells> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
          /**
           * Mida de la llista (per poder fer un random).
           */
          private static final int SIZE = VALUES.size();
          /**
           * Crea l'objecte Random.
           */
          private static final Random RANDOM = new Random();

          /**
           * Obtenir un valor aleatòri i retornar el tipus d'objecte.
           * @return tipus
           */
          public static TipusCamells randomCamell()  {
            return VALUES.get(RANDOM.nextInt(SIZE));
          }
}
