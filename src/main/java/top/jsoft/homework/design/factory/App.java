package top.jsoft.homework.design.factory;

import top.jsoft.commons.util.PrintManager;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class App {
    public static void main(String[] args) {
        //Wood
        Factory woodFactory = new WoodFactory();

        Auction auction = new Auction(woodFactory);
        Chair chair = auction.getFactory().createChair();
        Table table = auction.getFactory().createTable();
        PrintManager.info("Lot 1: " + chair.getClass().getSimpleName() + " country: " + chair.getManufacturerCountry() + " material: " + chair.getType());
        PrintManager.info("Lot 2: " + table.getClass().getSimpleName() + " country: " + table.getManufacturerCountry() + " material: " + table.getType());

        //Steel
        Factory steelFactory = new SteelFactory();

        auction = new Auction(steelFactory);
        chair = auction.getFactory().createChair();
        table = auction.getFactory().createTable();
        PrintManager.info("Lot 3: " + chair.getClass().getSimpleName() + " country: " + chair.getManufacturerCountry() + " material: " + chair.getType());
        PrintManager.info("Lot 4: " + table.getClass().getSimpleName() + " country: " + table.getManufacturerCountry() + " material: " + table.getType());

    }
}
