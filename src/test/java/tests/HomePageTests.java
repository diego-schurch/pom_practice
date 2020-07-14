package tests;

import components.NavBar;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import settings.BaseTest;

import java.util.ArrayList;

public class HomePageTests extends BaseTest {

    private NavBar navBar;

    @BeforeTest
    public void setUp(){
        navBar = new NavBar(this.driver);
    }

   /* @Test(priority = 0)
    public void openAllNavBarTabs(){
        navBar.openYourStoreTab();
        navBar.openGamesTab();
    }*/

    @Test(priority = 1)
    public void testSuggestedGames(){
        String game_name = "Portal";
        navBar.writeGameIntoSearchInput(game_name);
        ArrayList<String> games = navBar.getSuggestedGames();
        Assert.assertTrue(games.size() == 5, "The number of suggested games is not correct");
        for(String game: games){
            Assert.assertTrue(game.indexOf(game_name) >= 0, "The game " + game + " is not correct. Not contains Search String " + game_name);
        }
        //navBar.selectYourGame();
    }

    @Test(priority = 2)
    public void selectGamePortal_2(){
       //click and select Portal 2
        navBar.selectYourGame();
        //I try to get the text or select the locator , I need to find another way , i´ve comented this
        //navBar.grandAccess2();
    }
   @Test(priority =3)
    public void newGame(){
        //click and selec Age of empires
        String new_Game = "Age";
        navBar.writeNewGame(new_Game);
        navBar.selectYourGame2();
    }

}

