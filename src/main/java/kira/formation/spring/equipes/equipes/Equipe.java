package kira.formation.spring.equipes.equipes;

import jakarta.persistence.*;
import kira.formation.spring.equipes.personnes.Personne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    @ManyToMany
    private Set<Personne> membres = new HashSet<>();

    @ManyToOne
    private Personne representant;
}
