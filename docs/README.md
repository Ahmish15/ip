# chatbot User Guide

**chatbot** is a simple, interactive command-line application that helps you manage tasks of various types. Whether you need to note down a quick to-do, track an upcoming deadline, or schedule an event, chatbot lets you create and organize tasks easily. You can also mark tasks as done, delete them, list all current tasks, and even search through them by keyword. The chatbot automatically saves your tasks, so they’re always available when you start it again.


## Adding deadlines
When you add a Deadline, you specify a description and a deadline time as a string.  
This helps you keep track of tasks that have a specific due date.

Example: `deadline return book /by tomorrow`

Expected output:
~~~
Got it. I've added this task:
  [D][ ] return book (by: tomorrow)
Now you have X tasks in the list.
~~~

## Feature: Add a Todo
Use this command to add a basic to-do item without any date/time.

Example: `todo read book`

Expected output:
~~~
Got it. I've added this task:
  [T][ ] read book
Now you have X tasks in the list.
~~~

## Feature: Add an Event
Use this command to add an event with a start and end time/place.

Example: `event meeting /from Monday /to Tuesday`

Expected output:
~~~
Got it. I've added this task:
  [E][ ] meeting (from: Monday to: Tuesday)
Now you have X tasks in the list.
~~~

## Feature: Mark a Task
Marks a specified task (by its number) as done.

Example: `mark 1`

Expected output:
~~~
Nice! I've marked this task as done:
  [T][X] read book
~~~

## Feature: Unmark a Task
Unmarks a specified task (by its number) as not done.

Example: `unmark 1`

Expected output:
~~~
OK, I've marked this task as not done yet:
  [T][ ] read book
~~~

## Feature: Delete a Task
Removes a specified task (by its number) from your list.

Example: `delete 1`

Expected output:
~~~
Noted. I've removed this task:
  [T][ ] read book
Now you have X tasks in the list.
~~~

## Feature: List Tasks
Displays all tasks currently in your list, in order of creation.

Example: `list`

Expected output:
~~~
Here are the tasks in your list:
1.[T][ ] read book
2.[D][ ] return book (by: tomorrow)
3.[E][ ] meeting (from: Monday to: Tuesday)
~~~

## Feature: Find Tasks
Searches all tasks for a keyword in their description and displays the matches.

Example: `find book`

Expected output:
~~~
Here are the matching tasks in your list:
1.[T][ ] read book
2.[D][ ] return book (by: tomorrow)
~~~