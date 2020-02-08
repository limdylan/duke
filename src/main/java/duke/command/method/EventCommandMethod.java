package duke.command.method;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import duke.Duke;
import duke.command.Command;
import duke.exception.DukeException;
import duke.exception.DukeInvalidDateTimeException;
import duke.exception.DukeInvalidNumberOfArgumentsException;
import duke.exception.DukeNoArgumentsException;
import duke.storage.Storage;
import duke.task.EventTask;

public class EventCommandMethod implements CommandMethod {
    public static final String NAME = "event";

    public void execute(Command command) throws DukeException {
        Duke program = Duke.getProgram();
        if (command.getArgumentList().length == 0) {
            throw new DukeNoArgumentsException(EventCommandMethod.NAME);
        }
        String[] arguments = command.getArgumentString().split(" /at ", 2);
        if (arguments.length != 2) {
            throw new DukeInvalidNumberOfArgumentsException(
                    EventCommandMethod.NAME, 2, arguments.length);
        }
        String description = arguments[0];
        try {
            LocalDateTime at = LocalDateTime.parse(arguments[1],
                    EventTask.DATE_TIME_INPUT_FORMAT);
            EventTask newTask = new EventTask(description, at);
            String message = program.getTaskList().addTask(newTask);
            program.getUi().print(message);
            Storage storage = program.getStorage();
            storage.saveTaskList(program.getTaskList());
        } catch (DateTimeParseException e) {
            throw new DukeInvalidDateTimeException(arguments[1]);
        }
    }
}
