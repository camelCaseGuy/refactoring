package src.refactoring;

public class Movie {

  private String _title;
  private String _type;

  public Movie(String title) {
    _title = title;
    switch (title.toLowerCase()) {
      case "titanic":
        _type = "regular";
        break;
      case "oppenheimer":
        _type = "newRelease";
        break;
      case "care bears":
        _type = "childrens";
        break;
      default:
        _type = "other";
        break;
    }
  }

  public String getTitle() {
    return _title;
  }

  public String getType() {
    return _type;
  }

}
