/**
 * Classe di utilità per la visualizzazione a terminale dell'omino
 * sulla forca in base al numero di errori commessi.
 */
public class GraficaImpiccato {

    private static final String[] STATI = {
        """
          +---+
          |   |
              |
              |
              |
              |
        =========
        """,
        """
          +---+
          |   |
          O   |
              |
              |
              |
        =========
        """,
        """
          +---+
          |   |
          O   |
          |   |
              |
              |
        =========
        """,
        """
          +---+
          |   |
          O   |
         /|   |
              |
              |
        =========
        """,
        """
          +---+
          |   |
          O   |
         /|\\  |
              |
              |
        =========
        """,
        """
          +---+
          |   |
          O   |
         /|\\  |
         /    |
              |
        =========
        """,
        """
          +---+
          |   |
          O   |
         /|\\  |
         / \\  |
              |
        =========
        """
    };

    /**
     * Stampa a video la rappresentazione ASCII art corrispondente al numero di errori commessi.
     *
     * @param errori numero di errori commessi (da 0 a 6 inclusi)
     * @throws IllegalArgumentException se il numero di errori non è compreso tra 0 e 6
     */
    public static void stampa(int errori) {
        if (errori < 0 || errori >= STATI.length) {
            throw new IllegalArgumentException("Numero errori fuori range");
        }
        System.out.println(STATI[errori]);
    }
}
