import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;

    @Before
    public void setUp() {
        // Создаем объект Feline для передачи в конструктор Cat
        Feline feline = new Feline();
        cat = new Cat(feline);
    }

    @Test
    public void testGetSoundReturnsMeow() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String catSound = cat.getSound();
        assertEquals("Мяу", catSound);
    }

    @Test
    public void testGetFood_Success() throws Exception {
        // Предполагаемый результат
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        // Получение фактического результата
        List<String> actualFood = cat.getFood();

        // Сравнение ожидаемого и фактического результатов
        assertEquals(expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void testGetFood_Exception() throws Exception {
        // Создаем объект Cat с некорректной реализацией интерфейса Predator
        Cat catWithIncorrectPredator = new Cat(null);

        // Вызов метода getFood() должен генерировать исключение
        catWithIncorrectPredator.getFood();
    }

}
