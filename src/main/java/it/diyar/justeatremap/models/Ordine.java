package it.diyar.justeatremap.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Alimento> alimenti;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Ristorante ristorante;

    private String indirizzoConsegna;

    private LocalDateTime dataCreazione;

    private LocalDateTime dataAccettazione; //nullable

    private LocalDateTime dataRicezione; //nullable

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Alimento> getAlimenti() {
        return alimenti;
    }

    public void setAlimenti(List<Alimento> alimenti) {
        this.alimenti = alimenti;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ristorante getRistorante() {
        return ristorante;
    }

    public void setRistorante(Ristorante ristorante) {
        this.ristorante = ristorante;
    }

    public String getIndirizzoConsegna() {
        return indirizzoConsegna;
    }

    public void setIndirizzoConsegna(String indirizzoConsegna) {
        this.indirizzoConsegna = indirizzoConsegna;
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDateTime dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public LocalDateTime getDataAccettazione() {
        return dataAccettazione;
    }

    public void setDataAccettazione(LocalDateTime dataAccettazione) {
        this.dataAccettazione = dataAccettazione;
    }

    public LocalDateTime getDataRicezione() {
        return dataRicezione;
    }

    public void setDataRicezione(LocalDateTime dataRicezione) {
        this.dataRicezione = dataRicezione;
    }
}