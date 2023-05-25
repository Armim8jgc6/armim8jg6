package hu.gde.runnersdemo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Sponsor")
public class SponsorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonIgnore
    @ManyToMany
    @JoinColumn(nullable = false)
    private RunnerEntity runner;

    @Column(name = "sponsor_type", nullable = false)
    private String sponsorType;
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public RunnerEntity getRunner(){
        return runner;
    }
    public void setRunner(RunnerEntity runner){
        this.runner = runner;
    }
    public String getSponsorType() {
        return sponsorType;
    }
    public void setSponsorType(String sponsorType) {this.sponsorType = sponsorType;}
}
