# Gioco dell'Impiccato (Hangman) in Java

Un classico gioco dell'Impiccato da riga di comando (CLI) sviluppato in Java puro, progettato seguendo i principi della programmazione orientata agli oggetti (OOP).

## ⌨️ Esempio di Partita
```text
  +---+
  |   |
  O   |
 /|   |
      |
      |
=========
Parola: J _ V _
Lettere tentate: [O, P, E, J, V]
Errori rimasti: 3

Inserisci una lettera: 
```


---

## 📌 Descrizione del Progetto
Il programma seleziona una parola segreta in modo casuale da un dizionario interno. Il giocatore deve indovinare la parola lettera per lettera prima di esaurire i tentativi a disposizione (massimo 6 errori). Ad ogni errore, viene disegnato progressivamente l'omino sulla forca tramite ASCII art.

---

## 🏛️ Architettura del Software
Il progetto è suddiviso in 4 classi secondo il **Principio di Singola Responsabilità (SRP)**:

1. **`Dizionario.java`**: Gestisce il pool di parole disponibili ed estrae casualmente la parola per la partita.
2. **`GraficaImpiccato.java`**: Utility class che gestisce gli stati grafici della forca in ASCII art tramite Java Text Blocks.
3. **`Partita.java`**: Incapsula lo stato e le regole della partita (parola segreta, progresso con trattini, tentativi effettuati, conteggio errori, verifica vittoria/sconfitta).
4. **`Main.java`**: Gestisce l'interfaccia utente da terminale, la validazione dell'input con `Scanner` e il ciclo principale delle partite.

---

## 🎮 Regole del Gioco
* Puoi inserire **una sola lettera alla volta**.
* Non c'è distinzione tra lettere maiuscole e minuscole (case-insensitive).
* L'inserimento di numeri, simboli o l'invio a vuoto viene intercettato e **non** consuma tentativi.
* Riprovare una lettera già tentata viene segnalato e **non** penalizza il giocatore.
* Hai a disposizione un massimo di **6 errori**:
  1. Testa
  2. Busto
  3. Braccio sinistro
  4. Braccio destro
  5. Gamba sinistra
  6. Gamba destra (Impiccato / Sconfitta)

---

## 🚀 Requisiti
* **Java Development Kit (JDK)**: Versione 15 o superiore (testato con JDK 25).

---

## 💻 Come Compilare ed Eseguire

### 1. Compilazione
Apri il terminale nella cartella del progetto ed esegui:
```bash
javac *.java
```

### 2. Esecuzione
Avvia il gioco con:
```bash
java Main
```

---

## 📂 Struttura della Repository
```text
.
├── .gitignore            # Ignora bytecode compilato (.class) e file di configurazione
├── Dizionario.java       # Gestione del vocabolario di parole
├── GraficaImpiccato.java # ASCII art per i 7 stati della forca
├── Partita.java          # Logica del gioco e stato della partita
├── Main.java             # Entry point del programma e gestione I/O
└── README.md             # Documentazione del progetto
```
