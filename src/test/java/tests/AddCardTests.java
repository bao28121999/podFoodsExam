package tests;

import org.testng.annotations.Test;
import pageObject.*;

import static base.Constant.Constants.*;

public class AddCardTests {

    //HomePage homePage = new HomePage();
    //AccountPage accountPage = new AccountPage();

    @Test
    public void Test(){
        HomePage homePage = new HomePage();
        AccountPage accountPage = homePage.closePopup()
                .isOnHomePage()
                .Login()
                .isAccountPage();
        SearchPage searchPage = accountPage.clickLogin()
                .isOnLoginPage()
                .login(EMAIL,PASSWORD)
                .isOnHomePage()
                .verifyLoggedIn(ACCOUNT_NAME)
                .search(PRODUCT);
        ProductPage productPage = searchPage
                .clickToProduct(PRODUCT)
                .isOnProductPage()
                .swipeToLeft();
        String type = productPage.getType();
        AddCartPage addCartPage = productPage.clickAddToCard()
                .isOnAddCartPage();
        String quantity= addCartPage.getQuantity();
        productPage = addCartPage.clickAddToCart()
                .verifyAddCartSuccess(PRODUCT, type, quantity)
                .verifyQuantityInCart(quantity);

    }
}
