# Other improvements and where to find them

## java.util.Function
 
* **Function<T, R>** take a _T_ as input, return an _R_ as ouput
* **Predicate\<T\>** take a _T_ as input, return a boolean as output
* **Consumer\<T\>** take a _T_ as input, perform some action and don't return anything
* **Supplier\<T\>** with nothing as input, return a _T_
* **BinaryOperator\<T\>** take two _T_'s as input, return one _T_ as output, useful for 
"reduce" operations

Primitive specializations for most of these exist as well. They're provided in int, long, 
and double forms. For instance:

* **IntConsumer** take an int as input, perform some action and don't return anything

## java.util.Optional

Similar to Guava's **Optional\<T\>**

It provides a fluent API for handling the "some result" versus "no result" cases. 
You can provide a default value, throw an exception, or execute some action only if the 
result exists.

## Generic type inference improvements

In Java 7:

```java
foo(Utility.<Type>bar());
Utility.<Type>foo().bar();
```

In Java 8:

```java
foo(Utility.bar());
Utility.foo().bar();
```

## java.time rewritten

Similar to Joda Time.

Almost everything in the API is immutable, including the value types and the formatters. 
No more worrying about exposing Date fields or dealing with thread-local date formatters.

## java.collections additions

Some methods added leveraging lambdas. In particular to Map, for example:

* **Map.computeIfAbsent(K, Function)**
* **Map.replaceAll(BiFunction)**

## java.concurrency additions

**CompletableFuture\<T\>** is a nice implementation of the Future interface that provides 
a ton of methods for performing (and chaining together) asynchronous tasks. 
If you are currently using Guava's Future utilities, such as `Futures`, `ListenableFuture`, 
and `SettableFuture`, check it out.

## IO/NIO Apis

Methods added to get java.util.stream.Stream from files and InputStreams. They're a bit 
different from the streams you obtain from regular collections though:

* They may throw UncheckedIOException (workaround to avoid adding IOException to streams 
interface)
* For some you'll need to call stream.close() (or use AutoClosable from Java 7)

## Even more stuff!

* Annotations are allowed in more places, e.g. `List<@Email String>`
* Nashorn JavaScript Engine
* Better way to create ThreadLocals with initial values
* `StringJoiner` and `String.join(...)`