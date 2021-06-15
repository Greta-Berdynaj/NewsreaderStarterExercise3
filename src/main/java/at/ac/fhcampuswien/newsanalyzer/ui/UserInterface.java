package at.ac.fhcampuswien.newsanalyzer.ui;


import at.ac.fhcampuswien.newsanalyzer.ctrl.Controller;
import at.ac.fhcampuswien.newsanalyzer.ctrl.NewsApiException;
import at.ac.fhcampuswien.newsapi.NewsApi;
import at.ac.fhcampuswien.newsapi.NewsApiBuilder;
import at.ac.fhcampuswien.newsapi.enums.Category;
import at.ac.fhcampuswien.newsapi.enums.Country;
import at.ac.fhcampuswien.newsapi.enums.Endpoint;
import at.ac.fhcampuswien.newsapi.enums.Language;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInterface 
{
	private Controller ctrl = new Controller();

	public void getDataFromCtrl1(){
		System.out.println("MONEY");

		ctrl.process("444f194b0f8c4dce9a58789ed50a2555", "money", Endpoint.TOP_HEADLINES, Country.at, Category.business, Language.de);
	}

	public void getDataFromCtrl2(){
		// TODO implement me
		System.out.println("CORONA");
		ctrl.process("444f194b0f8c4dce9a58789ed50a2555", "corona", Endpoint.TOP_HEADLINES, Country.at, Category.health, Language.de);
	}

	public void getDataFromCtrl3(){
		// TODO implement me
		System.out.println("BALL");
		ctrl.process("444f194b0f8c4dce9a58789ed50a2555", "ball", Endpoint.TOP_HEADLINES, Country.at, Category.sports, Language.de);
	}
	
	public void getDataForCustomInput(){
		// TODO implement me

		System.out.println("User Input");
		Scanner scanner = new Scanner(System.in);
		String ScanQ = scanner.next();
		Endpoint ScanEndPoint = Endpoint.valueOf(scanner.next());
		Country ScanCountry = Country.valueOf(scanner.next());
		Category ScanCategory = Category.valueOf(scanner.next());
		Language ScanLanguage = Language.valueOf(scanner.next());

		ctrl.process("444f194b0f8c4dce9a58789ed50a2555",ScanQ,ScanEndPoint, ScanCountry, ScanCategory, ScanLanguage );
	}


	public void start(){
		Menu<Runnable> menu = new Menu<>("User Interface");
		menu.setTitle("Wählen Sie aus:");
		menu.insert("a", "Read about money", this::getDataFromCtrl1);
		menu.insert("b", "Read about corona", this::getDataFromCtrl2);
		menu.insert("c", "Read about ball", this::getDataFromCtrl3);
		menu.insert("d", "User Input:",this::getDataForCustomInput);
		menu.insert("q", "Quit", null);
		Runnable choice;
		while ((choice = menu.exec()) != null) {
			 choice.run();
		}
		System.out.println("Program finished");
	}


    protected String readLine() {
		String value = "\0";
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			value = inReader.readLine();
        } catch (IOException ignored) {
		}
		return value.trim();
	}

	protected Double readDouble(int lowerlimit, int upperlimit) 	{
		Double number = null;
        while (number == null) {
			String str = this.readLine();
			try {
				number = Double.parseDouble(str);
            } catch (NumberFormatException e) {
                number = null;
				System.out.println("Please enter a valid number:");
				continue;
			}
            if (number < lowerlimit) {
				System.out.println("Please enter a higher number:");
                number = null;
            } else if (number > upperlimit) {
				System.out.println("Please enter a lower number:");
                number = null;
			}
		}
		return number;
	}
}
