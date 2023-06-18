import com.example.Feline;
import com.example.Lion;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LionTest {

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        int kittens = lion.getKittens();
        // Проверяем, что значение kittens равно 1
        assertEquals(1, kittens);
    }

    @Test
    public void testEatMeat() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        List<String> mealList = List.of("Животные", "Птицы", "Рыба");
        List<String> food = lion.getFood();
        // Проверяем, что список еды содержит ожидаемые значения
        assertEquals(food, mealList);
    }
}