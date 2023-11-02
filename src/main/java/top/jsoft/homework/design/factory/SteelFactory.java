package top.jsoft.homework.design.factory;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class SteelFactory implements Factory{
    @Override
    public Chair createChair() {
        return new SteelChair();
    }

    @Override
    public Table createTable() {
        return new SteelTable();
    }
}
