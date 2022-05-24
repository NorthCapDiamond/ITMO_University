package commands;

import data.Album;
import data.MusicBand;
import data.MusicGenre;
import managers.CollectionManager;
import util.Environment;
import util.WrongScriptException;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Add implements Command{
    private CollectionManager collectionManager;
    private BufferedReader userInput;
    private boolean isScript;

    @Override
    public void execute(Environment environment, String message) throws WrongScriptException {
        collectionManager = environment.getCollectionManager();
        userInput = environment.getUserInput();
        isScript = environment.isScript();

        MusicBand newBand = new MusicBand();
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите название новой группы:");
            try {
                String name = userInput.readLine();
                if (name==null|name.isEmpty()){
                    throw new IOException("Группа должна иметь непустое имя");
                }
                newBand.setName(name);
                break;
            } catch (IOException e) {
                if(!e.getMessage().isEmpty()){
                    System.out.println(e.getMessage());
                }
                else {
                    System.out.println("Некоррктный ввод");
                }
                if(isScript){
                    throw new WrongScriptException();
                }
                if (i == 2) {
                    System.out.println("Команда принудительно закрыта. Попробуйте снова.");
                    return;
                } else{

            System.out.println("Оставшихся попыток: " + String.format("%d", 2 - i));
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите количество участников:");
            try {
                String input = userInput.readLine().toString();
                int count = Integer.parseInt(input);
                if (count==0)throw new IOException("Не должно быть 0 участников");
                newBand.setNumberOfParticipants(count);
                break;
            } catch (IOException e) {
                if(isScript){
                    throw new WrongScriptException();
                }
                if (i == 2) {
                    System.out.println("Команда принудительно закрыта. Попробуйте снова.");
                    return;
                } else{
                    System.out.println(e.getMessage());
                    System.out.println("Оставшихся попыток: " + String.format("%d", 2 - i));
                }
            }
            catch (NumberFormatException e){
                System.out.println("Введите число типа Integer");
                System.out.println("Оставшихся попыток: " + String.format("%d", 2 - i));
            }
        }


        for (int i = 0; i < 3; i++) {
            System.out.println("Введите количество альбомов:");
            try {
                String input = userInput.readLine().toString();
                int count = Integer.parseInt(input);
                newBand.setAlbumsCount(count);
                break;
            } catch (IOException e) {
                if(isScript){
                    throw new WrongScriptException();
                }
                if (i == 2) {
                    System.out.println("Команда принудительно закрыта. Попробуйте снова.");
                    return;
                } else{
                    System.out.println(e.getMessage());
                    System.out.println("Оставшихся попыток: " + String.format("%d", 2 - i));
                }
            }
            catch (NumberFormatException e){
                System.out.println("Введите число типа Integer");
                System.out.println("Оставшихся попыток: " + String.format("%d", 2 - i));
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Создание альбома");
            System.out.println("Введите одной строкой через пробел: Название (String), Количество треков (long), Продолжительность (Integer), Продажи (long) ");
            try {
                Album album = new Album();
                String count[] = userInput.readLine().split(" ");
                String name = "";
                for (int j = 0; j < count.length-3; j++) {
                    if(j==count.length-4){
                        name+=count[j];
                    }else {
                        name+=count[j]+" ";
                    }
                }
                album.setName(name);
                album.setTracks(Long.parseLong(count[count.length-3]));
                album.setLength(Integer.parseInt(count[count.length-2]));
                album.setSales(Long.parseLong(count[count.length-1]));
                if(album.getSales()==0 | album.getTracks()==0| album.getLength()==0) throw new IOException();
                System.out.println(String.format("Альбом "+album.getName()+" успешно создан"));
                newBand.setBestAlbum(album);
                break;
            } catch (Exception e) {
                if(isScript){
                    throw new WrongScriptException();
                }
                if (i == 2) {
                    System.out.println("Команда принудительно закрыта. Попробуйте снова.");
                    return;
                } else{
                    System.out.println("Некоррктный ввод");
                    System.out.println("Оставшихся попыток: " + String.format("%d", 2 - i));
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите жанр:");
            try {
                newBand.setGenre(MusicGenre.valueOf(userInput.readLine()));
                break;
            } catch (Exception e) {
                if(isScript){
                    throw new WrongScriptException();
                }
                if (i == 2) {
                    System.out.println("Команда принудительно закрыта. Попробуйте снова.");
                    return;
                } else {
                    System.out.println("Некоррктный ввод");
                    System.out.println("Оставшихся попыток: " + String.format("%d", 2 - i));
                }
            }
        }
        newBand.setId(idGenerate(newBand, collectionManager));
        newBand.setCreationDate(generateCreationDate());
        collectionManager.add(newBand);
        System.out.println("Группа добавлена\n\n");
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "add : добавить новый элемент в коллекцию.";
    }



    private LocalDate generateCreationDate(){
        long minDay = LocalDate.of(0000, 1, 1).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return (randomDate);
    }
    private int idGenerate(MusicBand band, CollectionManager manager){
        int id = band.hashCode();
        while(manager.findById(id) != null){
            id++;
        }
        return id;
    }
}
