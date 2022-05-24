package commands;

import util.Environment;
import util.WrongScriptException;

import java.io.*;
import java.util.Scanner;

public class ExecuteScript implements Command{
    private String link;
    private FileInputStream fileInputStream;
    private Invoker invoker;

    @Override
    public void execute(Environment environment, String message)  {
        link = message;
        invoker = new Invoker(environment, new Command[]{new Help(), new Show(), new Add(), new Clear(), new Info(), new Head(), new ExecuteScript(),new Exit(), new Save(), new UpdateId(), new UniqueNumberOfParticipants(), new RemoveGreater(), new RemoveById(), new FilterGreaterThanGenre(), new FilterStartsWithName(),new History(), new Rick()});
        try {
            environment.setScript(true);
            fileInputStream = new FileInputStream(link);
            Reader reader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            environment.setUserInput(bufferedReader);
            String userLine = bufferedReader.readLine();
            while (!userLine.equals("EOF")){
                invoker.excecuter(userLine);
                userLine=bufferedReader.readLine();
            }
            System.out.println("Скрипт корректно завершен");
        }catch (WrongScriptException e){
            System.out.println("Ваш скрипт написан с ошибкой");
        } catch (FileNotFoundException e) {
            System.out.println("нет такого файла");
        }catch (NullPointerException e){
            System.out.println("Нет такой команды");
            System.out.println("Ваш скрипт написан с ошибкой");

        } catch (IOException e) {
            System.out.println("Ваш скрипт написан с ошибкой");
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
