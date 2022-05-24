package commands;

import util.Environment;

public class Help implements  Command{
    @Override
    public void execute(Environment environment, String message) {
        System.out.println("\n" +
                "help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "head : вывести первый элемент коллекции\n" +
                "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                "history : вывести последние 10 команд (без их аргументов)\n" +
                "filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки\n" +
                "filter_greater_than_genre genre : вывести элементы, значение поля genre которых больше заданного\n" +
                "print_unique_number_of_participants : вывести уникальные значения поля numberOfParticipants всех элементов в коллекции\n"+
                "dont_type_it : NOOOOOOOOOOOOOO");

    }
    @Override
    public String getName() {
        return "help";
    }
    @Override
    public String getDescription() {
        return "help : вывести справку по доступным командам.";
    }
}
