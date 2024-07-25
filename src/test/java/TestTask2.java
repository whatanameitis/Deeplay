import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpunin.task2.Task2;

import java.util.List;

public class TestTask2 {
    @Test
    public void shouldReturnOneMostFrequent() {
        List<Integer> list = List.of(1, 1, 1, 1, 2, 2, 3, 4, 5, 6, 6);
        List<Integer> mostFrequentList = Task2.findMostFrequent(list);

        Assertions.assertEquals(mostFrequentList, List.of(1));
    }

    @Test
    public void shouldReturn2MostFrequent() {
        List<Integer> list = List.of(1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 6, 7);
        List<Integer> mostFrequentList = Task2.findMostFrequent(list);

        Assertions.assertEquals(mostFrequentList, List.of(1, 2));
    }
}
