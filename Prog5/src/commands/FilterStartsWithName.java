package commands;

import data.MusicBand;
import managers.CollectionManager;
import util.Environment;

public class FilterStartsWithName implements Command{
    private CollectionManager collectionManager;


    @Override
    public void execute(Environment environment, String name) {
        collectionManager = environment.getCollectionManager();
        for(MusicBand band: collectionManager.getMusicBands()){
            if(band.getName().startsWith(name)){
                System.out.println(band.getName());
            }
        }
        return;
    }

    @Override
    public String getName() {
        return "filter_starts_with_name";
    }

    @Override
    public String getDescription() {
        return "filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки";
    }
}
