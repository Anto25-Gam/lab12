package it.unibo.es2;

/**
 * Interface defining the logic for a slot-based application.
 */
public interface Logics {

    /**
     * Set the label on buttons.
     * 
     * @param position button pressed
     * @return the correct label
     */
    String getLabel(Pair<Integer, Integer> position);

    /**
     * Condition to quit the app.
     *
     * @param position of button pressed to check if cause quit
     * @return if the condition is verified
     */
    boolean toQuit(Pair<Integer, Integer> position);

}
