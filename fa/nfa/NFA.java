package fa.nfa;

import java.util.LinkedHashSet;
import java.util.Set;

public class NFA implements NFAInterface {

    /* Variables */
    private LinkedHashSet<NFAState> states;
    private LinkedHashSet<Character> sigma;
    public NFAState startState;

    /**
     * @author Caitlyn
     * Constructor for an NFA
     */
    public NFA() {
        this.states = new LinkedHashSet<NFAState>();
        this.sigma = new LinkedHashSet<Character>();
        this.startState = null;
    }

    /**
     * @author Caitlyn
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
    @Override
    public boolean setStart(String name) {
        boolean response = false;
        for (NFAState state : states) {
            if (name.equals(state.getName())) {
                response = true;
                state.startState = true;
                startState = state;
            }
        }
        for (NFAState state : states)
        {
            if (!state.getName().equals(name) && state.startState && (state != startState))
            {
                state.startState = false;
            }
        }
        return response;
    }

    /**
     * @author Caitlyn
	 * Adds a symbol to Sigma
	 * @param symbol to add to the alphabet set
	 */
    @Override
    public void addSigma(char symbol) {
        sigma.add(symbol);
    }

    /**
     * @author Olivia Hill
	 * Simulates a FA on input s to determine
	 * whether the FA accepts s.
	 * @param s - the input string
	 * @return true if s in the language of the FA and false otherwise
	 */
    @Override
    public boolean accepts(String s) {
        // Accepts if we have used all characters, machine is halted?, and in final state
        if (s.equals("e"))
        {
            s = "";
        }
        return acceptHelper(startState, s);
    }

    /*
    DR FROST!!! README DR FROST!!!
    I hope grading hasn't been too exhausting/boring. As you requested I am writing
    as to why I used depth first search here rather than breadth first search. To be
    completely candid, I did not realize I was supposed to use breadth first search.
    I'm not even sure I read the handout because I was just excited to code.
    I knew I wanted to use recursion because after thinking through what it would
    look like to implement iteratively I was disgusted. Like ew, absolutely not.
    Then I guess I just sort of free-styled from there thinking about what the base
    case would look like, and worked backwards from there. I think I landed on
    depth first search because I thought it was cooler/sleeker and harder to
    implement, which I thought sounded more fun to do and worth exploring to
    challenge myself.
    Writing it with breadth first search would have been more intuitive to code,
    and it was when I used breadth first search in maxCopies. And that's exactly
    how I would implement it for accepts as well.
    I hope this was an interesting insight into the thought process of a
    neurodivergent student.
    Happy grading!
    */

    /**
     * @author Olivia Hill
     * @param currState Current state recursively being looked at
     * @param s Input string
     * @return boolean true if NFA accepts String s
     */
    private boolean acceptHelper(NFAState currState, String s)
    {
        // FIXME catch statement warnings
        if (s.isEmpty())
        {
            return currState.finalState;
        }
        try
        {
            currState.transitions.get(s.charAt(0));
        } catch (IndexOutOfBoundsException ioobe)
        {
            return false;
        }

        try
        {
            for (NFAState state : currState.transitions.get(s.charAt(0))) // Each state we can travel to
            {
                if (acceptHelper(state, s.substring(1))) // If at any end we are in a final state
                {
                    return true;
                }
            }
        } catch (NullPointerException npe) {}

        try
        {
            for (NFAState state : currState.transitions.get('e')) // For each state we can get to on epsilon
            {
                if (acceptHelper(state, s)) // Call other state without using strings for epsilon transitions
                {
                    return true;
                }
            }
        } catch (NullPointerException npe) {}

        return false; // No paths past this state have returned an end in final state
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
    public NFAState getState(String name) {
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
            if(name.equals(state.getName()) && state.finalState){
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
            if(name.equals(state.getName()) && state.startState){
                response = true;
            }
        }
        return response;
    }

    /**
     * @author Caitlyn
	 * Return delta entries
	 * @param from - the source state
	 * @param onSymb - the label of the transition
	 * @return a set of sink states
	 */
    @Override
    public Set<NFAState> getToState(NFAState from, char onSymb) {
        Set<NFAState> set = new LinkedHashSet<>();                //PROBLEM SOLVED NOW THAT I WANT TO PULL MY HAIR OUT
        for(NFAState state: eClosure(from)) {                       // I am proud of you Caitlyn - Liv
            set.addAll(state.transitions.get(onSymb));
        }
        return set;
    }

    /**
     * @author Caitlyn
	 * Traverses all epsilon transitions and determine
	 * what states can be reached from s through e
	 * @param s
	 * @return set of states that can be reached from s on epsilon trans.
	 */
    @Override
    public Set<NFAState> eClosure(NFAState s) {
        Set<NFAState> set = new LinkedHashSet<>();
        set = eClosureHelper(set, s);
        return set;
        
    }

    /**
     * @author Caitlyn
	 * Traverses all epsilon transitions and determine
	 * what states can be reached from s through e
     * @param set
	 * @param s
	 * @return set of states that can be reached from s on epsilon trans.
	 */
    public Set<NFAState> eClosureHelper(Set<NFAState> set, NFAState s) {
        set.add(s);
        if(s.transitions.containsKey('e')){
            for(NFAState state : s.transitions.get('e')){
                set.add(state);
                eClosureHelper(set, state);
            }
        }
        return set;
    }

    /**
     * @author Olivia Hill
	 * Determines the maximum number of NFA copies
	 * created when processing string s
	 * @param s - the input string
	 * @return - the maximum number of NFA copies created.
	 */
    @Override
    public int maxCopies(String s) {
        if(startState == null)
        {
            return 0;
        }
        LinkedHashSet<NFAState> startSet = new LinkedHashSet<NFAState>();
        startSet.add(startState);
        for (NFAState state : eClosure(startState))
        {
            startSet.add(state);
        }
        return maxCopiesHelper(startSet, s);
    }

    private int maxCopiesHelper(LinkedHashSet<NFAState> stateSet, String s) // So many silly warnings
    {
        LinkedHashSet<NFAState> nextLevel = new LinkedHashSet<NFAState>();
        int levelCount = stateSet.size();

        for (NFAState state : stateSet)
        {
            try
            {
                for (NFAState toState : state.transitions.get(s.charAt(0)))
                {
                    nextLevel.addAll(eClosure(toState)); // Adds toState on symb and all states reachable by epsilon
                    // TODO: Make sure it doesn't all duplicates
                }
            } catch (NullPointerException npe) {}

        }
        int nextLevelCount = nextLevel.size();
        try
        {
            nextLevelCount = maxCopiesHelper(nextLevel, s.substring(1));
        } catch (IndexOutOfBoundsException ioobe) {}

        return (nextLevelCount > levelCount) ? nextLevelCount : levelCount; // This works right? I didn't know java did this
                                                                            // Yes it is the conditional/ternary operator! It's magic!! - C 
    }

    /**
     * @author Olivia Hill
	 * Adds the transition to the NFA's delta data structure
	 * @param fromState is the label of the state where the transition starts
	 * @param toStates is the set of labels of the states where the transition ends
	 * @param onSymb is the symbol from the NFA's alphabet.
	 * @return true if successful and false if one of the states don't exist or the symbol in not in the alphabet
	 */
    @Override
    public boolean addTransition(String fromState, Set<String> toStates, char onSymb) {
        // Validate sigma, fromState, and toStates
        if (!sigma.contains(onSymb) && (onSymb != 'e'))
        {
            return false;
        }
        NFAState statePtr = startState;
        boolean validFromState = false;
        for (String toState : toStates)
        {
            boolean isState = false;
            for (NFAState state : states)
            {
                if (state.getName().equals(toState))
                {
                    isState = true;
                }
                if (state.getName().equals(fromState))
                {
                    validFromState = true;
                    statePtr = state;  // Sets our ptr to the fromState state
                }
            }
            if (!isState || !validFromState)
            {
                return false;
            }
        }

        // Add States and onSymb to transition table of fromState
        if (statePtr.transitions.containsKey(onSymb)) // Key for transition on that symb already exists
        {
            for (String toState : toStates) // Each toState to be added
            {
                for (NFAState state : states)
                {
                    if (state.getName().equals(toState)) // Find State associated with String toState
                    {
                        statePtr.transitions.get(onSymb).add(state); // Will add state if not already present
                        break;
                    }
                    // TODO: Check for state in set that's not in our nfa? what to do if that happens...
                    // Put it up in a hotel and tell it to wait for security clearance! - C
                }
            }
        }
        else { // Transition on that symb doesn't already exist
            LinkedHashSet<NFAState> toStateSet = new LinkedHashSet<NFAState>();
            for (String toState : toStates) // For each toState
            {
                for (NFAState state : states)
                {
                    if (state.getName().equals(toState)) // Find equivalent NFAState
                    {
                        toStateSet.add(state);
                        break;
                    }
                    // TODO: Check for if toState isn't in our state set? ^
                }
            }
            statePtr.transitions.put(onSymb, toStateSet); // Add transitions
        }
        return true;
    }

    /**
     * @author Olivia Hill
	 * Determines if NFA is an instance of a DFA
	 * @return - true if NFA's transition function has DFA's properties.
	 */
    @Override
    public boolean isDFA() {
        // Has no epsilon transitions, and max of 1 toState per symbol
        for (NFAState state : states)
        {
            if (state.transitions.containsKey('e')) // If there are epsilon transitions
            {
                return false;
            }
            for (Character key : state.transitions.keySet()) // for every transition
            {
                if (state.transitions.get(key).size() > 1) // If there are transitions with multiple to states
                {
                    return false;
                }
            }
        }
        return true;
    }
}
