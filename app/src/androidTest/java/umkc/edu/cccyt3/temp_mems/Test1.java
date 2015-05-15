package umkc.edu.cccyt3.temp_mems;

/**
 * Created by CCColeman on 5/7/2015.
 */
public class ExampleTest extends ApplicationTest {
    public void test() throws Exception {
        CountModel model = new CountModel();
        model.increment();
        assertEquals(1, model.getValue());
    }
}


