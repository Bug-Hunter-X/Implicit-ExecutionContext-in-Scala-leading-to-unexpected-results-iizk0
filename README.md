# Implicit ExecutionContext Bug in Scala

This repository demonstrates a subtle bug related to the use of implicit `ExecutionContext` in Scala. The improper use of implicit execution contexts can lead to unexpected behavior, especially in concurrent applications.

## Bug Description
The primary issue lies in the usage of an implicit `ExecutionContext` without explicit control or management. This can lead to unexpected thread pool exhaustion or resource conflicts if not handled appropriately.

## Solution
The solution involves explicitly defining and managing the `ExecutionContext`, ensuring that it's properly configured and resources are appropriately managed. This includes defining the ExecutionContext with a thread pool size. The example below includes this and some error handling.

## How to reproduce the bug
1. Clone this repository.
2. Compile and run `bug.scala`.
3. Observe the output and potential problems.