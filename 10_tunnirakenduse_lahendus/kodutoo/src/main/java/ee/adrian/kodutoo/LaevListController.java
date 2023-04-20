package ee.adrian.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaevListController {
    List<Laev> laevad = new ArrayList<>(Arrays.asList(
            new Laev(1,"Silja Europa", 180000, true),
            new Laev(2,"Regula", 200000, true),
            new Laev(3,"Tõll", 5000000, true)
    ));
    @GetMapping("laevad")
    public List<Laev> saaLaevad() {
        return laevad;
    }
    @GetMapping("kustuta-laev/{index}")
    public String kustutaLaev(@PathVariable int index) {
        laevad.remove(index);
        return "Toode kustutatud!";
    }
    @GetMapping("lisa-laev/{id}/{nimi}/{hind}/{aktiivne}")
    public List<Laev> lisaLaev(
            @PathVariable int id,
            @PathVariable String nimi,
            @PathVariable double hind,
            @PathVariable boolean aktiivne) {
        laevad.add(new Laev(id, nimi, hind, aktiivne));
        return laevad;
    }
}