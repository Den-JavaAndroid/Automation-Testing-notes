import get.GetRecepy;
import model.Recepy;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by denx7 on 10.12.2017.
 */
public class RestRecepyTest {
    private static String url;


    @BeforeClass
    public static void initTestData(){
       url = "http://www.recipepuppy.com/api/?i=onions,garlic&q=omelet&p=3";

    }


    @Test
    public void getRecepy(){

        Recepy recepyRs = GetRecepy.getRecepy(url);
        Assert.assertNotNull("Проверяем наличие названия рецепта", recepyRs.getTitle());
        Assert.assertTrue("Проверяем наличие описания рецепта", recepyRs.getResults().size() >0);

    }
}
