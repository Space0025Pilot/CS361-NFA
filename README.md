# Project 2: Non-Deterministic Finite Automata

* Author: Caitlyn Nelson and Olivia Hill
* Class: CS361 Section 2
* Semester: Spring 2024

## Overview

The program models and implements a non-deterministic finite automata, an NFA.

## Reflection

Caitlyn Reflection
We started earlier and so this benefited us in allowing for more time to work together and designate the work out more proportionally. I felt that this project went more smoothly than the first one. I think with this one I had a better understanding of what I was doing since the completed DFA project. I found that our understandings of how to complete certain methods were better or worse than each other so we grabbed the methods that made the most sense to us. For example, I did the eclosure and the getToState methods as I felt my understanding of eclosure was very solid. I did have some trouble with the eclosure when figuring out how to maintain or wipe the set depending on when you are calling the eclosure. I was able to solve this by using the helper method below eclosure so that it wouldn't clear the set each time eclosure was called. 

To debug the code, I heavily rely on my debugger to figure out what is going wrong and then I utilize the breakpoint and step through the function which then allows me to more clearly see what the problem is and then I can gather a method on how to fix it. This went fairly smoothly and I had to get mine working as my partners functions relied on mine working correctly for counting how many copies of the machine were created. Overall, our design process this time was on point and we wrote some psuedocode before we started coding which made a world of difference at least for me when it came to programming the assignment. If I could go back in time, I would tell myself keep it simple stupid.

Olivia's Reflection

This time around we had an extended meeting to ensure we were on the same page about the 
entire project and laid everything out clearly before dividing work and getting started
which I think really worked well for us this time around. For me the accepts and maxCopies
methods were a bit of struggle to write as they were more involved and intricate. The accepts
method wasn't too bad after I decided how I wanted to do it and brainstormed on a white
board. The maxCopies was a bit more difficult because I had to transition from thinking in
a depth first search way to a breadth first search way. After I realized how I had to do it,
I was able to lay out something and debug it until it was working well. It took a lot of
brain power but was really rewarding when I finished. 

I feel pretty clear on all the concepts, although when writing our the isDFA method I 
started to wonder the exact conditions that mean the machine has halted or not. For me
that seems the same as running out of string characters... My brainstorming and pseudocode
did make things a lot easier to write and because it was well-structured it was easier 
to debug. I don't think I would change anything about the design process, I think we
changed things after the first project that made this one smoother. I would tell myself
that I was supposed to use breadth first search even tho depth first search was fun haha. 


## Compiling and Using

There isn't any user input required for this code. It is tested through the test cases.

## Sources used

None other than the instruction guide, java documentation, and the professor.
