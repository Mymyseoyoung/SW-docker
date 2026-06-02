package domain.student;

import org.example.domain.student.StudentManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentManagerTest {

    private static StudentManager studentManager;

    @BeforeAll
    static void setUp() {
        studentManager = new StudentManager();
    }
    // test 주석 추가

    @Test
    @Order(1)
    @DisplayName("존재하지 않는 학생 제거 시 예외 발생")
    void removeStudent_notFound_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                studentManager.removeStudent("홍길동")
        );
    }

    @Test
    @Order(2)
    @DisplayName("학생 추가 성공")
    void addStudent_success() {
        studentManager.addStudent("홍길동");

        assertTrue(studentManager.hasStudent("홍길동"));
    }

    @Test
    @Order(3)
    @DisplayName("중복 추가 시 예외 발생")
    void addStudent_duplicate_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                studentManager.addStudent("홍길동")
        );
    }

    @Test
    @Order(4)
    @DisplayName("학생 제거 성공")
    void removeStudent_success() {
        studentManager.removeStudent("홍길동");

        assertFalse(studentManager.hasStudent("홍길동"));
    }
}