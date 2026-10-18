import java.util.Random;

/**
 * Gestisce il vocabolario di parole disponibili per il gioco
 * e la selezione casuale della parola segreta.
 */
public class Dizionario {

    // Costante statica per condividere l'array immutabile tra tutte le eventuali istanze
    private static final String[] PAROLE = {
        "PAROLA", "INGEGNERIA", "FAZZOLETTO", "CONTROLLER", "TELEFONO",
        "ALGORITMO", "COMPILATORE", "JAVA", "PROCESSORE"
    };

    private final Random random;

    /**
     * Inizializza il generatore di numeri casuali.
     */
    public Dizionario() {
        this.random = new Random();
    }

    /**
     * Estrae casualmente una parola dal vocabolario.
     *
     * @return la parola segreta in lettere maiuscole
     */
    public String getParolaCasuale() {
        int indice = random.nextInt(PAROLE.length);
        return PAROLE[indice];
    }
}

