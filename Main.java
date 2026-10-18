import java.util.Scanner;

/**
 * Punto di ingresso dell'applicazione. Gestisce l'interazione con l'utente
 * da riga di comando, il ciclo di gioco e la validazione dell'input.
 */
public class Main {

    /**
     * Avvia l'applicazione dell'Impiccato e gestisce il ciclo principale delle partite.
     *
     * @param args argomenti passati da riga di comando (non utilizzati)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dizionario dizionario = new Dizionario();

        System.out.println("=================================");
        System.out.println("   BENVENUTO ALL'IMPICCATO!     ");
        System.out.println("=================================");

        boolean giocaAncora = true;

        while (giocaAncora) {
            String parola = dizionario.getParolaCasuale();
            Partita partita = new Partita(parola);

            while (!partita.isFinita()) {
                System.out.println();
                GraficaImpiccato.stampa(partita.getErroriCommessi());
                System.out.println("Parola: " + partita.getProgressoFormattato());
                System.out.println("Lettere tentate: " + partita.getLettereProvate());
                System.out.println("Errori rimasti: " + (Partita.MAX_ERRORI - partita.getErroriCommessi()));

                System.out.print("\nInserisci una lettera: ");
                String input = scanner.nextLine().trim();

                if (input.length() != 1) {
                    System.out.println("-> Errore: inserisci un solo carattere alla volta!");
                    continue;
                }

                char lettera = input.charAt(0);

                if (!Character.isLetter(lettera)) {
                    System.out.println("-> Errore: inserisci una lettera valida dell'alfabeto!");
                    continue;
                }

                if (partita.isGiaProvata(lettera)) {
                    System.out.println("-> Lettera gia' provata! Scegline un'altra.");
                    continue;
                }

                boolean indovinata = partita.tentaLettera(lettera);
                if (indovinata) {
                    System.out.println("-> Ottimo! La lettera e' corretta.");
                } else {
                    System.out.println("-> Peccato! La lettera non e' presente.");
                }
            }

            System.out.println();
            GraficaImpiccato.stampa(partita.getErroriCommessi());

            if (partita.isVinta()) {
                System.out.println("COMPLIMENTI, HAI VINTO! :D");
                System.out.println("Hai indovinato la parola: " + partita.getParolaSegreta());
            } else {
                System.out.println("HAI PERSO! L'omino e' stato impiccato. :(");
                System.out.println("La parola corretta era: " + partita.getParolaSegreta());
            }

            System.out.print("\nVuoi giocare un'altra partita? (S/N): ");
            String risposta = scanner.nextLine().trim();
            if (!risposta.equalsIgnoreCase("S") && !risposta.equalsIgnoreCase("SI")) {
                giocaAncora = false;
            }
        }

        scanner.close();
        System.out.println("\nGrazie per aver giocato! Arrivederci.");
    }
}

