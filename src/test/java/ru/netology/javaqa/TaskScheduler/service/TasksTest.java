package ru.netology.javaqa.TaskScheduler.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TasksTest {

    @Test
    public void testGet() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        simpleTask.matches(simpleTask.title);
        meeting.matches(meeting.topic);
        meeting.matches(meeting.project);
        meeting.matches(meeting.start);

        String expected = ("Позвонить родителям" + "Выкатка 3й версии приложения" + "Приложение НетоБанка" + "Во вторник после обеда");
        String actual = simpleTask.getTitle() + meeting.getTopic() + meeting.getProject() + meeting.getStart();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        simpleTask.matches(simpleTask.title);
        meeting.matches(meeting.topic);
        meeting.matches(meeting.project);

        boolean expected = false;
        boolean actual = simpleTask.matches(toString());
        meeting.matches(toString());
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testMeeting() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        epic.matches(epic.subtasks[2]);


        String expected = ("Хлеб");
        String actual = epic.getSubtasks()[2];
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testMeet() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        epic.matches(epic.subtasks[2]);


        boolean expected = false;
        boolean actual = epic.matches(toString());
        Assertions.assertEquals(expected, actual);
    }

}
