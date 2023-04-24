import java.util.Stack;

public class CommandHistory {
    private Stack<String> history;

    public CommandHistory() {
        history = new Stack<>();
    }

    public void addCommand(String command) {
        history.push(command);
        if (history.size() > 7) {
            history.removeElementAt(0);
        }
    }

    public void printHistory() {
        System.out.println("История команд:");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println(history.get(i));
        }
    }
}
