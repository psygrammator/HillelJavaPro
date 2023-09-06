package top.jsoft.homework.task5.model;


import top.jsoft.commons.util.PrintManager;
import top.jsoft.homework.task5.interfaces.Obstacle;
import top.jsoft.homework.task5.interfaces.Participant;

import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class RunningTrack implements Obstacle {
    private static final int DEFAULT_DIST_PERSON = 50;
    private static final int DEFAULT_DIST_CAT = 100;
    private static final int DEFAULT_DIST_ROBOT = 150;

    private final int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    @Override
    public void overcome(List<Participant> participants) {
        participants.forEach(participant -> {
            participant.run();
            switch (participant.getType()) {
                case CAT -> PrintManager.info("Cat " + ((Cat) participant).getName() + " did " + (length < DEFAULT_DIST_CAT ? "not overcome" : "overcome") + " the running track");
                case ROBOT -> PrintManager.info("Robot " + ((Robot) participant).getName() + " did " + (length < DEFAULT_DIST_ROBOT ? "not overcome" : "overcome") + " the running track");
                case PERSON -> PrintManager.info("Person " + ((Person) participant).getName() + " did " + (length < DEFAULT_DIST_PERSON ? "not overcome" : "overcome") + " the running track");
            }
        });
    }
}