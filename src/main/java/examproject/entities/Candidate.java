package examproject.entities;

import javax.persistence.*;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 170)
    private String name;
    private Integer votes;
    @ManyToOne
    private Party party;

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Candidate(String name, Party party) {
        this.name = name;
        this.party = party;
    }

    public Candidate(String name, Integer votes, Party party) {
        this.name = name;
        this.votes = votes;
        this.party = party;
    }

    public Candidate() {
    }
}
