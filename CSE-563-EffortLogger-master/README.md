# EffortLogger - Prototype
EffortLogger is a prototype application designed to help users manage their tasks and log the effort hours spent on each task. The application features a simple user interface, CRUD operations for tasks, and a Gantt chart visualization of the tasks.

#### Team Member Names:
1.	Saurav Sarkar
2. 	Purushothama Shanthappa
3. 	Praneeth Kumar Reddy Kotha
4. 	Keerthi Pendyala

#### Running the EffortLogger Locally
To run the EffortLogger application locally, follow the steps below:

- Ensure you have the Java Development Kit (JDK) installed on your computer. If not, download and install the JDK from the official Oracle website.
- Download the source code for the EffortLogger project from the drive.
- Run the java program
- The login window will appear. Use the following credentials to log in:

```makefile
Username: abc
Password: 123
```
    Once you've logged in, you can start using the EffortLogger application to manage your tasks and log effort hours. Remember that this is a prototype, so any data you enter will not be persisted after the application is closed.


### Design Goals
The primary design goals for the EffortLogger prototype were:

Create a simple and intuitive user interface for managing tasks.
Implement basic CRUD operations for tasks, including adding, updating, and deleting tasks.
Integrate the effort hours logging feature to track the amount of time spent on tasks.
Visualize tasks using a Gantt chart to help users understand the time allocation for each task.
Results and Testing
The results of the prototype testing demonstrate that the design goals have been satisfied. Below is a summary of the testing results for each design goal.

#### Design Goal 1: Simple and Intuitive User Interface
The EffortLogger prototype provides a clean and straightforward interface that allows users to easily manage their tasks. During testing, users found it easy to navigate through the application and quickly understood how to add, update, and delete tasks.

#### Design Goal 2: CRUD Operations for Tasks
The prototype successfully implements CRUD operations for tasks using an in-memory database. Users can create, update, and delete tasks without any issues. The testing confirmed that the application handles task operations correctly, reflecting the changes in the task list display immediately.

#### Design Goal 3: Effort Hours Logging
The effort hours logging feature was implemented and tested successfully. Users can input the effort hours for each task, and the application stores the hours accordingly. The task list display also shows the effort hours, allowing users to have an overview of the time spent on each task.

#### Design Goal 4: Gantt Chart Visualization
The Gantt chart integration using the JFreeChart library was successful, and users can visualize their tasks in a Gantt chart format. The chart provides a clear representation of the tasks and their effort hours. During testing, users found the Gantt chart visualization helpful for understanding the time allocation for each task.

### Conclusion
The EffortLogger prototype satisfies its design goals and provides a simple and effective solution for managing tasks and logging effort hours. The application's user interface is easy to use, and the features have been tested and verified to work correctly. The Gantt chart visualization offers a helpful visual representation of the tasks, allowing users to better understand the time allocation for each task. The prototype demonstrates the potential for further development and improvement, such as adding more advanced features and refining the user interface.