package top.jsoft.homework.design.factory;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class SteelTable implements Table{
    @Override
    public String getManufacturerCountry() {
        return "Made from Germany.";
    }

    @Override
    public FactoryType getType() {
        return FactoryType.STEEL;
    }
}
