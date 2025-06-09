package it.diyar.justeatremap.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ristorante {
    @Id
    private String partitaIva;
    private String nomeAttivita;
    @Embedded
    private Indirizzo indirizzo;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alimento> menu;

    @OneToMany(mappedBy = "ristorante")
    private List<Ordine> ordini;

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public String getNomeAttivita() {
        return nomeAttivita;
    }

    public void setNomeAttivita(String nomeAttivita) {
        this.nomeAttivita = nomeAttivita;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Alimento> getMenu() {
        return menu;
    }

    public void setMenu(List<Alimento> menu) {
        this.menu = menu;
    }

    public List<Ordine> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<Ordine> ordini) {
        this.ordini = ordini;
    }
}
