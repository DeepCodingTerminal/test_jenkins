package pages.componets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.files.DownloadActions.click;

public class CalendarComponent {
  private String formatDayOfMonth(int num) {
    String result = "";
    if (num >= 1 && num <= 9) {
      result = "00" + num;
    }
    if (num >= 10 && num <= 31) {
      result = "0" + num;
    }
    return result;
  }

  public void setDate(int day, String month, String year) {
    $(".react-datepicker__month-select").selectOption(month);
    $(".react-datepicker__year-select").selectOptionByValue(year);
    $(".react-datepicker__day--"+formatDayOfMonth(day)).click();
  }

}