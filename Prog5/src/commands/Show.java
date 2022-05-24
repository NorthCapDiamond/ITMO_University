package commands;

import managers.CollectionManager;
import util.Environment;

public class Show implements Command{

    private CollectionManager collectionManager;


    @Override
    public void execute(Environment environment, String name) {
        collectionManager = environment.getCollectionManager();
        if (this.collectionManager.length()>0) {
            System.out.println(collectionManager.toString());
        }
        else {
            System.out.println("Коллекция пуста.");
        }
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении.";
    }
}
