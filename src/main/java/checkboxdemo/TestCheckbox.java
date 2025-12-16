package checkboxdemo;

import org.openqa.selenium.By;

public class TestCheckbox {
    public static void main(String[] args) {
        /*
        Yeu cau: viet 1 function selectCheckbox(boolean status)
           ==> status = true ==> checked
            if(checkbox is selected)
                do nothing
            else
                tick

           ==> status = false ==> unchecked (untick)
           if(checkbox is selected)
                untick
            else
                do nothing
         */

        //Step 1: Go to https://the-internet.herokuapp.com/checkboxes

        //Step 2: Tick checkbox 1

        //Step 3: Untick checkbox 1

        //Step 4: Tick checkbox 2

        //Step 5: Untick checkbox 2

    }
    public static void selectCheckbox(By locator,boolean status) {
        //logic
    }
}
