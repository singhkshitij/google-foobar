/*

Keeping track of Commander Lambda's many bunny prisoners is starting to get tricky. You've been tasked with writing a program to match bunny prisoner IDs to cell locations.

The LAMBCHOP doomsday device takes up much of the interior of Commander Lambda's space station, and as a result the prison blocks have an unusual layout. They are stacked in a triangular shape, and the bunny prisoners are given numerical IDs starting from the corner, as follows:

| 7
| 4 8
| 2 5 9
| 1 3 6 10

Each cell can be represented as points (x, y), with x being the distance from the vertical wall, and y being the height from the ground. 

For example, the bunny prisoner at (1, 1) has ID 1, the bunny prisoner at (3, 2) has ID 9, and the bunny prisoner at (2,3) has ID 8. This pattern of numbering continues indefinitely (Commander Lambda has been taking a LOT of prisoners). 

Write a function solution(x, y) which returns the prisoner ID of the bunny at location (x, y). Each value of x and y will be at least 1 and no greater than 100,000. Since the prisoner ID can be very large, return your solution as a string representation of the number.

Test cases
==========
Your code should pass the following test cases.
Note that it may also be run against hidden test cases not shown here.

-- Java cases --
Input:
Solution.solution(3, 2)
Output:
    9

Input:
Solution.solution(5, 10)
Output:
    96


==== Solution =====


So, what they have given here is a number sequence. So if you do some work on this
| 7   12  18   25
| 4    8   13   19
| 2    5    9    14
| 1    3    6    10

You’d get a 2D array.

Now if you take the first slice of it, I get 1,2,4,7 – This can be formulated for [n (n-1) / 2] + 1 where n is the place of the number starting with 1.

Let’s take the second slice, 3,5,8,12 – This also can be formulated to [(n+1)(n) / 2] + 2 again where n is the place of the number starting with 1.

If you see both of the above formulas, there is a pattern, where the counts related to “n” is getting increased by one with the last constant we add. To make our observation on this pattern is correct, let’s analyze the third slice, 6,9,13,18 – and that can be formulated for [(n+2)(n+1) / 2] + 3 where n starts with 1. So we can come to the conclusion that the observed pattern is the one we are looking for.

With this we can get a general formula for the 2D array as below

{[(x + [n – 1])] [([x – 1] + [n – 1])]} / 2 + x

if we normalize this

[(x + n – 1)(x + n – 2)] / 2 + x

Here x is the horizontal position of an element and n is the vertical one, both start from 1. Also we can say n as y since they have mentioned it as y in the problem.

Finally,

[(x + y – 1)(x + y – 2)] / 2 + x

*/


public class Solution {
    public static String solution(long x, long y) {
        return Long.toString(((x+y-1)*(x+y-2))/2 + x);
    }
}
