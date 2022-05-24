package commands;

import util.Environment;
import util.WrongScriptException;

public interface Command {
    void execute(Environment environment, String message) throws WrongScriptException;
    String getName();
    String getDescription();
}
