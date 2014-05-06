design-patterns
===============

a command line program of user managerment practise for design patterns

1. Initial code.

run com.github.bingoohuang.designpatterns.MainFrame.main

```
14:42:54$ add 1001 bingoo
added User{id='1001', name='bingoo'}.
14:42:56$ get 1001
got User{id='1001', name='bingoo'}.
14:42:59$ get 1002
user not found.
14:43:01$ del 1001
command unknown.
```

2. Add delete command to remove existed user. Here we use command pattern to encapsulate all the information needed to be executed later.

```
19:21:46$ add 1001 bingoo
added User{id='1001', name='bingoo'}.
19:21:49$ get 1001
got User{id='1001', name='bingoo'}.
19:21:52$ get 1002
user not found.
19:21:56$ bad xxx
command unknown.
19:21:59$ del 1001
deleted User{id='1001', name='bingoo'}.
19:22:01$ get 1001
user not found.

```
