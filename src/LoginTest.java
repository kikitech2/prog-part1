import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Util util = new Util(); // Assuming Util is the class with your logic

    @Test
    void checkPasswordComplexity() {
        Assertions.assertAll(
                () -> assertTrue(util.checkPasswordComplexity()),
                () -> assertEquals("ch&&sec@ke99", util.password),
                () -> assertNotNull(util.password)
        );
    }

    @Test
    void checkCellPhoneNumber() {
        Assertions.assertAll(
                () -> assertTrue(util.checkCellPhoneNumber()),
                () -> assertEquals("+27838968976", util.cellPhoneNumber),
                () -> assertTrue(util.cellPhoneNumber.startsWith("+27"))
        );
    }

    @Test
    void loginUser() {
        Assertions.assertAll(
                () -> assertTrue(util.loginUser("kyle_1", "ch&&sec@ke99")),
                () -> assertFalse(util.loginUser("wrongUser", "wrongPass")),
                () -> assertEquals("kyle_1", util.username),
                () -> assertEquals("ch&&sec@ke99", util.password)
        );
    }
}
