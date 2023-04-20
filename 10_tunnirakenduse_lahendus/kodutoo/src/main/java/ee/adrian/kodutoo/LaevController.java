package ee.adrian.kodutoo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaevController {
    Laev laev = new Laev(1,"Superstar", 300000000, true);
    @GetMapping("laev")
    public Laev saaLaev() {
        return laev;
    }

    @GetMapping("kustuta-laev")
    public String kustutaLaev() {
        laev = null;
        return "Edukalt kustutatud!";
    }
    @GetMapping("suurenda-hinda")
    public Laev suurendaHinda() {
        laev.setHind( laev.getHind()+1 );
        return laev;
    }
    @GetMapping("muuda-aktiivsust")
    public Laev muudaAktiivsust(){
        laev.setAktiivne(!laev.isAktiivne());
        return laev;
    }
    @GetMapping("muuda-nime/{nimi}")
    public Laev muudaNime(@PathVariable String nimi){
        laev.setNimi(nimi);
        return laev;
    }
}