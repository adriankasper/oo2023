package ee.adrian.kontrolltoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
public class KorvController {
    @Autowired
    ToodeController toodeController;
    List<Korv> korvid = new ArrayList<>(Arrays.asList(
            new Korv(0, Arrays.asList(new Toode(0, "Koola", 3.0, 0.0, 10),
                    new Toode(4, "Koola", 0.3, 0.0, 16)))
    ));
    @GetMapping("lisa-korv")
    public List<Korv> lisaKorv(
            @RequestParam int id,
            @RequestParam int[] tooteIndexid) {

        List<Toode> tooted = new ArrayList<>();
        for (int i: tooteIndexid) {
            Toode toode = toodeController.tooted.get(i);
            tooted.add(toode);
        }
        korvid.add(new Korv(id, tooted));
        return korvid;
    }
    @GetMapping("korv-kokku")
    public double korvKokku(
            @RequestParam int id
    ) {
        double total = 0.0;

        for (Korv korv : korvid) {
            if (korv.getId() == id) {
                for (Toode toode : korv.getTooted()) {
                    total += toode.getHind() * toode.getAllahindlus();
                }
            }
        }
        return total;
    }

    public void eemaldaLaost(int[] tooteIndexid){
        for (int i: tooteIndexid) {
            Toode toode = toodeController.tooted.get(i);
            //toode.getLaoseis() = toode.getLaoseis() - 1;
        }
    }
}
