package be.bstorm.trash.dl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Getter
public class Capability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @ManyToMany(mappedBy = "capabilities")
    private Set<Beast> beasts = new HashSet<>();

    public Capability(String name) {
        this();
        this.name = name;
    }
}
