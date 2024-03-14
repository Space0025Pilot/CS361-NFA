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

Olivia Reflection




Write a brief (2-3 paragraph) reflection describing your experience with this
project. Answer the following questions (but feel free to add other insights):
- What worked well and what was a struggle?
- What concepts still aren't quite clear?
- What techniques did you use to make your code easy to debug and modify?
- What would you change about your design process?
- If you could go back in time, what would you tell yourself about doing this project?

## Compiling and Using

There isn't any user input required for this code. It is tested through the test cases.

## Sources used

None other than the instruction guide, java documentation, and the professor.
