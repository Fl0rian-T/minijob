package minijob;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AufgabeController {

    // ================= AUFGABEN =================
    static class Aufgabe {
        public String text;
        public String status = "offen";
    }

    private ArrayList<Aufgabe> aufgaben = new ArrayList<>();

    // ================= ARBEITSZEITEN =================
    static class Arbeit {
        public String datum;
        public String von;
        public String bis;
        public int stunden;
        public int minuten;
    }

    private ArrayList<Arbeit> arbeiten = new ArrayList<>();

    // ================= AUFGABEN API =================

    @GetMapping("/aufgaben")
    public ArrayList<Aufgabe> getAufgaben() {
        return aufgaben;
    }

    @PostMapping("/aufgabe")
    public String addAufgabe(@RequestBody Aufgabe a) {
        aufgaben.add(a);
        return "OK";
    }

    @PostMapping("/aufgabe/status")
    public String setStatus(@RequestParam int index, @RequestParam String status) {
        if (index >= 0 && index < aufgaben.size()) {
            aufgaben.get(index).status = status;
            return "OK";
        }
        return "FEHLER";
    }

    @DeleteMapping("/aufgabe")
    public String deleteAufgabe(@RequestParam int index) {
        if (index >= 0 && index < aufgaben.size()) {
            aufgaben.remove(index);
            return "OK";
        }
        return "FEHLER";
    }

    // ================= ARBEITSZEITEN API =================

    @GetMapping("/arbeiten")
    public ArrayList<Arbeit> getArbeiten() {
        return arbeiten;
    }

    @PostMapping("/arbeit")
    public String addArbeit(@RequestBody Arbeit a) {

        int[] hm = calcTime(a.von, a.bis);
        a.stunden = hm[0];
        a.minuten = hm[1];

        arbeiten.add(a);

        return "OK";
    }

    @DeleteMapping("/arbeit")
    public String deleteArbeit(@RequestParam int index) {
        if (index >= 0 && index < arbeiten.size()) {
            arbeiten.remove(index);
            return "OK";
        }
        return "FEHLER";
    }

    // ================= ZEIT BERECHNUNG =================

    private int[] calcTime(String von, String bis) {
        try {
            String[] v = von.split(":");
            String[] b = bis.split(":");

            int vMin = Integer.parseInt(v[0]) * 60 + Integer.parseInt(v[1]);
            int bMin = Integer.parseInt(b[0]) * 60 + Integer.parseInt(b[1]);

            int diff = Math.max(0, bMin - vMin);

            return new int[]{diff / 60, diff % 60};

        } catch (Exception e) {
            return new int[]{0, 0};
        }
    }
}