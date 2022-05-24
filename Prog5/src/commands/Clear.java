package commands;

import managers.CollectionManager;
import util.Environment;

public class Clear implements Command {
    private CollectionManager collectionManager;

    @Override
    public void execute(Environment environment, String message) {
        collectionManager = environment.getCollectionManager();
        collectionManager.removeAllElements();
        System.out.println("Коллекция очищена");
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "clear : очистить коллекцию";
    }
}
