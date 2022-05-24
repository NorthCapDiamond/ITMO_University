package commands;

import data.MusicBand;
import managers.CollectionManager;
import util.Environment;

public class UniqueNumberOfParticipants implements Command{
    private CollectionManager collectionManager;

    @Override
    public void execute(Environment environment, String name) {
        collectionManager = environment.getCollectionManager();
        for (MusicBand band: collectionManager.getMusicBands()){
            System.out.println(band.getName()+", number of participants: "+band.getNumberOfParticipants());
        }
    }

    @Override
    public String getName() {
        return "print_unique_number_of_participants";
    }

    @Override
    public String getDescription() {
        return "print_unique_number_of_participants : вывести уникальные значения поля numberOfParticipants всех элементов в коллекции.";
    }
}
