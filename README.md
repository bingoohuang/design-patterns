design-patterns
===============

a command line program of user managerment practise for design patterns.

1. Initial code.

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

3. Refactoring with factory method pattern. Every command will have a special parser (concrete factory) to create it (product).

  ```
  21:14:22$ add 1001 bingoo
  added User{id='1001', name='bingoo'}.
  21:14:29$ get 1001
  got User{id='1001', name='bingoo'}.
  21:14:34$ del 1001
  deleted User{id='1001', name='bingoo'}.
  21:14:43$ del 1002
  user not found.
  21:14:45$ get 1002
  user not found.
  ```

4. Add save command to save to file with format of plain text or xml. Strategy and template method are used.

  ```
  22:16:46$ add 101 bingo
  added User{id='101', name='bingo'}.
  22:16:48$ add 102 dingoo
  added User{id='102', name='dingoo'}.
  22:16:50$ save xml
  saved.
  22:17:37$ save txt
  saved.
  ```

5. Refactoring the code. Singleton and interpreter patterns are used.