package store;

import com.aventstack.extentreports.Status;
import org.example.helpers.JsonTestDataHelper;
import org.example.helpers.ReportManager;
import org.example.helpers.ScreenShotHelper;
import org.example.models.Product;
import org.example.pages.ProductPage;
import org.example.pages.StorePage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import setup.BaseTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddCartTest extends BaseTest {

    public static String productTestDataProviderPath = "resources/testdata/product/";

    @Test (description = "Selecciona un producto de la categoria laptops y agregarlo al carrito de compras", dataProvider = "productDataProvider")
    public void selectProductAndAddToCart(Product product) throws IOException {
        ReportManager.getInstance().getTest().log(Status.INFO, "Test data: " + product.toString());

        //Seleccionar la categoria de laptops
        StorePage storePage = new StorePage(driver);
        storePage.clickOnCategoryLaptops();
        storePage.isDisplayedCategory();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Se selecciona la categoria de laptops");

        //Seleccionar un producto
        ProductPage productPage = new ProductPage(driver);
        productPage.selectProduct(product.getNameProduct());
        productPage.isDisplayedProduct();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Se selecciona el producto de la lista de productos de la categoria laptops");

        //Agregar el producto al carrito de compras
        productPage.clickOnAddToCart();

        //Ir al carrito de compras
        productPage.clickOnGoCart();
        productPage.isDisplayedProductCart();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Se agrega el producto al carrito de compras");

        //Validar que el producto se encuentre en el carrito de compras
        String productTitleAndPrice = product.getNameProduct() + ":" + product.getPrice();
        Assert.assertEquals(productPage.getProductTitleAndPrice(), productTitleAndPrice);
    }
    @DataProvider(name="productDataProvider")
    public Object[] productDataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().geTestData(productTestDataProviderPath + "product.json", Product.class);
    }
}
