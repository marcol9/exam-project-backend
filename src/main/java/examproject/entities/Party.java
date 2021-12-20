package examproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private char letter;
    @Column(nullable = false, length = 150)
    private String name;
    @OneToMany(mappedBy = "party")
    @JsonIgnore
    private Collection<Candidate> candidates;

    public int getId() {
        return id;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(Collection<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Party(char letter, String name) {
        this.letter = letter;
        this.name = name;
    }

    public Party() {
    }
}
