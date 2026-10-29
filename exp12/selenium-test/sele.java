import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sele { // Changed from Main to sele
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        int passed = 0;

        try {
            // Test Case 1: Verify home page
            driver.get("http://localhost:8081");

            String title = driver.getTitle();

            if (title.equals("My Containerized Application")) {
                System.out.println("TEST 1 PASSED: Home page loaded");
                passed++;
            } else {
                throw new AssertionError("Incorrect page title: " + title);
            }

            // Test Case 2: Verify form submission
            driver.findElement(By.name("name")).sendKeys("John Doe");
            driver.findElement(By.name("email"))
                  .sendKeys("john.doe@example.com");
            driver.findElement(By.name("submit")).click();

            String result = driver.findElement(By.id("result")).getText();

            if (result.equals("Form submitted successfully!")) {
                System.out.println("TEST 2 PASSED: Form submitted successfully");
                passed++;
            } else {
                throw new AssertionError("Unexpected result: " + result);
            }

            System.out.println("Tests passed: " + passed + "/2");

        } finally {
            driver.quit();
        }
    }
}
