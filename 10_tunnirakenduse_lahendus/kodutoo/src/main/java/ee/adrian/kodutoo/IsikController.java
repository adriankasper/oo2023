package ee.adrian.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class IsikController {
    List<Isik> isikud = new ArrayList<>(Arrays.asList(
            new Isik(1,"Andrus" ,"Ansip", new Date()),
            new Isik(2,"Mihkel" ,"Raud", new Date()),
            new Isik(3,"Kaja" ,"Kallas", new Date()),
            new Isik(4,"Arnold" ,"Rüütel", new Date()),
            new Isik(5,"Adrian" ,"Käsper", new Date())
    ));
    @GetMapping("isikud")
    public List<Isik> saaIsikud() {
        return isikud;
    }

    @DeleteMapping("kustuta-isik/{index}")
    public String kustutaToode(@PathVariable int index) {
        isikud.remove(index);
        return "Toode kustutatud!";
    }

    @PostMapping("lisa-isik")
    public List<Isik> lisaIsikURLParameetritega(
            @RequestParam int id,
            @RequestParam String eesnimi,
            @RequestParam String perenimi,
            @RequestParam double hind) {
        isikud.add(new Isik(id, eesnimi, perenimi, new Date()));
        return isikud;
    }

}
