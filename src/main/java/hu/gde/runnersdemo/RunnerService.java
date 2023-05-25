package hu.gde.runnersdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunnerService {

    private final RunnerRepository runnerRepository;

    @Autowired
    public RunnerService(RunnerRepository runnerRepository) {
        this.runnerRepository = runnerRepository;
    }

    public double getAverageLaptime(Long runnerId) {
        RunnerEntity runner = runnerRepository.findById(runnerId).orElse(null);
        if (runner != null) {
            List<LapTimeEntity> laptimes = runner.getLaptimes();
            int totalTime = 0;
            for (LapTimeEntity laptime : laptimes) {
                totalTime += laptime.getTimeSeconds();
            }
            return (double) totalTime / laptimes.size();
        } else {
            return -1.0;
        }
    }
    public double getaverageheight() {
        List<RunnerEntity> runners = runnerRepository.findAll();
        int totalheight = 0;
        for (RunnerEntity runner : runners) {
            totalheight += runner.getheight();
        }
        if (runners.size() > 0) {
            double averageheight = (double) totalheight / runners.size();
            return averageheight;
        } else {
            return 0.0;
        }
    }
}
