/* This class represents a person.
 *
 * Author: Keerthi Pendyala
 * Date: March 26, 2023
 */
package org.example;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<Integer, Task> tasks;
    private int nextId;

    /**
     * Initializes an empty task list with the next available ID set to 1.
     */
    public TaskService() {
        tasks = new HashMap<>();
        nextId = 1;
    }

    /**
     * Returns the ID that will be assigned to the next task created by this service.
     *
     * @return The next available task ID.
     */
    public int getNextId() {
        return nextId;
    }

    /**
     * Creates a new task with the given title, description, and effort hours, assigns it a unique ID, and adds it to the task list.
     *
     * @param title       The title of the new task.
     * @param description The description of the new task.
     * @param effortHours The estimated effort in hours required to complete the new task.
     * @return The newly created task object.
     */
    public Task createTask(String title, String description, double effortHours) {
        Task task = new Task(nextId++, title, description, effortHours);
        tasks.put(task.getId(), task);
        return task;
    }

    /**
     * Retrieves the task with the given ID from the task list.
     *
     * @param id The ID of the task to retrieve.
     * @return The task object with the given ID, or null if no such task exists.
     */
    public Task getTask(int id) {
        return tasks.get(id);
    }

    /**
     * Updates the details of the task with the given ID.
     *
     * @param id          The ID of the task to update.
     * @param title       The new title for the task.
     * @param description The new description for the task.
     * @param effortHours The new estimated effort in hours required to complete the task.
     */
    public void updateTask(int id, String title, String description, double effortHours) {
        Task task = tasks.get(id);
        if (task != null) {
            task.setTitle(title);
            task.setDescription(description);
            task.setEffortHours(effortHours);
        }
    }

    /**
     * Returns the entire task list maintained by this service.
     *
     * @return A map of task IDs to task objects.
     */
    public Map<Integer, Task> getTasks() {
        return tasks;
    }

    /**
     * Replaces the current task list with a new one.
     *
     * @param tasks The new task list to use.
     */
    public void setTasks(Map<Integer, Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Deletes the task with the given ID from the task list.
     *
     * @param id The ID of the task to delete.
     */
    public void deleteTask(int id) {
        tasks.remove(id);
    }
}
