package io.av1;

import java.util.ArrayList;

public class AlphaBank {
    private ArrayList<Account> accounts;
    private int aux;

    public AlphaBank() {
        this.accounts = new ArrayList<>();
        this.aux = 0;
    }

    public String CreateAccount() {
        String acc = CreateId();
        this.accounts.add(new Account(acc, 0));
        return acc;
    }
    
    private String CreateId() {
        String id = "acc" + this.aux;
        this.aux++;
        return id;
    }
}