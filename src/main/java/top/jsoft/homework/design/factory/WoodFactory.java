package top.jsoft.homework.design.factory;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class WoodFactory implements Factory{
    @Override
    public Chair createChair() {
        return new WoodChair();
    }

    @Override
    public Table createTable() {
        return new WoodTable();
    }
}
