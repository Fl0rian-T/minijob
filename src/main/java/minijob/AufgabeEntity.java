package minijob;

import jakarta.persistence.*;

@Entity
public class AufgabeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String status = "offen";

    public Long getId() { return id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}