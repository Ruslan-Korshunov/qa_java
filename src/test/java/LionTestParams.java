import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParams {
    @Mock
    Feline feline;

    @Parameterized.Parameter()
    public String sex;
    @Parameterized.Parameter(1)
    public boolean expectedHasMane;

    @Parameterized.Parameters(name = "Sex: {0}, expected presence of a mane: {1}")
    public static Object[][] params() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualResult = lion.doesHaveMane();
        assertEquals(expectedHasMane, actualResult);
    }
}
