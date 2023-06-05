package com.example.mobilificio;

import javax.swing.JOptionPane;
/**
 * Classe che implemente le eccezioni utente
 */
public class Custom_Exception extends Exception{

    private static final long serialVersionUID = 1L;

    /**
     * Costruttore di classe, che visualizza in una finestra il messaggio dato in input
     * @param message Stringa di input
     */
    public Custom_Exception(String message)
    {
        super(message);
        JOptionPane.showMessageDialog(null,message);
    }

}
