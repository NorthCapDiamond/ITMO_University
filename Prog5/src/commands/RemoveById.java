package commands;

import managers.CollectionManager;
import util.Environment;
import util.WrongScriptException;

public class RemoveById implements Command{
    private CollectionManager collectionManager;
    private String idx;
    private int id;
    private boolean isScript;


    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {
        collectionManager = environment.getCollectionManager();
        idx = message;
        isScript = environment.isScript();
        try {
            id = Integer.parseInt(idx);
        }catch (Exception e){
            if(isScript){
                throw new WrongScriptException();
            }
            System.out.println("Вы ввели не число типа Integer");
            return;
        }
        try {
            if(collectionManager.findById(id) == null){
                throw new NullPointerException();
            }
            collectionManager.removeById(id);
            System.out.println("Элемент с ID: "+String.format("%d",id)+" удален.");
        }catch (NullPointerException e){
            if(isScript){
                throw new WrongScriptException();
            }
            System.out.println("нет такого элемента");
        }
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescription() {
        return "remove_by_id id : удалить элемент из коллекции по его id.";
    }
}
