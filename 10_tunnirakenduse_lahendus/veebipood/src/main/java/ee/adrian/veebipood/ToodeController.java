package ee.adrian.veebipood;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ToodeController {
    List<Toode> tooted = new ArrayList<>(Arrays.asList(
            new Toode(1,"Koola", 1.5),
            new Toode(2,"Fanta", 1.0),
            new Toode(3,"Sprite", 1.7),
            new Toode(4,"Vichy", 2.0),
            new Toode(5,"Vitamin well", 2.5)
    ));
    @GetMapping("tooted")
    public List<Toode> saaTooted() {
        return tooted;
    }

    @DeleteMapping("kustuta-toode/{index}")
    public String kustutaToode(@PathVariable int index) {
        tooted.remove(index);
        return "Toode kustutatud!";
    }

    @PostMapping("lisa-toode")
    public List<Toode> lisaToodeURLParameetritega(
            @RequestParam int id,
            @RequestParam String nimi,
            @RequestParam double hind) {
        tooted.add(new Toode(id, nimi, hind));
        return tooted;
    } // localhost:8080/lisa-toode?id=8&nimi=Mullivesi&hind=2.3&aktiivne=true

}
