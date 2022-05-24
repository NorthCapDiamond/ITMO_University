package util;

import managers.CollectionManager;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Environment {
    private CollectionManager collectionManager;
    private BufferedReader userInput;
    private PrintStream UserOutput;
    private ArrayList<String> history;
    private boolean isScript;

    public Environment(CollectionManager collectionManager, BufferedReader userInput, PrintStream userOutput, ArrayList<String> history, boolean isScript){
        this.collectionManager = collectionManager;
        this.history = history;
        this.userInput = userInput;
        this.isScript = isScript;
        this.UserOutput = userOutput;

    }

    public CollectionManager getCollectionManager() {
        return collectionManager;
    }

    public BufferedReader getUserInput() {
        return userInput;
    }

    public PrintStream getUserOutput() {
        return UserOutput;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public boolean isScript() {
        return isScript;
    }

    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void setUserInput(BufferedReader userInput) {
        this.userInput = userInput;
    }

    public void setUserOutput(PrintStream userOutput) {
        UserOutput = userOutput;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }

    public void setScript(boolean script) {
        isScript = script;
    }
}
