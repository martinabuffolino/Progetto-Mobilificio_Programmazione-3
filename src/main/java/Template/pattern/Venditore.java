package Template.pattern;

import javafx.scene.control.TextField;

public class Venditore extends Mansione{

    public Venditore(TextField email, TextField nome, TextField cognome, TextField cellulare, TextField mansione) {
        this.email = String.valueOf(email);
        this.nome = String.valueOf(nome);
        this.cognome = String.valueOf(cognome);
        this.cellulare = String.valueOf(cellulare);
        this.mansione = String.valueOf(mansione);
    }

    @Override
    void sendData() {
        System.out.println("Dati inviati");
    }
}