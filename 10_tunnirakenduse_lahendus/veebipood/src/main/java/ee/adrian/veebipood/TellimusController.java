package ee.adrian.veebipood;

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
    ToodeController toodeController;
    @Autowired
    IsikController isikController;
    List<Toode> tellitudTooted = new ArrayList<>(Arrays.asList(
            new Toode(1,"Koola", 1.5),
            new Toode(2,"Fanta", 1.0),
            new Toode(3,"Sprite", 1.7)
    ));
    List<Toode> tellimuse2Tooted = new ArrayList<>(Arrays.asList(
            new Toode(1,"Koola2", 12.5),
            new Toode(2,"Fanta2", 12.0),
            new Toode(3,"Sprite2", 12.7)
    ));
    Isik tellija = new Isik(1, "Ees", "Pere", new Date());
    List<Tellimus> tellimused = new ArrayList<>(Arrays.asList(
            new Tellimus(1, tellija, tellitudTooted),
            new Tellimus(2, tellija, tellimuse2Tooted)
    ));
    @GetMapping("tellimused")
    public List<Tellimus> saaTellimused() {
        return tellimused;
    }

    @DeleteMapping("kustuta-tellimus/{index}")
    public String kustutaToode(@PathVariable int index) {
        tellimused.remove(index);
        return "Tellimus kustutatud!";
    }


    // POST localhost:8080/lisa-tellimus?id=9&tellijaIndex=3&tooteIndex=2
    @PostMapping("lisa-tellimus")
    public List<Tellimus> lisaToode(
            @RequestParam int id,
            @RequestParam int tellijaIndex,
            @RequestParam int tooteIndex) {
//        IsikController isikController = new IsikController();
//        System.out.println(isikController); // MÄLUKOHT     Dependency Injection
        Isik tellija = isikController.isikud.get(tellijaIndex);

//        ToodeController toodeController = new ToodeController();
        Toode tellitudToode = toodeController.tooted.get(tooteIndex);
        List<Toode> tellitudTooted = new ArrayList<>(Arrays.asList(tellitudToode));

        tellimused.add(new Tellimus(id, tellija, tellitudTooted));
        return tellimused;
    }
    // POST localhost:8080/lisa-tellimus2?id=9&tellijaIndex=3&tooteIndexid=2,2,3
    @PostMapping("lisa-tellimus2")
    public List<Tellimus> lisaToode2(
            @RequestParam int id,
            @RequestParam int tellijaIndex,
            @RequestParam int[] tooteIndexid) {
        Isik tellija = isikController.isikud.get(tellijaIndex);
        List<Toode> tellitudTooted = new ArrayList<>();
        for (int i: tooteIndexid) {
            Toode toode = toodeController.tooted.get(i);
            tellitudTooted.add(toode);
        }

        tellimused.add(new Tellimus(id, tellija, tellitudTooted));
        return tellimused;
    }
    // POST localhost:8080/lisa-tellimus3
    @PostMapping("lisa-tellimus3")
    public List<Tellimus> lisaTellimus3(
            @RequestBody Tellimus tellimus) {
        tellimused.add(tellimus);
        return tellimused;
    }

}
