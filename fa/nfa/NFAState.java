package fa.nfa;

import java.util.Hashtable;

import fa.State;

public class NFAState extends State {

    /* Variables */
    public Hashtable<String, String[]> transitions;
    boolean startState;
    boolean finalState;

    /**
     * @author Caitlyn
     * NFA State constructor that calls the super implementation to set the name
     * @param name
     */
    public NFAState(String name){
        super.State(name);
        this.transitions = new Hashtable<String, String[]>();
        this.startState = false;
        this.finalState = false;
    }
    
}
