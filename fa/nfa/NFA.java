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
     * @author TODO
	 * Adds a a state to the FA instance
	 * @param name is the label of the state 
	 * @return true if a new state created successfully and false if there is already state with such name
	 */
    @Override
    public boolean addState(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addState'");
    }

    @Override
    public boolean setFinal(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFinal'");
    }

    @Override
    public boolean setStart(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStart'");
    }

    @Override
    public void addSigma(char symbol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addSigma'");
    }

    @Override
    public boolean accepts(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accepts'");
    }

    @Override
    public Set<Character> getSigma() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSigma'");
    }

    @Override
    public State getState(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getState'");
    }

    @Override
    public boolean isFinal(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isFinal'");
    }

    @Override
    public boolean isStart(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isStart'");
    }

    @Override
    public Set<NFAState> getToState(NFAState from, char onSymb) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getToState'");
    }

    @Override
    public Set<NFAState> eClosure(NFAState s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eClosure'");
    }

    @Override
    public int maxCopies(String s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maxCopies'");
    }

    @Override
    public boolean addTransition(String fromState, Set<String> toStates, char onSymb) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTransition'");
    }

    @Override
    public boolean isDFA() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isDFA'");
    }
    
}
