import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "/html/body//form[@class='col']/div/button[1]")
    private WebElement addMealBtn;
    @FindBy(css = "input#item-name")
    private WebElement mealInputField;
    @FindBy(css = "input#item-calories")
    private WebElement caloriesInputField;
    @FindBy(css = "button.fc-button.fc-cta-consent.fc-primary-button[role=button][aria-label=Consent]")
    private WebElement consentAlert;
    @FindBy(xpath = "//body//h3[@class='center-align']")
    private WebElement totalCaloriesField;
    @FindBy(xpath = "//body//h3[@class='center-align']/span[@class='total-calories']")
    private WebElement totalCaloriesInput;
    @FindBy(xpath = "//li[@id='item-0']//i[@class='edit-item fa fa-pencil']")
    private WebElement pencilIcon;
    @FindBy(css = ".btn.orange.update-btn")
    private WebElement updateBtn;
    @FindBy(css = "ul#item-list > li:nth-of-type(1)")
    private WebElement collectionItem;
    @FindBy(css = "li:nth-of-type(1) > strong")
    private WebElement mealNameInput;
    @FindBy(css = "li:nth-of-type(1) > em")
    private WebElement caloriesInput;
    @FindBy(css = "ul#item-list > li > em")
    private List<WebElement> mealsCaloriesList;

    public MainPage(WebDriver driver) {
        super(driver);
    }


    //check if healthy meal delivery alert opens google page?
    // check if clear all button is displayed
    //check if list was cleared after "clear all" button click

    //check if add meal button is displayed +
    public void addMealIsDisplayed() {
        addMealBtn.isDisplayed();
        consentAlert.click();
    }

    //Add new meal and calories +
    public void addMeal(String meal, int calories) {
        mealInputField.sendKeys(meal);
        caloriesInputField.sendKeys(Integer.toString(calories));
        addMealBtn.click();
    }

    // 1) check if total calories changed after adding a meal
    //2) check if total calories changed after update
    public boolean checkTotalCalories() {
        int actualTotalCalories = Integer.parseInt(totalCaloriesInput.getText());
        int caloriesNumber;
        int totalCalories = 0;
        for (WebElement el : mealsCaloriesList) {
            caloriesNumber = Integer.parseInt(el.getText().split(" ")[0]);
            totalCalories += caloriesNumber;
        }
        return actualTotalCalories == totalCalories;
    }

    //press the pencil image
    public void clickPencilIcon() {
        pencilIcon.click();
    }

    // update meal calories
    public void updateCalories(int calories) {
        caloriesInputField.clear();
        caloriesInputField.sendKeys(Integer.toString(calories));
        updateBtn.click();

    }

  
}
