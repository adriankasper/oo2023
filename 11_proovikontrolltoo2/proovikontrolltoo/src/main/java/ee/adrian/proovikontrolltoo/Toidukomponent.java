package ee.adrian.proovikontrolltoo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Toidukomponent {
    @Id
    private Long id;
    @ManyToOne
    private Toiduaine toiduaine;
    private int kogus;
}
