import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Lion lion;

    @Spy
    Feline feline = new Feline();

    @Test
    public void testGetKittens() {
        Mockito.when(lion.getKittens()).thenReturn(1);
        int kittens = lion.getKittens();
        // Проверяем, что значение kittens равно 1
        assertEquals(1, kittens);
    }

    @Test
    public void testEatMeat() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> mealList = List.of("Животные", "Птицы", "Рыба");
        List<String> food = lion.getFood();
        // Проверяем, что список еды содержит ожидаемые значения
        assertEquals(food, mealList);
    }

    @Test(expected = Exception.class)
    public void testGetFoodThorwsException() throws Exception {
        Mockito.when(lion.getFood()).thenReturn(feline.getFood("Invalid"));
        // Вызов метода getFood() должен генерировать исключение
        lion.getFood();
    }
}