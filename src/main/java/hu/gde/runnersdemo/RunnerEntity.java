package hu.gde.runnersdemo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RunnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long runnerId;
    private String runnerName;
    private long averagePace;

    private long height;

    @OneToMany(mappedBy = "runner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LapTimeEntity> laptimes = new ArrayList<>();
    @OneToMany(mappedBy = "runner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SponsorEntity> SponsorType = new ArrayList<>();



    public RunnerEntity() {
    }

    public long getRunnerId() {
        return runnerId;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public long getAveragePace() {
        return averagePace;
    }

    public void setRunnerId(long runnerId) {
        this.runnerId = runnerId;
    }
    public long getheight(){return height;}

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }
    public void setheight(long height) {this.height = height;}

    public void setAveragePace(long averagePace) {
        this.averagePace = averagePace;
    }

    public List<LapTimeEntity> getLaptimes() {
        return laptimes;
    }
    public List<SponsorEntity> getSponsorType(){return getSponsorType();}
}
