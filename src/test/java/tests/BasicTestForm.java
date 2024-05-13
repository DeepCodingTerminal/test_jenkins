package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BasicTestForm {
  @BeforeAll
  static void beforeAll() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "2560x1440";
  }

  @Feature("Test form")
  @Story("Первое добавление allure")
  @Owner("parakevich_m")
  @Severity(SeverityLevel.BLOCKER)
  @Link(value = "Test Link", url = "https://ya.ru")


  @Test
  void successFillTest() throws InterruptedException {
    open("/automation-practice-form");

    $("#firstName").setValue("Mihail");
    $("#lastName").setValue("Krylov");
    $("#userEmail").setValue("Mihail@inbox.ru");

    executeJavaScript("arguments[0].click()", $(By.id("gender-radio-1")));

    $("#userNumber").setValue("9053135955");
    //$("#dateOfBirthInput").clear();

    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOptionByValue("10");
    $(".react-datepicker__year-select").selectOptionByValue("1995");
    $(".react-datepicker__day--010").click();


    $("#subjectsInput").setValue("Maths").pressEnter();
    $("#subjectsInput").setValue("History").pressEnter();
    $("#subjectsInput").setValue("Economics").pressEnter();


    executeJavaScript("arguments[0].click()", $(By.id("hobbies-checkbox-1")));
    executeJavaScript("arguments[0].click()", $(By.id("hobbies-checkbox-2")));
    executeJavaScript("arguments[0].click()", $(By.id("hobbies-checkbox-3")));
    $("#uploadPicture").uploadFile(new File("src/test/resources/picture.jpg"));

    $("#currentAddress").setValue("Moscow");

    $("#react-select-3-input").setValue("NCR").pressEnter();
    $("#react-select-4-input").setValue("Delhi").pressEnter();
    $("#submit").click();

    $("#example-modal-sizes-title-lg").shouldHave((textCaseSensitive("Thanks for submitting the form")));
    $(".table-responsive").shouldHave(
            textCaseSensitive("Student Name"),    textCaseSensitive("Mihail Krylov"),
            textCaseSensitive("Student Email"),   textCaseSensitive("Mihail@inbox.ru"),
            textCaseSensitive("Gender"),          textCaseSensitive("Male"),
            textCaseSensitive("Mobile"),          textCaseSensitive("9053135955"),
            textCaseSensitive("Date of Birth"),   textCaseSensitive("10 November,1995"),
            textCaseSensitive("Subjects"),        textCaseSensitive("Maths, History, Economics"),
            textCaseSensitive("Hobbies"),         textCaseSensitive("Sports, Reading, Music"),
            textCaseSensitive("Picture"),         textCaseSensitive("picture.jpg"),
            textCaseSensitive("Address"),         textCaseSensitive("Moscow"),
            textCaseSensitive("State and City"),  textCaseSensitive("NCR Delhi")
    );

    $("#closeLargeModal").click();
  }
}
