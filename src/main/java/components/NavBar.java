package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import settings.BasePage;

import java.util.ArrayList;
import java.util.List;

public class NavBar extends BasePage {

    @FindBy(id = "foryou_tab")//pestaña tu tienda
    private WebElement yourStoreTab;

    @FindBy(id = "genre_tab")//pestaña juegos
    private WebElement yourGameTab;

    @FindBy(id = "store_nav_search_term")//buscador de palabras
    private WebElement searchTheStoreInput;

    @FindBy(css = "#search_suggestion_contents > a > .match_name")//resultados de busqueda
    private List<WebElement> suggestedGames;

    //locator to search the game Portal2
    @FindBy(css = "#search_suggestion_contents > a[href='https://store.steampowered.com/app/620/Portal_2/?snr=1_7_15__13']")
    private WebElement yourGame;
    //Locators to find the text and use it to check : still no solution in get the text
    @FindBy(css = "//div[text()='Portal 2']")
     WebElement chekPage;
    @FindBy(css = "//span[text()='Portal 2']")
     WebElement chak;
    //Locator to search the game Age of empires
    @FindBy(css = "#search_suggestion_contents > a[href='https://store.steampowered.com/app/813780/Age_of_Empires_II_Definitive_Edition/?snr=1_7_15__13']")
    private WebElement AgeofEmpires;

    public NavBar(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openYourStoreTab(){
        this.openNavBarTab(yourStoreTab);
    }

    public void openGamesTab(){
        this.openNavBarTab(yourGameTab);
    }

    public ArrayList<String> getSuggestedGames(){

        ArrayList<String> suggested_games_names = new ArrayList<String>();

        for (WebElement suggestedGame : suggestedGames)
        {
            suggested_games_names.add(suggestedGame.getText());
        }
        return suggested_games_names;
    }

    public void writeGameIntoSearchInput(String game_name){//buscar juego
        this.writeInInput(searchTheStoreInput, game_name);
    }

    public void writeNewGame(String new_Game){
        this.typeInSerch(searchTheStoreInput,new_Game);
    }

    public void selectYourGame(){//click en juego seleccionado
        this.click(yourGame);
    }//click en Juego deseado

    public void selectYourGame2(){//click en juego seleccionado
        this.click(AgeofEmpires);
    }//click en Juego deseado
// I try to get the Text in the element on CSS locator, maybe i need to check another options
   /* public String grandAccess(){
         return this.getText(chekPage); }*/

    //I try to select the position in the text Portal 2
    //by the moment i coment the code because no solve this yet
    public void grandAccess2(){
         this.openNavBarTab(chak);
    }


    private void openNavBarTab(WebElement tab){
        this.hoverElement(tab);
        String is_active = tab.getAttribute("class");
        Assert.assertTrue(is_active.indexOf("focus") > 0, "The Menu did not open");
    }
}
