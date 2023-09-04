package top.jsoft.homework.task5.model;


import top.jsoft.commons.util.PrintManager;
import top.jsoft.homework.task5.interfaces.Obstacle;
import top.jsoft.homework.task5.interfaces.Participant;

import java.util.List;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class Wall implements Obstacle {
    private static final int DEFAULT_HEIGHT_PERSON = 10;
    private static final int DEFAULT_HEIGHT_CAT = 20;
    private static final int DEFAULT_HEIGHT_ROBOT = 30;

    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void overcome(List<Participant> participants) {
        participants.forEach(participant -> {
            participant.jump();
            switch (participant.getType()) {
                case CAT -> PrintManager.info("Cat " + ((Cat) participant).getName() + " did " + (height < DEFAULT_HEIGHT_CAT ? "not overcome" : "overcome") + " the wall");
                case ROBOT -> PrintManager.info("Robot " + ((Robot) participant).getName() + " did " + (height < DEFAULT_HEIGHT_ROBOT ? "not overcome" : "overcome") + " the wall");
                case PERSON -> PrintManager.info("Person " + ((Person) participant).getName() + " did " + (height < DEFAULT_HEIGHT_PERSON ? "not overcome" : "overcome") + " the wall");
            }
        });
    }
}