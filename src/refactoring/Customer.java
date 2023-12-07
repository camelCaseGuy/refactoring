package src.refactoring;

// import java.io.FileNotFoundException;
// import java.io.UnsupportedEncodingException;
// import javax.xml.stream.XMLStreamException;

import java.util.ArrayList;


public class Customer {
  private String _name;
  private ArrayList<Rental> _rentals = new ArrayList<Rental>();
  private double _totalAmount;
  private int _points;

  public Customer(String name) {
    _name = name;
  }

  public void addRental(Rental careBearsRental) {
    _rentals.add((Rental) careBearsRental);
  }

  public String getName() {
    return _name;
  }

  public ArrayList<Rental> getRentals() {
    return _rentals;
  }

  public double getTotalAmount() {
    return _totalAmount;
  }

  public int getPoints() {
    return _points;
  }

  // public void calculateAmountAndPoints() {

  // for (Rental rental : _rentals) {
  // this._totalAmount += rental.getAmount();
  // this._points += rental.getPoints(); // updatePoints method in Rental
  // System.out.println(_totalAmount);
  // System.out.println(_points);
  // }
  // }

  // public void printStatement(Customer customer) {
  // try {
  // PrintOutXML.print(customer);
  // } catch (FileNotFoundException e) {
  // e.printStackTrace();
  // } catch (UnsupportedEncodingException e) {
  // e.printStackTrace();
  // } catch (XMLStreamException e) {
  // System.err.println(e);
  // e.printStackTrace();
  // }
  // }

  public String customerStatement() {
    String movieInfo = "";

    for (Rental rental : _rentals) {
      double thisMovieCharge = 0;

      if (rental.isFreeMovie(_points) && _points >= 10) {
        _points = _points - 10;
      } else {
        thisMovieCharge = rental.calculateRentalAmount(thisMovieCharge);
        _points = rental.getPoints();
      }

      movieInfo += "\t<Movie>\n\t\t<Title>" + rental.getMovie().getTitle() + "</Title>\n\t\t<Price>"
          + thisMovieCharge + "</Price>\n\t\t<Duration>" + rental.getDaysRented()
          + "</Duration>\n\t</Movie>\n";
      _totalAmount += thisMovieCharge;
    }

    return printXML(movieInfo, _totalAmount);
  }

  public String printXML(String movieData, double amountDue) {
    String xmlString = "<Record>\n\t<Name>" + getName() + "</Name>\n" + movieData + "\t<AmountDue>" + amountDue
        + "</AmountDue>\n" + "\t<RentalPoints>" + _points + "</RentalPoints>\n</Record>";

    return xmlString;
  }
}