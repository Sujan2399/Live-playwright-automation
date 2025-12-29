import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class Example {
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
      page.getByPlaceholder(" Registered mobile number").fill("5666666666666");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
      page.getByText("Mobile number is invalid").click();
      page.getByPlaceholder(" Registered mobile number").click();
      page.getByPlaceholder(" Registered mobile number").fill("9360849909");
      page.getByPlaceholder(" Registered mobile number").press("ControlOrMeta+a");
      page.getByPlaceholder(" Registered mobile number").press("ControlOrMeta+x");
      page.getByPlaceholder(" Registered mobile number").fill("9876543210");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
      page.getByPlaceholder("Enter your password").fill("fdgbdfgdfg");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Sign In")).click();
      page.getByText("Password is invalid").click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
      page.getByPlaceholder("Enter your password").click();
      page.getByPlaceholder("Enter your password").fill("ssp@123");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Sign In")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Dashboard")).click();
      page.getByTitle("Select School").click();
      page.getByPlaceholder(" Search Schools").click();
      page.getByPlaceholder(" Search Schools").fill("demo");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Demo SCHOOL (DEMO)")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" My School ")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("• Profile ")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("• Year")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
      page.locator("#academicName").click();
      page.locator("#academicName").fill("2029");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel")).click();
    }
  }
}