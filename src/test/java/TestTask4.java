import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.karpunin.task4.Task4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestTask4 {
    @Test
    public void shouldBePossible() {
        int[] nums = {5, 4, 3, 1};
        int K = 2;
        List<List<Integer>> result = new ArrayList<>();

        Assertions.assertTrue(Task4.isPartitionPossible(nums, K, result));
        Assertions.assertEquals(result.get(0), List.of(5, 1));
        Assertions.assertEquals(new HashSet<>(result.get(1)), Set.of(3, 4));

    }

    @Test
    public void shouldNotBePossible() {
        int[] nums = {1, 2, 3, 4};
        int K = 3;

        Assertions.assertFalse(Task4.isPartitionPossible(nums, K, new ArrayList<>()));
    }
}
