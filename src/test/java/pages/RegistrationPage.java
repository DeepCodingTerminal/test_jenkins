package pages;

import com.codeborne.selenide.SelenideElement;
import pages.componets.CalendarComponent;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
  // components
  private CalendarComponent calendarComponent = new CalendarComponent();

  // locators
  private final SelenideElement
          headerTitle = $(".practice-form-wrapper"),
          firstNameInput = $("#firstName"),
          lastNameInput = $("#lastName"),
          userEmailInput = $("#userEmail"),
          genderWrapper = $("#genterWrapper"),
          userNumberInput = $("#userNumber"),
          dateOfBirthDayInput = $("#dateOfBirthInput"),
          subjectsInput = $("#subjectsInput"),
          hobbiesWrapper = $("#hobbiesWrapper"),
          uploadPicture = $("#uploadPicture"),
          currentAddressInput = $("#currentAddress"),
          stateSelectInput = $("#react-select-3-input"),
          citySelectInput = $("#react-select-4-input"),
          submitButton = $("#submit"),
          closeButton = $("#closeLargeModal"),
          resultsTable = $(".table-responsive");

  // actions
  public RegistrationPage openPage() {
    open("/automation-practice-form");
    headerTitle.shouldHave(text("Student Registration Form"));
    return this;
  }

  public RegistrationPage setFirstName(String firstName) {
    firstNameInput.setValue(firstName);
    return this;
  }

  public RegistrationPage setLastName(String lastName) {
    lastNameInput.setValue(lastName);
    return this;
  }

  public RegistrationPage setUserEmail(String userEmail) {
    userEmailInput.setValue(userEmail);
    return this;
  }

  public RegistrationPage setGender(String gender) {
    genderWrapper.$(byText(gender)).click();
    return this;
  }

  public RegistrationPage setUserNumber(String userNumber) {
    userNumberInput.setValue(userNumber);
    return this;
  }

  public RegistrationPage setSubjects(String... subjects) {
    Stream.of(subjects)
            .forEach(e -> subjectsInput.setValue(e).pressEnter());
    return this;
  }

  public RegistrationPage setHobbies(String... hobbies) {
    Stream.of(hobbies)
            .forEach(e -> hobbiesWrapper.$(byText(e)).click());
    return this;
  }

  public RegistrationPage uploadPicture(String path) {
    uploadPicture.uploadFromClasspath(path);
    return this;
  }

  public RegistrationPage setCurrentAddress(String currentAddress) {
    currentAddressInput.setValue(currentAddress);
    return this;
  }

  public RegistrationPage setState(String state) {
    stateSelectInput.setValue(state).pressEnter();
    return this;
  }

  public RegistrationPage setCity(String city) {
    citySelectInput.setValue(city).pressEnter();
    return this;
  }

  public RegistrationPage setBirthDate(Integer day, String month, String year) {
    dateOfBirthDayInput.click();

    calendarComponent.setDate(day, month, year);
    return this;
  }

  public void clickSubmitButton() {
    submitButton.click();
  }

  public void checkExistsCloseButton() {
    closeButton.shouldHave(exist);
  }

  public RegistrationPage checkForm(String fieldName, String value) {
    resultsTable.$(byText(fieldName))
            .parent().shouldHave(text(value));
    return this;
  }
}