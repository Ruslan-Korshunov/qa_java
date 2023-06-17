import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Lion lion;
    @Test
    public void testGetKittens() {
        Mockito.when(lion.getKittens()).thenReturn(1);
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