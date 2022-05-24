package commands;

import data.MusicBand;
import managers.CollectionManager;
import util.Environment;
import util.WrongScriptException;

import javax.xml.bind.*;
import javax.xml.stream.XMLInputFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.LinkedList;

public class Save implements Command {
    private CollectionManager collectionManager;
    private BufferedReader userInput;
    private boolean isScript;

    @Override
    public void execute(Environment environment, String name) throws WrongScriptException {
        collectionManager = environment.getCollectionManager();
        userInput = environment.getUserInput();
        isScript = environment.isScript();

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите ссылку на файл");
            try {
                OutputStream fileOutputStream = new FileOutputStream(userInput.readLine());
                JAXBContext jaxbContext = JAXBContext.newInstance(collectionManager.getClass());
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(collectionManager,fileOutputStream);
                System.out.println("Файл сохранен");
                /*
                for (MusicBand band : collectionManager.getMusicBands()){
                    marshaller.marshal(band,fileOutputStream);
                }*/

                break;
            } catch (FileNotFoundException e) {
                if(isScript)throw new WrongScriptException();
                if (i==2){
                    System.out.println("Программа принудительно завершена");
                    return;
                }
                System.out.println("нет такого файла");
                System.out.println(String.format("Осталось %d попыток",2-i));
            } catch (IOException e) {
                if(isScript)throw new WrongScriptException();
                if (i==2){
                    System.out.println("Программа принудительно завершена");
                    return;
                }
                System.out.println();
                System.out.println(String.format("Осталось %d попыток",2-i));
            } catch (JAXBException e) {
                if(isScript)throw new WrongScriptException();
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "save : сохранить коллекцию в файл.";
    }
}
