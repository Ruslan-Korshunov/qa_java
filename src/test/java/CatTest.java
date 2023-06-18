import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;


    @Test
    public void testGetSoundReturnsMeow() {
        Cat cat = new Cat(feline);
        String catSound = cat.getSound();
        assertEquals("Мяу", catSound);
    }

    @Test
    public void testGetFoodSuccess() throws Exception {
        Cat cat = new Cat(new Feline());
        // Предполагаемый результат
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        // Получение фактического результата
        List<String> actualFood = cat.getFood();

        // Сравнение ожидаемого и фактического результатов
        assertEquals(expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        // Создаем объект Cat с некорректной реализацией интерфейса Predator
        Cat cat = new Cat(null);
        // Вызов метода getFood() должен генерировать исключение
        cat.getFood();
    }

}