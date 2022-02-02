package by.kuzmich.taskwizard.exception;

/* explanation of exceptions usage in project:
 * interactions with user are built as receiving numbers from user according to menu
 * these numbers apply to next actions.
 *
 * Potential exceptions include three scenarios:
 * - entering char or empty String "" instead of number
 * - entering the number which doesn't apply to menu
 *
 * method @receiveAnswerNumberFromUser is used to catch exceptions
 * from the first scenario. They belong to class NumberFormatException which inherits
 * RuntimeException
 *
 * class IncorrectInputExceptions is introduced to catch the second scenario exceptions.
 * It extends Exception and due to that extension it is required to handle this exception
 * when we receive user inputs to parse them.
 */

public class IncorrectInputException extends Exception {

    public IncorrectInputException() {
        super("Incorrect input");
    }

    public IncorrectInputException(String message) {
        super(message);
    }
}
