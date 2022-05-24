import commands.*;
import data.Album;
import data.Coordinates;
import data.MusicBand;
import data.MusicGenre;
import managers.CollectionManager;
import util.Environment;
import util.WrongScriptException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.beans.XMLDecoder;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        CollectionManager manager = new CollectionManager();
        String link;



        /** создадим группу для тестов*/
        Album pastLives = new Album("Past lives", 11, 36*60+24, 1000000000);
        MusicBand atc = new MusicBand();
        atc.setId(10101);
        atc.setGenre(MusicGenre.ROCK);
        atc.setName("Against the Current");
        atc.setBestAlbum(pastLives);
        atc.setNumberOfParticipants(3);
        atc.setAlbumsCount(3);
        atc.setCreationDate(LocalDate.now());
        float x = 1;
        long y = 2;
        atc.setCoordinates(new Coordinates(x,y));
        ArrayList<String> history = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream writer = new PrintStream(System.out);


        /** а теперь еще несколько возьмем из xml файла*/

        try {
            link = "/Users/dmitrydrobysh/Desktop/Prog6/Lab6_server/src/Collection.xml";
            FileInputStream fileInputStream = new FileInputStream(link);
            JAXBContext jaxbContext = JAXBContext.newInstance(CollectionManager.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            manager = (CollectionManager) unmarshaller.unmarshal(fileInputStream);


        } catch (FileNotFoundException e) {
            System.out.println("Файл передан некорректно");
        } catch (JAXBException e) {
            e.printStackTrace();}



        Environment environment = new Environment(manager,reader,writer, history, false);
        Invoker invoker = new Invoker(environment, new Command[]{new Help(), new Show(), new Add(), new Clear(), new Info(), new Head(), new ExecuteScript(),new Exit(), new Save(), new UpdateId(), new UniqueNumberOfParticipants(), new RemoveGreater(), new RemoveById(), new FilterGreaterThanGenre(), new FilterStartsWithName(),new History(), new Rick()});
        manager.add(atc);//ну и добавим тестовую

        while (true){
            System.out.println("Введите команду");
            try {
                String userTyping = reader.readLine();
                invoker.excecuter(userTyping);
                history.add(userTyping.split(" ")[0]);
            }
            catch (IOException ex){
                System.out.println("некорректный ввод");
            }
            catch (NullPointerException exe){
                System.out.println("нет такой команды");
            } catch (WrongScriptException exep) {
                System.out.println("скрипт провален!");
            }
        }
    }
}
