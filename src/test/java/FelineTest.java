import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Test
    public void testGetFamilyReturnsCats(){
        Feline feline = new Feline();
        String result = feline.getFamily();

        // Проверяем, что список еды содержит ожидаемые значения
        assertEquals("Кошачьи", result);
        // Другие ожидаемые значения еды, если есть
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int kittens = feline.getKittens();

        // Проверяем, что значение kittens равно 1
        assertEquals(1, kittens);
    }

    @Test
    public void testGetKittensWithArgument() {
        Feline feline = new Feline();
        int kittens = feline.getKittens(3);

        // Проверяем, что значение kittens равно 3
        assertEquals(3, kittens);
    }
    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> mealList = List.of("Животные", "Птицы", "Рыба");
        List<String> food = feline.eatMeat();
        // Проверяем, что список еды содержит ожидаемые значения
        assertEquals(food, mealList);
    }
}