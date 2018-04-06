package IntroductionToJavaProgramming.chapter24_developingEfficientAlgorithm;

public class CommonRecurrenceRelations {

    /**
     *  Common Recurrence Relations
     *
     *  Recurrence Relation are a useful tool for analyzing algorithm complexity.
     *
     *  And Here a summarizes of the common recurrence relations.
     *
     *  ___________________________________________________________________________
     *  Recurrence Relation              Result                           Example
     *  ---------------------------------------------------------------------------
     *  T(n) = T(n/2) + O(1)        T(n) = O(logn)      Binary search, Euclid's GCD
     *
     *  T(n) = T(n - 1) + O(1)      T(n) = O(n)         Linear search
     *
     *  T(n) = 2T(n/2) + O(1)       T(n) = O(n)         Checkpoint Question 24.20
     *
     *  T(n) = 2T(n/2) + O(n)       T(n) = O(n logn)    Merge sort (Chapter 25)
     *
     *  T(n) = T(n - 1) + O(n)      T(n) = O(2^n)       Selection sort, insertion sort
     *
     *  T(n) = 2T(n - 1) + O(1)     T(n) = O(2^n)       Tower of Hanoi
     *
     *  T(n) = T(n-1) + T(n-2) + O(1)   T(n) = O(2^n)   Recursive Fibonacci algorithm
     *
     */
}
