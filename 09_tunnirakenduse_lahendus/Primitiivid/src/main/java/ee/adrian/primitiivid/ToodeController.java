package ee.adrian.primitiivid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToodeController {
    Toode toode = new Toode(1,"Koola", 1.5, true);
    @GetMapping("toode")
    public Toode saaToode() {
        return toode;
    }
    @GetMapping("kustuta-toode")
    public Toode kustutaToode() {
        toode = null;
        return toode;
    }
    @GetMapping("kustuta-toode2")
    public String kustutaToode2() {
        toode = null;
        return "Edukalt kustutatud!";
    }
    @GetMapping("suurenda-hinda")
    public Toode suurendaHinda() {
        toode.setHind( toode.getHind()+1 );
        return toode;
    }
    @GetMapping("muuda-aktiivsust")
    public Toode muudaAktiivsust(){
        toode.setAktiivne(!toode.isAktiivne());
        return toode;
    }
    @GetMapping("muuda-nime/{nimi}")
    public Toode muudaNime(@PathVariable String nimi){
        toode.setNimi(nimi);
        return toode;
    }
}
