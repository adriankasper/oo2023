package ee.adrian.kontrolltoo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Pood {
    @Id
    private int id;
    private String nimetus;
    @OneToMany
    private List<Toode> tooted;

    /*

    Lisa uus toode:
    localhost:8080/lisa-toode?id=10&nimi=Samsung&hind=600&allahindlus=0.1&laoseis=300

    Lisa pood:
    localhost:8080/lisa-pood?id=2&nimi=Euronics&tooteIndexid=10

    Vaata poodi ja selle tooteid:
    localhost:8080/pood?id=2

    Vaata allahindlusega tooteid:
    localhost:8080/leia-allahindlus

    Hind madalam kui:
    localhost:8080/hind-madalam-kui?hind=1.0
     */
}
