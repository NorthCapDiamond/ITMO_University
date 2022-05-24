package commands;

import util.Environment;
import util.WrongScriptException;

import java.util.HashMap;

public class Invoker {
    private Environment environment;
    private HashMap<String, Command> commandHashMap = new HashMap<>();

    public Invoker(Environment environment, Command [] commands){
        this.environment = environment;
        for (Command command:commands) commandHashMap.put(command.getName(), command);
    }
    public void excecuter(String message) throws WrongScriptException {
        if(message.split(" ").length>1){
            System.setOut(System.out);
            String[] mem  = message.split(" ");
            String messageNext = "";
            for (int i = 0; i < mem.length; i++) {
                if (i>0 && i!=mem.length-1){
                    messageNext+=mem[i]+" ";
                }
                else {
                    if(i>0){
                        messageNext+=mem[i];
                    }
                }
            }
            commandHashMap.get(message.split(" ")[0]).execute(environment, messageNext);
        }
        else {
            System.setOut(System.out);
            commandHashMap.get(message).execute(environment, "");
        }
    }
}
