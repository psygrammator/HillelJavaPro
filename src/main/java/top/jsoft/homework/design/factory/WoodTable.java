package top.jsoft.homework.design.factory;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class WoodTable implements Table{
    @Override
    public String getManufacturerCountry() {
        return "Made from China.";
    }

    @Override
    public FactoryType getType() {
        return FactoryType.WOOD;
    }
}
