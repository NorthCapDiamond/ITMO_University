package commands;

import managers.CollectionManager;
import util.Environment;

public class Info implements Command{
    private CollectionManager collectionManager;

    @Override
    public void execute(Environment environment, String message) {
        collectionManager = environment.getCollectionManager();
        System.out.println("Тип коллекции: "+this.collectionManager.getClass()+". Дата инициализации: "+this.collectionManager.getCreationDate()+ ". Количество элементов: "+this.collectionManager.length()+".");
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "info : вывести в стандартный поток вывода информацию о коллекции. (тип, дата инициализации, количество элементов и т.д.)";
    }
}
