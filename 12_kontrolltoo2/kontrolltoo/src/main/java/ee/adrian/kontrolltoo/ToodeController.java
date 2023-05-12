package ee.adrian.kontrolltoo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ToodeController {
    List<Toode> tooted = new ArrayList<>(Arrays.asList(
            new Toode(0, "Koola", 3.0, 0.0, 10),
            new Toode(1, "Fanta", 12.0, 0.15, 30),
            new Toode(2, "Sprite", 1.5, 0.3, 20),
            new Toode(3, "Koola", 7.3, 0.5, 14),
            new Toode(4, "Koola", 0.3, 0.0, 16),
            new Toode(5, "Haamer", 40.0, 0.9, 10),
            new Toode(6, "Nael", 0.2, 0.15, 30),
            new Toode(7, "Kruvi", 0.1, 0.1, 20),
            new Toode(8, "Laelamp", 80.0, 0.2, 14),
            new Toode(9, "Põrandaplaat", 1.7, 0.0, 16)
    ));

    @GetMapping("lisa-toode")
    public List<Toode> lisaToodeURLParameetritega(
            @RequestParam int id,
            @RequestParam String nimi,
            @RequestParam double hind,
            @RequestParam double allahindlus,
            @RequestParam int laoseis
    ) {
        tooted.add(new Toode(id, nimi, hind, allahindlus, laoseis));
        return tooted;
    } // localhost:8080/lisa-toode?id=10&nimi=Samsung&hind=600&allahindlus=0.1&laoseis=300

    // localhost:8080/leia-rasva-alusel2?alg=10&l6pp=100
    @GetMapping("leia-allahindluse-alusel")
    public List<Toode> leiaRasvaAlusel(
            @RequestParam int alg,
            @RequestParam int l6pp
    ) {
        return tooted;
    }
    @GetMapping("leia-allahindlus")
    public List<Toode> leiaAllahindlus() {
        List<Toode> filteredTooted = new ArrayList<>();
        for (Toode toode : tooted) {
            if (toode.getAllahindlus() > 0.0) {
                filteredTooted.add(toode);
            }
        }
        return filteredTooted;
    }
    @GetMapping("hind-madalam-kui")
    public List<Toode> leiaHindMadalamKui(
            @RequestParam double hind
    ) {
        List<Toode> filteredTooted = new ArrayList<>();

        for (Toode toode : tooted) {
            if (toode.getHind() < hind) {
                if (toode.getAllahindlus() < 1) {
                    filteredTooted.add(toode);
                }
            }
        }

        return filteredTooted;
    }

}
