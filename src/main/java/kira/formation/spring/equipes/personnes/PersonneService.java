package kira.formation.spring.equipes.personnes;

import kira.formation.spring.equipes.equipes.Equipe;
import kira.formation.spring.equipes.equipes.EquipeService;
import kira.formation.spring.equipes.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonneService {
    private final PersonneRepository personneRepository;

    public PersonneService(PersonneRepository repository){
        this.personneRepository = repository;
    }

    /**
     * Sauvegarde une personne et la persiste.
     * Retourne les données de la personne avec l'id.
     * @param personne a sauvegarder
     * @return personne sauvegarder avec son id
     */
    public Personne creer(Personne personne){
        return this.personneRepository.save(personne);
    }

    /**
     * Retourne une personne en fonction de son id.
     * @param id de la personne retournée
     * @return la personne si elle existe.
     * @throws ResponseStatusException si aucune personne ne porte cet id.
     */
    public Personne findById(Long id){
        return this.personneRepository.findById(id).orElseThrow(()->new NotFoundException("Aucune personne ne porte l'id "+id));
    }

    /**
     * Remplace les données d'une personne dans la base de données en fonction de l'id de la personne.
     * @param personne nouvelles données de la personne.
     * @return personne dans l'etat de la base de données.
     */
    public Personne modifier(Personne personne){
        return this.personneRepository.save(personne);
    }

    /**
     * Supprime une personne en fonction de son id.
     * @param id de la personne.
     */
    public void deleteById(Long id){
        this.personneRepository.deleteById(id);
    }

    /**
     * Retourne la liste des utilisateurs en fonction de leurs noms ou prenoms;
     * @param nom ou prenom de la personne
     * @return liste de personne portant comme nom ou prenom le paramètre.
     */
    public List<Personne> findByNomOrPrenom(String nom) {
        return personneRepository.findByNomOrPrenom(nom, nom);
    }

    /**
     * Retourne la liste des personnes sauvegardées en base de données.
     * @return liste de personnes.
     */
    public Iterable<Personne> findAll() {
        return personneRepository.findAll();
    }

}
