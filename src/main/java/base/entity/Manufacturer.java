package base.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "manufacturers")
public class Manufacturer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_manufacturer")
    private int id;

    @Column(name = "manufacturer")
    private String name;

    public Manufacturer(String name) {
        this.name = name;
    }
}
