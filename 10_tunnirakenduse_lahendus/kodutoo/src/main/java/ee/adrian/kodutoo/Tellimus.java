package ee.adrian.kodutoo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Tellimus {
    private int id;
    private Isik tellija;
    private List<Laev> laevad;
}
