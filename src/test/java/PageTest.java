import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageTest extends BaseTest{

    @Test
    void calorieTrackerTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.addMealIsDisplayed();
        mainPage.addMeal("banana",100);
        mainPage.addMeal("fish", 250);
        assertTrue(mainPage.checkTotalCalories(), "Total calories doesn't match");
        mainPage.clickPencilIcon();
        mainPage.updateCalories(89);
        assertTrue(mainPage.checkTotalCalories(), "Total calories doesn't match");

    }
}
