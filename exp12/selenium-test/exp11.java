import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.nio.file.Paths;
public class exp11{
    public static void main(String [] args){
         WebDriver driver=new ChromeDriver();
        try{
            String filePath=Paths.get("program.html").toAbsolutePath().toUri().toString();
            driver.get(filePath);
            driver.findElement(By.id("increment-button")).click();
            String result= driver.findElement(By.id("output")).getText();
            if(result.equals("1")){
                System.out.println("success");
            }
            else{
                System.out.printf("error ,expected 1 but got "+result);
                throw new AssertionError("error at counter");
            }
        }
        finally{
            driver.quit();
        }
    }
}