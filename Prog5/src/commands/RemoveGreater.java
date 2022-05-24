package commands;

import data.MusicBand;
import managers.CollectionManager;
import util.Environment;
import util.WrongScriptException;

public class RemoveGreater implements Command{
    private CollectionManager collectionManager;
    private MusicBand ourBand;
    private boolean isScript;
    @Override
    public void execute(Environment environment, String name) throws WrongScriptException {
        collectionManager = environment.getCollectionManager();
        isScript = environment.isScript();

        try{
            ourBand = collectionManager.findByName(name);
        }catch (Exception e){
            if(isScript){
                throw new WrongScriptException();
            }
            System.out.println("Такого элемента не существует.");
            return;
        }
        for(MusicBand band: collectionManager.getMusicBands()){
            if(band.compareTo(ourBand)>0){
                collectionManager.removeById(band.getId());
            }
        }
        System.out.println("Команда выполнена");
    }

    @Override
    public String getName() {
        return "remove_greater";
    }

    @Override
    public String getDescription() {
        return "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный.";
    }
}
