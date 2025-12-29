import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class Codegen {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://smartschoolnxt.co.in/");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
      page.getByText("Enter valid Mobile Number").click();
      page.getByPlaceholder(" Registered mobile number").click();
      page.getByPlaceholder(" Registered mobile number").fill("9898989898989");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
      page.getByText("Mobile number is invalid").click();
      page.getByPlaceholder(" Registered mobile number").click();
      page.getByPlaceholder(" Registered mobile number").click();
      page.getByPlaceholder(" Registered mobile number").fill("9360849909");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
      page.getByPlaceholder("Enter your password").click();
      page.getByPlaceholder("Enter your password").fill("dfdfdfdf");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Sign In")).click();
      page.getByText("Password is invalid").click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
      page.getByPlaceholder("Enter your password").dblclick();
      page.getByPlaceholder("Enter your password").fill("ssp@123");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Sign In")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Dashboard")).click();
    }
  }
}