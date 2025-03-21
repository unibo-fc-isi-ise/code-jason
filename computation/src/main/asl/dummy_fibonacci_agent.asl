/* Initial beliefs and rules */
fib(0, 1).
fib(1, 1).
fib(X, Y) :-
    fib(X - 1, Y1) &
    fib(X - 2, Y2) &
    Y = Y1 + Y2 .

/* Initial goals */
!compute_fibonacci_until(0, 100).

/* Plans */

+!compute_fibonacci_until(N, N) <- 
    !compute_fibonacci(N);
    .print("Done") .

+!compute_fibonacci_until(N, M) : N < M <- 
    !compute_fibonacci(N);
    !compute_fibonacci_until(N + 1, M).
    
+!compute_fibonacci(N) <-
    ?fib(N, Y);
    .print("fib(", N, ") = ", Y).
