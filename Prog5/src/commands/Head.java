package commands;

import data.MusicBand;
import managers.CollectionManager;
import util.Environment;

public class Head implements Command{
    private CollectionManager collectionManager;

    @Override
    public void execute(Environment environment, String message) {
        collectionManager = environment.getCollectionManager();
        MusicBand headBand =collectionManager.getHead();
        System.out.println(headBand.toString());
    }

    @Override
    public String getName() {
        return "head";
    }

    @Override
    public String getDescription() {
        return "head : вывести первый элемент коллекции.";
    }
}
