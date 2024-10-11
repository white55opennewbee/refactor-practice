package com.refactor.practice;

import com.refactor.practice.movie.CalMoviePriceFactory;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String _name;
	private Vector _rentals;

	public Customer(String _name, Vector _rentals) {
		this._name = _name;
		this._rentals = _rentals;
	}

	public String getName() {
		return _name;
	}

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			double thisAmount = CalMoviePriceFactory.getMoviePrice(each);
			frequentRenterPoints += CalMoviePriceFactory.getFrequentRenterPoints(each);
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle() +
					"\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned" + String.valueOf(frequentRenterPoints) +
				" frequent renter points";
		return result;
	}
}
