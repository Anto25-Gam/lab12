package it.unibo.es3;

import java.util.List;

/**
 * Interface defining the logic of slot-based aplication.
 */
public interface Logics {

    /**
     * Calculate three random position to init. 
     * 
     * @return list of random position
     */
    List<Integer> randomPos();

    /**
     * Expand around the slot whit the "*".
     * 
     * @return list whit the new expanded slot
     */
    List<Integer> expand(); 

    /**
     * Verify the condition, return false if all slots are "*".
     * 
     * @return result of condition
     */
    boolean toQuit();
}
