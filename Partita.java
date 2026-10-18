import java.util.ArrayList;

/**
 * Rappresenta lo stato e le regole di una partita all'Impiccato.
 * Gestisce la logica di aggiornamento delle lettere indovinate e il conteggio errori.
 */
public class Partita {
    public static final int MAX_ERRORI = 6;
    
    private final String parolaSegreta;
    private final char[] progresso;
    private final ArrayList<Character> lettereProvate;
    private int erroriCommessi;

    /**
     * Crea una nuova partita inizializzando lo stato del gioco.
     * 
     * @param parolaSegreta la parola da indovinare
     */
    public Partita(String parolaSegreta) {
        this.parolaSegreta = parolaSegreta.toUpperCase();
        this.erroriCommessi = 0;
        this.lettereProvate = new ArrayList<>();
        this.progresso = new char[this.parolaSegreta.length()];
        for (int i = 0; i < this.progresso.length; i++) {
            this.progresso[i] = '_';
        }
    }

    /**
     * Verifica se una lettera è già stata tentata.
     * 
     * @param lettera il carattere da controllare
     * @return true se la lettera è presente nell'elenco dei tentativi
     */
    public boolean isGiaProvata(char lettera) {
        return lettereProvate.contains(Character.toUpperCase(lettera));
    }

    /**
     * Elabora il tentativo di una lettera aggiornando lo stato della partita.
     * 
     * @param lettera il carattere inserito dal giocatore
     * @return true se la lettera è presente nella parola segreta
     */
    public boolean tentaLettera(char lettera) {
        lettera = Character.toUpperCase(lettera);
        if (isGiaProvata(lettera)) {
            return false;
        }

        lettereProvate.add(lettera);
        boolean trovata = false;
        for (int i = 0; i < parolaSegreta.length(); i++) {
            if (parolaSegreta.charAt(i) == lettera) {
                progresso[i] = lettera;
                trovata = true;
            }
        }

        if (!trovata) {
            this.erroriCommessi++;
        }
        return trovata;
    }

    /**
     * @return true se tutte le lettere sono state indovinate
     */
    public boolean isVinta() {
        for (char c : progresso) {
            if (c == '_') return false;
        }
        return true;
    }

    /**
     * @return true se è stato raggiunto il numero massimo di errori
     */
    public boolean isPersa() {
        return erroriCommessi >= MAX_ERRORI;
    }

    /**
     * @return true se la partita è terminata (vinta o persa)
     */
    public boolean isFinita() {
        return isPersa() || isVinta();
    }

    /**
     * Restituisce il progresso attuale formattato per la stampa (es. "_ A _ _").
     * 
     * @return stringa con le lettere scoperte separate da spazi
     */
    public String getProgressoFormattato() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < progresso.length; i++) {
            sb.append(progresso[i]);
            if (i < progresso.length - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public int getErroriCommessi() {
        return this.erroriCommessi;
    }

    public ArrayList<Character> getLettereProvate() {
        return this.lettereProvate;
    }

    public String getParolaSegreta() {
        return this.parolaSegreta;
    }
}

