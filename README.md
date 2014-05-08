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
6. Add arguments validator for add command. Decorator and responsibility chain are used.

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

7. Add list and clone commands. Clone and builder patterns are used.

  ```
  08:47:30$ list
  zero users found.
  08:47:52$ add 1001 bingoo 35 18551855099 nj
  added User{id='1001', name='bingoo', age=35, phone='18551855099', address='nj'}.
  08:47:54$ list
  1 users found:
  User{id='1001', name='bingoo', age=35, phone='18551855099', address='nj'}.
  08:48:01$ clone 1001 1002 dingoo
  cloned User{id='1002', name='dingoo', age=35, phone='18551855099', address='nj'}.
  08:48:03$ list
  2 users found:
  User{id='1001', name='bingoo', age=35, phone='18551855099', address='nj'}
  User{id='1002', name='dingoo', age=35, phone='18551855099', address='nj'}.
  08:48:25$ get 1001
  got User{id='1001', name='bingoo', age=35, phone='18551855099', address='nj'}.
  ```

8. Command history can be recorded in memory or file. Bridge and adapter patterns are used.
  ```
  11:20:20$ record file
  record on.
  11:20:30$ add 1001 bingoo 35 18551855099 nj
  added User{id='1001', name='bingoo', age=35, phone='18551855099', address='nj'}.
  11:20:37$ clone 1001 1002 dingoo
  cloned User{id='1002', name='dingoo', age=35, phone='18551855099', address='nj'}.
  11:20:42$ login
  logined.
  11:20:51$ clone 1001 1003 pingoo
  cloned User{id='1003', name='pingoo', age=35, phone='18551855099', address='nj'}.
  11:20:57$ del 1001
  deleted User{id='1001', name='bingoo', age=35, phone='18551855099', address='nj'}.
  11:21:00$ list
  2 users found:
  User{id='1002', name='dingoo', age=35, phone='18551855099', address='nj'}
  User{id='1003', name='pingoo', age=35, phone='18551855099', address='nj'}.
  11:21:02$ history
  11:20:20$ record file
  record on.
  11:20:30$ add 1001 bingoo 35 18551855099 nj
  added User{id='1001', name='bingoo', age=35, phone='18551855099', address='nj'}.
  11:20:37$ clone 1001 1002 dingoo
  cloned User{id='1002', name='dingoo', age=35, phone='18551855099', address='nj'}.
  11:20:42$ login
  logined.
  11:20:51$ clone 1001 1003 pingoo
  cloned User{id='1003', name='pingoo', age=35, phone='18551855099', address='nj'}.
  11:20:57$ del 1001
  deleted User{id='1001', name='bingoo', age=35, phone='18551855099', address='nj'}.
  11:21:00$ list
  2 users found:
  User{id='1002', name='dingoo', age=35, phone='18551855099', address='nj'}
  User{id='1003', name='pingoo', age=35, phone='18551855099', address='nj'}.
  ```

9. Add manager and staffs of an user. Composite(hierarchy) and flyweight (city) patterns are used.

  ```
  17:20:07$ add 1001 bingoo 35 18551855099 nj
  added User{id='1001', name='bingoo', age=35, phone='18551855099', city='nj', salary='0'}.
  17:20:19$ add 1002 dingoo 36 18551855099 bj
  added User{id='1002', name='dingoo', age=36, phone='18551855099', city='bj', salary='0'}.
  17:21:17$ manage 1001 1002
  1001 began to manage 1002.
  17:21:45$ add 1003 pingoo 37 18551855099 tj
  added User{id='1003', name='pingoo', age=37, phone='18551855099', city='tj', salary='0'}.
  17:22:24$ manage 1001 1003
  1001 began to manage 1003.
  17:22:32$ addsalary 9999
  error:1.
  17:23:51$ addsalary 1001 9999
  salary of1001 and all its staff has been added by9999.
  17:24:01$ list
  3 users found:
  User{id='1001', name='bingoo', age=35, phone='18551855099', city='nj', salary='9999'}
  User{id='1002', name='dingoo', age=36, phone='18551855099', city='bj', salary='9999'}
  User{id='1003', name='pingoo', age=37, phone='18551855099', city='tj', salary='9999'}.
  17:24:17$ addsalary 1002 1000
  salary of1002 and all its staff has been added by1000.
  17:24:20$ list
  3 users found:
  User{id='1001', name='bingoo', age=35, phone='18551855099', city='nj', salary='9999'}
  User{id='1002', name='dingoo', age=36, phone='18551855099', city='bj', salary='10999'}
  User{id='1003', name='pingoo', age=37, phone='18551855099', city='tj', salary='9999'}.
  ```