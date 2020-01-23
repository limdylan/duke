import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TaskList {
    List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public int size() {
        return tasks.size();
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public boolean add(Task task) {
        return tasks.add(task);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Tasks so far:");
        ListIterator<Task> iterator = tasks.listIterator();
        while (iterator.hasNext()) {
            int index = iterator.nextIndex();
            Task task = iterator.next();
            output.append(String.format("\n%d.%s", (index + 1), task));
        }
        return output.toString();
    }
}