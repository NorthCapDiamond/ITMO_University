package commands;

import data.Album;
import data.MusicBand;
import data.MusicGenre;
import managers.CollectionManager;
import util.Environment;
import util.WrongScriptException;

import java.io.BufferedReader;
import java.io.IOException;

public class UpdateId implements Command{

    private CollectionManager collectionManager;
    private int id;
    private String idx;
    private BufferedReader userInput;
    private MusicBand newBand;
    private boolean isScript;



    @Override
    public void execute(Environment environment, String names) throws WrongScriptException {
        collectionManager = environment.getCollectionManager();
        idx = names;
        userInput = environment.getUserInput();
        isScript = environment.isScript();

        try {
            id = Integer.parseInt(idx);
        }catch (Exception e){
            if(isScript){
                throw new WrongScriptException();
            }
            System.out.println("вы ввели не число типа Integer");
            return;
        }
        try {
            newBand = collectionManager.findById(id);
        }catch (Exception e){
            if(isScript){
                throw new WrongScriptException();
            }
            System.out.println("нет такого элемента");
            return;
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите название новой группы:");
            try {
                String name = userInput.readLine();
                if (name==null|name.isEmpty()){
                    throw new IOException("Группа должно иметь непустое имя");
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
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return "update id : обновить значение элемента коллекции, id которого равен заданному.";
    }
}
