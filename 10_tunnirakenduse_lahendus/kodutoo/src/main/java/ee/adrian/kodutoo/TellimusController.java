package ee.adrian.kodutoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.AnnotationDrivenBeanDefinitionParser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

@RestController
public class TellimusController {
    @Autowired
    LaevListController laevListController;
    @Autowired
    IsikController isikController;
    List<Laev> tellitudLaevad = new ArrayList<>(Arrays.asList(
            new Laev(1,"Regula", 1100000.0,true),
            new Laev(2,"Viking Star", 3005111.0, true)
    ));

    Isik tellija = new Isik(1, "Raivo", "Hein", new Date());
    List<Tellimus> tellimused = new ArrayList<>(Arrays.asList(
            new Tellimus(1, tellija, tellitudLaevad)
    ));
    @GetMapping("tellimused")
    public List<Tellimus> saaTellimused() {
        return tellimused;
    }

    @DeleteMapping("kustuta-tellimus/{index}")
    public String kustutaLaev(@PathVariable int index) {
        tellimused.remove(index);
        return "Tellimus kustutatud!";
    }


    // POST localhost:8080/lisa-tellimus?id=9&tellijaIndex=3&tooteIndex=2
    @PostMapping("lisa-tellimus")
    public List<Tellimus> lisaLaev(
            @RequestParam int id,
            @RequestParam int tellijaIndex,
            @RequestParam int tooteIndex) {

        Isik tellija = isikController.isikud.get(tellijaIndex);

        Laev tellitudLaev = laevListController.laevad.get(tooteIndex);
        List<Laev> tellitudlaevad = new ArrayList<>(Arrays.asList(tellitudLaev));

        tellimused.add(new Tellimus(id, tellija, tellitudlaevad));
        return tellimused;
    }
    // POST localhost:8080/lisa-tellimus2?id=9&tellijaIndex=3&tooteIndexid=2,2,3


}
