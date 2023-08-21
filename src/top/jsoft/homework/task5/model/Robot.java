package top.jsoft.homework.task5.model;

import lombok.Getter;
import top.jsoft.commons.util.PrintManager;
import top.jsoft.homework.task5.enums.PatricipantType;
import top.jsoft.homework.task5.interfaces.Participant;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Getter
public class Robot implements Participant {
    private final String name;

    public Robot(String name) {
        this.name = name;
    }

    public void run() {
        PrintManager.info("Robot " + name + " is run.");
    }

    public void jump() {
        PrintManager.info("Robot " + name + " is jump.");
    }

    @Override
    public PatricipantType getType() {
        return PatricipantType.ROBOT;
    }
}