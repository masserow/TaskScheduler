package ru.netology.javaqa.TaskScheduler.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {


    @Test
    public void testSimpleTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("звонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNotFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("написать");

        Assertions.assertFalse(actual);
    }


    @Test
    public void testEpicFound() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Хлеб");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicNotFound() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("булка");

        Assertions.assertFalse(actual);
    }


    @Test
    public void testMeetingFound() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("НетоБанк");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingNotFound() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("5я версия");

        Assertions.assertFalse(actual);
    }
}
