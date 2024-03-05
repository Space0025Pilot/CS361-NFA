package fa.nfa;

import java.util.LinkedHashSet;
import java.util.Set;

import fa.State;

public class NFA implements NFAInterface {

    /* Variables */
    public LinkedHashSet<NFAState> states;
    public LinkedHashSet<Character> sigma;
    public NFAState startState; // KEEP THIS UPDATED WHEN UPDATING STATES

    /**
     * @author Caitlyn
     * Constructor for an NFA
     */
    public NFA() {
        this.states = new LinkedHashSet<NFAState>();
        this.sigma = new LinkedHashSet<Character>();
        this.startState = null;
    }

    //Another possible constructor that takes in values(NOT SURE IF NEEDED)
    public NFA(NFAState start, LinkedHashSet<NFAState> states, LinkedHashSet<Character> sigma) {
        this.startState = start;
        this.states = states;
        this.sigma = sigma;
    }

    /**
     * @author //TODO
	 * Adds a a state to the FA instance
	 * @param name is the label of the state 
	 * @return true if a new state created successfully and false if there is already state with such name
	 */
    @Override
    public boolean addState(String name) {
        boolean response = false;

        if(states.size() == 0){
            response = true;
            NFAState newState = new NFAState(name);
            states.add(newState);
        } else {
            for(NFAState states : states){
                if(name.equals(states.getName())){
                    return false;
                }
            }
            response = true;
            NFAState newState = new NFAState(name);
            states.add(newState);
        }
        return response;
    }

    /**
     * @author Caitlyn
	 * Marks an existing state as an accepting state
	 * @param name is the label of the state
	 * @return true if successful and false if no state with such name exists
	 */
    @Override
    public boolean setFinal(String name) {
        boolean response = false;
        for(NFAState state : states){
            if(name.equals(state.getName())) { 
                response = true;
                state.finalState = true;
            }
        }
        return response;
    }

    /**
     * @author Caitlyn
	 * Adds the initial state to the FA instance
	 * @param name is the label of the start state
	 * @return true if successful and false if no state with such name exists
	 */
    //PLEASE CHECK THIS AGAIN
    @Override
    public boolean setStart(String name) {
        boolean response = false;
        for(NFAState state : states){
            if(name.equals(state.getName())) { 
                response = true;
                state.startState = true;
            }
        }
        return response;
    }

    /**
     * @author //TODO
	 * Adds a symbol to Sigma
	 * @param symbol to add to the alphabet set
	 */
    @Override
    public void addSigma(char symbol) {
        sigma.add(symbol);
    }

    /**
     * @author //TODO
	 * Simulates a FA on input s to determine
	 * whether the FA accepts s.
	 * @param s - the input string
	 * @return true if s in the language of the FA and false otherwise
	 */
    @Override
    public boolean accepts(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accepts'");
    }

    /**
     * @author Caitlyn
	 * Getter for Sigma
	 * @return the alphabet of FA
	 */
    @Override
    public Set<Character> getSigma() {
        return sigma;
    }

    /**
     * @author Caitlyn
	 * Returns state with the given name, or null if none exists
	 * @param name of a state
	 * @return state object or null
	 */
    @Override
    public State getState(String name) {
        NFAState choosenState = null;
        for(NFAState state : states){
            if(name.equals(state.getName())){
                choosenState = state;
            }
        }
        return choosenState;
    }

    /**
     * @author Caitlyn
	 * Determines if a state with a given name is final
	 * @param name the name of the state
	 * @return true if a state with that name exists and it is final
	 */
    @Override
    public boolean isFinal(String name) {
        boolean response = false;
        for(NFAState state : states){
            if(name.equals(state.getName()) && state.finalState == true){
                response = true;
            }
        }
        return response;
    }

    /**
     * @author Caitlyn
	 * Determines if a state with name is Start
	 * @param name the name of the state
	 * @return true if a state with that name exists and it is the start state
	 */
    @Override
    public boolean isStart(String name) {
        boolean response = false;
        for(NFAState state : states){
            if(name.equals(state.getName()) && state.startState == true){
                response = true;
            }
        }
        return response;
    }

    /**
     * @author //TODO
	 * Return delta entries
	 * @param from - the source state
	 * @param onSymb - the label of the transition
	 * @return a set of sink states
	 */
    @Override
    public Set<NFAState> getToState(NFAState from, char onSymb) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getToState'");
    }

    /**
     * @author //TODO
	 * Traverses all epsilon transitions and determine
	 * what states can be reached from s through e
	 * @param s
	 * @return set of states that can be reached from s on epsilon trans.
	 */
    @Override
    public Set<NFAState> eClosure(NFAState s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eClosure'");
    }

    /**
     * @author //TODO
	 * Determines the maximum number of NFA copies
	 * created when processing string s
	 * @param s - the input string
	 * @return - the maximum number of NFA copies created.
	 */
    @Override
    public int maxCopies(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maxCopies'");
    }

    /**
     * @author //TODO
	 * Adds the transition to the NFA's delta data structure
	 * @param fromState is the label of the state where the transition starts
	 * @param toStates is the set of labels of the states where the transition ends
	 * @param onSymb is the symbol from the NFA's alphabet.
	 * @return true if successful and false if one of the states don't exist or the symbol in not in the alphabet
	 */
    @Override
    public boolean addTransition(String fromState, Set<String> toStates, char onSymb) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTransition'");
    }

    /**
     * @author //TODO
	 * Determines if NFA is an instance of a DFA
	 * @return - true if NFA's transition function has DFA's properties.
	 */
    @Override
    public boolean isDFA() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isDFA'");
    }
    
}
