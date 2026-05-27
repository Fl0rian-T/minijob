package minijob;

import jakarta.persistence.*;

@Entity
public class ArbeitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String datum;
    private String von;
    private String bis;

    private int stunden;
    private int minuten;

    public Long getId() { return id; }

    public String getDatum() { return datum; }
    public void setDatum(String datum) { this.datum = datum; }

    public String getVon() { return von; }
    public void setVon(String von) { this.von = von; }

    public String getBis() { return bis; }
    public void setBis(String bis) { this.bis = bis; }

    public int getStunden() { return stunden; }
    public void setStunden(int stunden) { this.stunden = stunden; }

    public int getMinuten() { return minuten; }
    public void setMinuten(int minuten) { this.minuten = minuten; }
}