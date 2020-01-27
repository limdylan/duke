package duke.command.method;

import duke.Duke;
import duke.command.Command;
import duke.exception.DukeException;
import duke.storage.Storage;

public class SaveCommandMethod implements CommandMethod {
    public static final String NAME = "save";

    public String execute(Duke program, Command command) throws DukeException {
        Storage storage = program.getStorage();
        storage.saveTaskList(program.getTaskList());
        return "Saved tasks to file on hard disk";
    }
}