package commands;

import util.Environment;

public class Exit implements Command{
    @Override
    public void execute(Environment environment, String message) {
        System.out.println("Работа программы завершена!");
        System.exit(0);
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "exit : завершить программу. (без сохранения в файл)";
    }
}
