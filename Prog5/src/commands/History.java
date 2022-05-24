package commands;

import util.Environment;

import java.util.ArrayList;

public class History implements Command{

    private ArrayList<String> commands;


    @Override
    public void execute(Environment environment, String message) {
        commands = environment.getHistory();
        Object[] array = commands.toArray();
        int mini = Math.max(array.length-10,0);
        for (int i = array.length-1; i > mini-1; i--) {
            System.out.println(array[i].toString());
        }
        if(array.length==0) System.out.println("История пустая");
    }

    @Override
    public String getName() {
        return "history";
    }

    @Override
    public String getDescription() {
        return "history : вывести последние 10 команд. (без их аргументов)";
    }
}
