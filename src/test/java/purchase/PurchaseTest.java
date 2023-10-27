package purchase;

import com.aventstack.extentreports.Status;
import org.example.helpers.JsonTestDataHelper;
import org.example.helpers.ReportManager;
import org.example.helpers.ScreenShotHelper;
import org.example.models.Form;
import org.example.models.Product;
import org.example.pages.ProductPage;
import org.example.pages.PurchasePage;
import org.example.pages.StorePage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import setup.BaseTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PurchaseTest extends BaseTest {
    String productName= "2017 Dell 15.6 Inch";

    public static String formTestDataProviderPath = "resources/testdata/form/";


    @Test (description = "Selecciona un producto de la categoria laptops y agregarlo al carrito de compras", dataProvider = "formDataProvider")
    public void purchaseTest(Form form) throws IOException, InterruptedException {

        System.out.println(form.getCard());
        //Seleccionar la categoria de laptops
        StorePage storePage = new StorePage(driver);
        storePage.clickOnCategoryLaptops();

        //Seleccionar un producto
        ProductPage productPage = new ProductPage(driver);
        productPage.selectProduct(productName);

        //Agregar el producto al carrito de compras
        productPage.clickOnAddToCart();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //Ir al carrito de compras
        productPage.clickOnGoCart();

        //Ir a la pagina de compra
        PurchasePage purchasePage = new PurchasePage(driver);
        purchasePage.clickOnPlaceOrder();

        ReportManager.getInstance().getTest().log(Status.INFO, "Test data: " + form.toString());

        //Llenar el formulario
        purchasePage.fillForm(form.getName(), form.getCountry(), form.getCity(), form.getCard(), form.getMonth(), form.getYear());

        //Confirmar la compra
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        purchasePage.clickOnPurchase();
        purchasePage.isDisplayedConfirm();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Se realiza la compra del producto");

        //Validar la compra
        Assert.assertEquals(purchasePage.getConfirmText(), "Thank you for your purchase!");
    }
    @DataProvider(name="formDataProvider")
    public Object[] formDataProvider() throws FileNotFoundException {
        return JsonTestDataHelper.getInstance().geTestData(formTestDataProviderPath + "form.json", Form.class);
    }

}
