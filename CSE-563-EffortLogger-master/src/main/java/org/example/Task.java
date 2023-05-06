/* This class represents a person.
 *
 * Author: Praneeth Kumar Reddy Kotha
 * Date: March 26, 2023
 */

package org.example;

/**
 * This class represents a Task with an id, title, description, and effortHours.
 * The constructor initializes all of these fields, and the getter and setter methods
 * are provided for each field to allow for modification of the Task object's attributes.
 * The toString() method returns a string representation of the Task object.
 */
public class Task {
    private int id;
    private String title;
    private String description;
    private double effortHours;

    /**
     * Constructor for creating a new Task object with the given parameters.
     *
     * @param id          The id of the Task.
     * @param title       The title of the Task.
     * @param description The description of the Task.
     * @param effortHours The effort hours required to complete the Task.
     */
    public Task(int id, String title, String description, double effortHours) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.effortHours = effortHours;
    }

    /**
     * Returns the id of the Task.
     *
     * @return The id of the Task.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the Task to the specified value.
     *
     * @param id The new id value for the Task.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the effort hours required to complete the Task.
     *
     * @return The effort hours required to complete the Task.
     */
    public double getEffortHours() {
        return effortHours;
    }

    /**
     * Sets the effort hours required to complete the Task to the specified value.
     *
     * @param effortHours The new effort hours value for the Task.
     */
    public void setEffortHours(double effortHours) {
        this.effortHours = effortHours;
    }

    /**
     * Returns the title of the Task.
     *
     * @return The title of the Task.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the Task to the specified value.
     *
     * @param title The new title value for the Task.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the description of the Task.
     *
     * @return The description of the Task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the Task to the specified value.
     *
     * @param description The new description value for the Task.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns a string representation of the Task object.
     *
     * @return A string representation of the Task object.
     */
    @Override
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", description=" + description + ", effortHours=" + effortHours + "]";
    }
}
