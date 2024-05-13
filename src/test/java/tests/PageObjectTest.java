package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class PageObjectTest {
  RegistrationPage registrationPage = new RegistrationPage();
  String firstName = "Mihail";
  String lastName = "Krylov";
  String email = "Mihail@inbox.ru";
  String gender = "Male";
  String userNumber = "9053135955";
  Integer birthDay = 10;
  String birthMonth = "November";
  String birthYear = "1995";
  String mathsSubject = "Maths";
  String historySubject = "History";
  String economicsSubject = "Economics";
  String sportHobby = "Sports";
  String readingHobby = "Reading";
  String musicHobby = "Music";
  String picturePath = "picture.jpg";
  String currentAddress = "Moscow";
  String state = "NCR";
  String city = "Delhi";

  @BeforeAll
  static void beforeAll() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "2560x1440";
  }

  @Test
  void successFillTest() {
    registrationPage.openPage()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setUserEmail(email)
            .setGender(gender)
            .setUserNumber(userNumber)
            .setBirthDate(birthDay, birthMonth, birthYear)
            .setSubjects(mathsSubject, historySubject, economicsSubject)
            .setHobbies(sportHobby, readingHobby, musicHobby)
            .uploadPicture(picturePath)
            .setCurrentAddress(currentAddress)
            .setState(state)
            .setCity(city);

    registrationPage.clickSubmitButton();

    registrationPage
            .checkForm("Student Name", firstName + " " + lastName)
            .checkForm("Student Email", email)
            .checkForm("Gender", gender)
            .checkForm("Mobile", userNumber)
            .checkForm("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
            .checkForm("Subjects", mathsSubject + ", " + historySubject + ", " + economicsSubject)
            .checkForm("Hobbies", sportHobby + ", " + readingHobby + ", " + musicHobby)
            .checkForm("Picture", picturePath)
            .checkForm("Address", currentAddress)
            .checkForm("State and City", state + " " + city)
            .checkExistsCloseButton();

  }
}
