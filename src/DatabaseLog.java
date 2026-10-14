/*
 * Name: Christina Kim Tran
 * SID:  200349533
 */

/**
 *
 *
 * @author Christina Kim Tran
 * @since 10/6/26
 */

public class DatabaseLog {

    private static final String SEPARATOR = " - ";
    private static final int NAME_INDEX = 2;
    private static final int TIMESTAMP_INDEX = 3;
    private static final String TIMESTAMP_SEPARATOR = "[-_:]";

    private MyStack log;

    /**
     * Initializes the private instance variable log with
     * a new MyStack object with the given capacity.
     * @param capacity The stack capacity
     */
    public DatabaseLog(int capacity) {
        log = new MyStack(capacity);
    }

    /**
     * Initializes the private instance variable log with
     * a new MyStack object with the default capacity.
     */
    public DatabaseLog() {
        log = new MyStack();
    }

    /**
     * Takes in and pushes a log entry String.
     * @param logEntry String to push
     */
    public void addLog(String logEntry) {
        log.push(logEntry);
    }

    /**
     * Peeks at the top log entry
     * @return The top log entry as a String
     */
    public String viewLog() {
        return log.peek();
    }

    /**
     * Pops the top log entry of the Stack
     * @return THe top log entry as a String
     */
    public String removeLog() {
        return log.pop();
    }

    /**
     * Returns the LogID of the inputted log entry String.
     * @param logEntry String log entry
     * @return String of the given log entry's LogID
     */
    public String getLogID(String logEntry) {
        return logEntry.split(SEPARATOR)[0];
    }

    /**
     * Returns the Action in a given log entry String
     * @param logEntry String, the log entry
     * @return the Action in a given log entry String
     */
    public String getAction(String logEntry) {
        return logEntry.split(SEPARATOR)[1];
    }

    /**
     * Returns the name from the given log entry String.
     * @param logEntry String, the log entry
     * @return the name in an inputted log entry String
     */
    public String getName(String logEntry) {
        return logEntry.split(SEPARATOR)[NAME_INDEX];
    }

    /**
     * Returns a String array of the month, date, year, hour,
     * and minute from an inputted log entry String.
     * @param logEntry String, the log entry
     * @return a String array of the log entry's month, date,
     * year, hour, and minute, in that order.
     */
    public String[] getTimestamp(String logEntry) {
        String timestamp = logEntry.split(SEPARATOR)[TIMESTAMP_INDEX];
        return timestamp.split(TIMESTAMP_SEPARATOR);
    }

    /**
     * Returns a single String summarizing a log entry
     * over four lines, with one field per line.
     * @param logEntry String log entry
     * @return a String summarizer of the separate log entry fields
     */
    public String summarizeLog(String logEntry) {
        String[] fields = logEntry.split(SEPARATOR);
        return "ID: " + fields[0] + "\n"
                + "ACTION: " + fields[1] + "\n"
                + "NAME: " + fields[NAME_INDEX] + "\n"
                + "TIMESTAMP: " + fields[TIMESTAMP_INDEX];
    }

    /**
     * Returns a String array with up to the (count) most
     * recent log entries, starting with the most recent.
     * The returned log entries are removed, and if the count
     * is more than the amount of log entries, all the log
     * entries should be returned.
     * @param count The inputted count of log entries
     * @return a String array with the most recent log
     * entries up to the count.
     */
    public String[] getRecentLogs(int count) {
        if (count < 1 || log.isEmpty()) {
            return new String[0];
        }
        return log.multiPop(count);
    }

    /**
     * Returns a String array with all the log entries
     * associated with the given name.
     * @param name The given name
     * @return a String array containing the log entries
     * associated with the name inputted, with the most recent
     * match appearing at the front of the output array.
     */
    public String[] getLogsForStudent(String name) {
        if (log.isEmpty()) {
            return new String[0];
        }
        String[] all = log.multiPop(log.size());
        int match = 0;
        for (String entry : all) {
            if (getName(entry).equals(name)) {
                match++;
            }
        }
        String[] output = new String[match];
        int next = 0;
        for (String entry : all) {
            if (getName(entry).equals(name)) {
                output[next] = entry;
                next++;
            }
        }
        return output;
    }
}
