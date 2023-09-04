package top.jsoft.homework.task5.interfaces;


import top.jsoft.homework.task5.enums.PatricipantType;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public interface Participant {
    void run();
    void jump();
    PatricipantType getType();
}
