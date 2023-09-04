package top.jsoft.homework.task5.model;

import lombok.Getter;
import top.jsoft.homework.task5.enums.PatricipantType;
import top.jsoft.homework.task5.interfaces.Participant;
import top.jsoft.commons.util.PrintManager;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Getter
public class Cat implements Participant {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    public void run() {
        PrintManager.info("Cat " + name + " is run.");
    }

    public void jump() {
        PrintManager.info("Cat " + name + " is jump.");
    }

    @Override
    public PatricipantType getType() {
        return PatricipantType.CAT;
    }
}