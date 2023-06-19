import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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
        // Создание стаба для интерфейса Predator
        class PredatorStub implements Predator {
            @Override
            public List<String> eatMeat() {
                return List.of("Животные", "Птицы", "Рыба");
            }
        }

        // Создание объекта Cat с моком в качестве параметра
        Cat cat = new Cat(feline);

        // Установка поведения мока
        Mockito.when(cat.getFood()).thenReturn(new PredatorStub().eatMeat());
        // Ожидаемый результат
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