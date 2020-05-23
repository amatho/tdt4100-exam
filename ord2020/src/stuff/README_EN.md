# Small stuff

This part consists of small, independent tasks that tests specific skills.

## String handling

**[Joiner](Joiner.java)**

This class helps with formatting lists of the kind "one, two and three". The points is that there are two ways to separate elements,
one that is used between all but the last two elements, and one that is used between the last two. The separators (mainSeparator and lastSeparator) and can be equal, as in the example "one, two, three, four".

- Write the methods that are missing in the **Joiner** class.

## Testing

**[Summer](Summer.java)** and **[SummerTest](SummerTest.java)**

The **Summer** class contains three methods with code that works in some cases, (among other, those that are tested using existing test methods in **SummerTest**), men fails in others. The task is to augment the **SummerTest** class with extra methods that reveal those errors in an appropriate way. Note that you shall not fix the code, only write the tests.

- Write necessary methods in the **SummerTest** class.

**[MedianComputer](MedianComputer.java)** and **[MedianComputerTest](MedianComputerTest.java)**

The following figure from [Wikipedia](https://en.wikipedia.org/wiki/Median) describes the computation of the median of a collection of numbers.

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Finding_the_median.png/2560px-Finding_the_median.png" width="300"/>

- Declare a **compute** method in the **MedianComputer** class that is suitable for the purpose of computing the median.

- Write one or more test methods in the **MedianComputerTest** class that tests that the **compute** method works as expected, and in a way that reveals possible mistakes.

You need the declaration of **compute** to be able to write the tests, but you do *not* need to implement it, just write enough code for it to compile. If you do implement it, e.g. to run the test class, we will not assess it, just the declaration and the test logic. Note the need for rounding in AssertEquals, see example in the code.
