package ee.adrian.kontrolltoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PoodController {
    @Autowired
    ToodeController toodeController;

    List<Toode> selverTooted = new ArrayList<>(Arrays.asList(
            new Toode(0, "Koola", 3.0, 0.0, 10),
            new Toode(1, "Fanta", 12.0, 0.15, 30),
            new Toode(2, "Kartul", 1.5, 0.3, 20),
            new Toode(3, "Liha", 7.3, 0.5, 14),
            new Toode(4, "Muna", 0.3, 0.0, 16)
    ));
    List<Toode> bauhofTooted = new ArrayList<>(Arrays.asList(
            new Toode(0, "Haamer", 40.0, 0.9, 10),
            new Toode(1, "Nael", 0.2, 0.15, 30),
            new Toode(2, "Kruvi", 0.1, 0.1, 20),
            new Toode(3, "Laelamp", 80.0, 0.2, 14),
            new Toode(4, "Põrandaplaat", 1.7, 0.0, 16)
    ));
    List<Pood> poed = new ArrayList<>(Arrays.asList(
            new Pood(0, "Selver", selverTooted),
            new Pood(1, "Bauhof", bauhofTooted)
    ));
    @GetMapping("poed")
    public List<Pood> saaPoed() {
        return poed;
    }

    // POST localhost:8080/lisa-pood?id=2&nimi=Euronics&tooteIndexid=0,1,2
    @GetMapping("lisa-pood")
    public List<Pood> lisaPood(
            @RequestParam int id,
            @RequestParam String nimi,
            @RequestParam int[] tooteIndexid) {

        List<Toode> tooted = new ArrayList<>();
        for (int i: tooteIndexid) {
            Toode toode = toodeController.tooted.get(i);
            tooted.add(toode);
        }
        poed.add(new Pood(id, nimi, tooted));
        return poed;
    }
    //localhost:8080/pood?id=2
    @GetMapping("pood")
    public Pood saaPood(
            @RequestParam int id
    ) {
        for (Pood pood : poed) {
            if (pood.getId() == id) {
                return pood;
            }
        }
        return null;
    }
}
