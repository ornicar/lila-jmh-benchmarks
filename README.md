lichess micro benchmarks

# Howto

```
sbt
jmh:run -i 3 -wi 2 AnyValTest
```

Where AnyValTest is a custom benchmark defined in src/main/scala/AnyValTest.scala

Add your own benchmarks there. There's a couple examples already. 
Don't loop, the framework does it for you.

To get the list of options:

```
jmh:run -h
```
