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

6. Add login and logout command. And del and save command require login first. Proxy and observer patterns are used.

  ```
  22:01:09$ get 101
  user not found.
  22:01:11$ del 101
  login required.
  22:01:13$ login
  logined.
  22:01:17$ del 101
  user not found.
  22:01:20$ add 101 bingoo
  added User{id='101', name='bingoo'}.
  22:01:24$ get 101
  got User{id='101', name='bingoo'}.
  22:01:27$ del 101
  deleted User{id='101', name='bingoo'}.
  22:01:37$ logout
  logouted.
  ```
6. Add arguments validator for add command. Decorator and responsibility chain  are used.

  ```
  00:01:48$ get 1001
  user not found.
  00:01:52$ add 1001 bingoo
  added User{id='1001', name='bingoo'}.
  00:01:54$ get 1001
  got User{id='1001', name='bingoo'}.
  00:01:57$ del 1001
  login required.
  00:02:00$ login
  logined.
  00:02:03$ del 1001
  deleted User{id='1001', name='bingoo'}.
  00:02:05$ get 1001
  user not found.
  00:02:08$ logout
  logouted.
  00:02:09$ del 1001
  login required.
  00:05:10$ add 101 bingoo
  error 101 has not fixed length .
  00:05:22$ add b001 bingoo
  error b001 is not a number.
  00:05:24$ add
  error two arguments are required.
  00:05:27$ add 1001
  error two arguments are required.
  ```