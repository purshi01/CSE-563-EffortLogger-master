/* This class represents a person.
 *
 * Author: Purushothama Shanthappa
 * Date: March 26, 2023
 */
package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;

public class EffortLogger extends JFrame {
    public JPanel contentPane;
    private JTextField titleField;
    private JTextField descriptionField;

    private JTextField effortHoursField;
    private TaskService taskService;
    private JList<Task> taskList;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Login login = new Login();
                login.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // Constructor for EffortLogger class
    public EffortLogger() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        taskService = new TaskService();
        initialize();


    }

    // Method to initialize the components of the GUI
    private void initialize() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        taskList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(24, 10, 250, 400);
        contentPane.add(scrollPane);

        taskList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                onTaskSelection();
            }
        });

        titleField = new JTextField();
        titleField.setBounds(300, 23, 278, 26);
        contentPane.add(titleField);

        descriptionField = new JTextField();
        descriptionField.setBounds(300, 89, 464, 26);
        contentPane.add(descriptionField);
        descriptionField.setColumns(10);
        JLabel lblNewLabel_1 = new JLabel("Title :");
        lblNewLabel_1.setBounds(300, 6, 61, 16);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Description :");
        lblNewLabel_2.setBounds(300, 54, 117, 16);
        contentPane.add(lblNewLabel_2);

        effortHoursField = new JTextField();
        JLabel lblNewLabel = new JLabel("Effort Hours :");
        lblNewLabel.setBounds(300, 127, 85, 36);
        contentPane.add(lblNewLabel);

        effortHoursField.setBounds(400, 132, 59, 26);

        contentPane.add(effortHoursField);

        JButton updateButton = new JButton("Update Task");
        updateButton.setBounds(425, 190, 117, 29);
        updateButton.addActionListener(e -> {
            Task selectedTask = taskList.getSelectedValue();
            if (selectedTask != null) {
                taskService.updateTask(selectedTask.getId(), titleField.getText(), descriptionField.getText(), Double.parseDouble(effortHoursField.getText()));
                updateTaskListDisplay();
            }
        });

        JButton deleteButton = new JButton("Delete Task");
        deleteButton.setBounds(300, 221, 117, 29);
        deleteButton.addActionListener(e -> {
            Task selectedTask = taskList.getSelectedValue();
            if (selectedTask != null) {
                taskService.deleteTask(selectedTask.getId());
                updateTaskListDisplay();
            }
        });
        contentPane.add(updateButton);
        contentPane.add(deleteButton);

        JButton addButton = new JButton("Add Task");
        addButton.setBounds(300, 190, 117, 29);
        addButton.addActionListener(e -> {
            String title = titleField.getText();
            String description = descriptionField.getText();
            double effortHours = Double.parseDouble(effortHoursField.getText());
            taskService.createTask(title, description, effortHours);
            updateTaskListDisplay();
        });

        contentPane.add(addButton, BorderLayout.SOUTH);

        JButton ganttChartButton = new JButton("Show Gantt Chart");
        ganttChartButton.setBounds(425, 221, 138, 29);
        ganttChartButton.addActionListener(e -> {
            showGanttChart();
        });

        contentPane.add(ganttChartButton, BorderLayout.SOUTH);

    }
    /**
     * Event handler for when a task is selected in the UI.
     */
    private void onTaskSelection() {
        Task selectedTask = taskList.getSelectedValue();
        if (selectedTask != null) {
            titleField.setText(selectedTask.getTitle());
            descriptionField.setText(selectedTask.getDescription());
        }
    }
    /**
     * Updates the UI display of the task list.
     */
    private void updateTaskListDisplay() {
        DefaultListModel<Task> listModel = new DefaultListModel<>();
        for (int i = 1; i < taskService.getNextId(); i++) {
            Task task = taskService.getTask(i);
            if (task != null) {
                listModel.addElement(task);
            }
        }

        taskList.setModel(listModel);
    }
    /**
     * Displays a Gantt chart of the tasks in the task list.
     */
    private void showGanttChart() {
        IntervalCategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        JFrame ganttFrame = new JFrame("Gantt Chart");
        ganttFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ganttFrame.add(chartPanel, BorderLayout.CENTER);
        ganttFrame.pack();
        ganttFrame.setLocationRelativeTo(null);
        ganttFrame.setVisible(true);
    }

    /**
     * Creates a dataset for the Gantt chart.
     *
     * @return the dataset for the Gantt chart
     */
    private IntervalCategoryDataset createDataset() {
        TaskSeries series = new TaskSeries("Tasks");
        for (int i = 1; i < taskService.getNextId(); i++) {
            org.example.Task task = taskService.getTask(i);
            if (task != null) {
                org.jfree.data.gantt.Task jFreeTask = new org.jfree.data.gantt.Task(
                        task.getTitle(),
                        new SimpleTimePeriod(System.currentTimeMillis(), System.currentTimeMillis() + (long) (task.getEffortHours() * 3600000))
                );
                series.add(jFreeTask);
            }
        }

        TaskSeriesCollection dataset = new TaskSeriesCollection();
        dataset.add(series);
        return dataset;
    }

    /**
     * Creates a chart for the Gantt chart.
     *
     * @param dataset the dataset to use for the chart
     * @return the chart for the Gantt chart
     */
    private JFreeChart createChart(IntervalCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createGanttChart(
                "Gantt Chart",
                "Task",
                "Time",
                dataset,
                true,
                true,
                false
        );

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setOrientation(PlotOrientation.HORIZONTAL);
        return chart;
    }

}
