package commands;

import data.MusicBand;
import managers.CollectionManager;
import util.Environment;
import util.WrongScriptException;

public class FilterGreaterThanGenre implements Command{
    private CollectionManager collectionManager;
    private MusicBand band;
    private boolean isScript;


    @Override
    public void execute(Environment environment, String name) throws WrongScriptException {
        collectionManager = environment.getCollectionManager();
        isScript = environment.isScript();
        try {
            if(collectionManager.findByName(name)==null){
                throw new NullPointerException();
            }
            band = collectionManager.findByName(name);
        }catch (Exception e){
            if(isScript){
                throw new WrongScriptException();
            }
            System.out.println("нет такого элемента");
            return;
        }
        try{
            for (MusicBand bands : collectionManager.getMusicBands() ) {
                if (bands.getGenre().compareTo(bands.getGenre(),band.getGenre())){
                    System.out.println(bands.toString());
                }
            }
        }catch (Exception e){
            if(isScript){
                throw new WrongScriptException();
            }
            System.out.println("exception");
        }
    }

    @Override
    public String getName() {
        return "filter_greater_than_genre";
    }

    @Override
    public String getDescription() {
        return "filter_greater_than_genre genre : вывести элементы, значение поля genre которых больше заданного";
    }
}
