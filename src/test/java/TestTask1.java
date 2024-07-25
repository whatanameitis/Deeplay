import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpunin.task1.Task1;

public class TestTask1 {
    @Test
    public void shouldOrderCorrectly() {
        int[] array = new int[]{-1, -3, -5, 0, 0, 0, 2, 4, -1, 6};
        int[] orderedArray = Task1.customOrder(array);

        Assertions.assertArrayEquals(orderedArray, new int[]{-5, -3, -1, -1, 0, 0, 0, 6, 4, 2});
    }
}
