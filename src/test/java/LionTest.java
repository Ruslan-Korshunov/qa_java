import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Lion lion;

    @Test
    public void testConstructor_ValidSex() throws Exception {
        // Предполагаемый результат
        boolean expectedHasMane = true;

        // Создание объекта Lion с допустимым значением пола
        Lion lion = new Lion("Самец");

        // Проверка значения hasMane
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeTrue() throws Exception {
        Lion lion = new Lion("Самец");
        boolean result = lion.doesHaveMane();
        assertTrue(result);
    }
    @Test
    public void testDoesHaveManeFalse() throws Exception {
        Lion lion = new Lion("Самка");
        boolean result = lion.doesHaveMane();
        assertFalse(result);
    }

    @Test
    public void testLionConstructorInvalidSex() {
        try {
            new Lion("INVALID");
            fail("Ожидалось выбрасывание исключения");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }

    @Test
    public void testGetKittens() throws Exception {
        new Lion("Самец");
        int kittens = Lion.getKittens();

        // Проверяем, что значение kittens равно 1
        assertEquals(1, kittens);
    }

    @Test
    public void testGetKittensWithArgument() throws Exception {
        Lion lion = new Lion("Самка");
        int kittens = lion.getKittens(3);

        // Проверяем, что значение kittens равно 3
        assertEquals(3, kittens);
    }
    @Test
    public void testEatMeat() throws Exception {

        List<String> meal_list = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(lion.eatMeat()).thenReturn(meal_list);
        List<String> food = lion.eatMeat();
        // Проверяем, что список еды содержит ожидаемые значения
        assertEquals(food, meal_list);
    }

    @Test(expected = Exception.class)
    public void testGetFood_Exception() throws Exception {
        Mockito.when(lion.eatMeat()).thenReturn(lion.getFood("Invalid"));
        // Вызов метода getFood() должен генерировать исключение
        lion.eatMeat();
    }
}