import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RentalView extends JFrame {

	private Transaction aTrans = new Transaction();
	private Customer aCustomer = new Customer();
	private Car aCar = new Car();
	WarningReserve openWarningReserve;
	WarningCustomer openWarningCustomer;
	WarningCar openWarningCar;

	Container pane = getContentPane();
	private JPanel mainP, reserveP, customerP, carP, finalP; // panels for CardLayout

//////////////////////////////////////////////welcome////////////////////////////////////////////////////
	private JLabel titleL, dateL; // inside the panel of mainP
	private JButton mainNextB;
	private JComboBox cMCB, cDCB, cYCB;

//////////////////////////////////////////////date reservation////////////////////////////////////////////
	private JLabel dayL, pickupDateL, returnDateL, birthDateL; // inside the panel of reserveP
	private JComboBox pUMCB, pUDCB, pUYCB, rMCB, rDCB, rYCB, bMCB, bDCB, bYCB;
	private JLabel dateChecker, ageChecker;
	private JButton reserveNextB, reserveBackB;

////////////////////////////////////////////////customer info//////////////////////////////////////
	private JLabel customerL, firstNameL, lastNameL, locationL, contactL, genderL, ageL, statusL, showAgeL; // inside
																											// the panel
																											// of
																											// customerP
	private JTextField firstNameTF, lastNameTF, locationTF, contactTF, genderTF, statusTF;
	private JLabel firstNameChecker, lastNameChecker, genderChecker, statusChecker, locationChecker, contactChecker;
	private JButton customerNextB, customerBackB;

////////////////////////////////////////////////pick a car/////////////////////////////////
	private JLabel carL; // inside the panel of carP
	private JButton firstCarB, secondCarB, thirdCarB, forthCarB, carNextB, carBackB;
	private JTextArea carDetailsTA;

///////////////////////////////////////////////receipt/////////////////////////////////////
	private JTextArea receiptA;

	public RentalView() {
		//////////////////////////////////////////////////////// First Panel "Welcome"
		//////////////////////////////////////////////////////// (mainP)///////////////////////////////////
		// -------------------------------------------------setting PANEL and LABELS for
		//////////////////////////////////////////////////////// Welcome section
		pane.setLayout(new CardLayout());
		mainP = new JPanel(null);
		mainP.setBackground(Color.WHITE);

		ImageIcon titleImage = new ImageIcon("logo01.PNG");
		titleL = new JLabel(titleImage);
		titleL.setBounds(30, 40, 310, 300);
		mainP.add(titleL);

		dateL = new JLabel("DATE TODAY"); // date today label
		dateL.setFont(new Font("Serif", Font.BOLD, 23));
		dateL.setForeground(Color.RED);
		dateL.setBounds(360, 210, 150, 25);
		mainP.add(dateL);

		// --------------------------------------COMBO BOX for current date
		String[] currentMonthCB = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
				"Dec" };
		cMCB = new JComboBox(currentMonthCB);
		cMCB.setBounds(360, 240, 60, 25);
		mainP.add(cMCB);

		Integer[] currentDateCB = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
				24, 25, 26, 27, 28, 29, 30, 31 };
		cDCB = new JComboBox(currentDateCB);
		cDCB.setBounds(425, 240, 60, 25);
		mainP.add(cDCB);

		Integer[] currentYearCB = { 2020, 2021, 2022, 2023, 2024 };
		cYCB = new JComboBox(currentYearCB);
		cYCB.setBounds(490, 240, 60, 25);
		mainP.add(cYCB);

		// ------------------------------------BUTTONS to go reserve section
		ImageIcon mainNextImage = new ImageIcon("next.GIF");
		mainNextB = new JButton(mainNextImage);
		mainNextB.setBackground(Color.WHITE);
		mainNextB.addActionListener(new mainNextButton());
		mainNextB.setBounds(460, 300, 100, 50);
		mainNextB.setRolloverEnabled(true);
		mainNextB.setRolloverIcon(mainNextImage);
		mainNextB.setPressedIcon(mainNextImage);
		mainNextB.setActionCommand("NextToReserve");
		mainP.add(mainNextB);
		pane.add(mainP, "welcomeForm");

		////////////////////////////////////////////////// Second Panel "reserve"
		////////////////////////////////////////////////// (reserveP)//////////////////////////////////////////////
		// -----------------------------------------LEBELS for reservation date.
		reserveP = new JPanel(null);
		reserveP.setBackground(Color.WHITE);

		dayL = new JLabel("Reserve Rental Day(s):");
		dayL.setFont(new Font("Verdana", Font.PLAIN, 18));
		dayL.setForeground(Color.BLACK);
		dayL.setBounds(50, 1, 250, 100);
		reserveP.add(dayL);

		pickupDateL = new JLabel("Pick-up Date:");
		pickupDateL.setFont(new Font("Serif", Font.BOLD, 15));
		pickupDateL.setForeground(Color.BLUE);
		pickupDateL.setBounds(50, 40, 100, 100);
		reserveP.add(pickupDateL);

		returnDateL = new JLabel("Return Date:");
		returnDateL.setFont(new Font("Serif", Font.BOLD, 15));
		returnDateL.setForeground(Color.BLUE);
		returnDateL.setBounds(50, 80, 100, 100);
		reserveP.add(returnDateL);

		birthDateL = new JLabel("Birth Date:");
		birthDateL.setFont(new Font("Serif", Font.BOLD, 15));
		birthDateL.setForeground(Color.BLUE);
		birthDateL.setBounds(60, 150, 100, 100);
		reserveP.add(birthDateL);

		// -------------------------------------------------CHECK BOX for pickup date,
		// return date, birth date
		// ---------------------------------------------Pick up date section
		String[] pickUpMonthCB = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		pUMCB = new JComboBox(pickUpMonthCB);
		pUMCB.setBounds(150, 80, 60, 25);
		reserveP.add(pUMCB);

		Integer[] pickUpDateCB = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
				24, 25, 26, 27, 28, 29, 30, 31 };
		pUDCB = new JComboBox(pickUpDateCB);
		pUDCB.setBounds(215, 80, 60, 25);
		reserveP.add(pUDCB);

		Integer[] pickUpYearCB = { 2019, 2020, 2021, 2022, 2022 };
		pUYCB = new JComboBox(pickUpYearCB);
		pUYCB.setBounds(280, 80, 60, 25);
		reserveP.add(pUYCB);

		// -------------------------------------------return date section
		String[] returnMonthCB = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		rMCB = new JComboBox(returnMonthCB);
		rMCB.setBounds(150, 120, 60, 25);
		reserveP.add(rMCB);

		Integer[] returnDateCB = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
				24, 25, 26, 27, 28, 29, 30, 31 };
		rDCB = new JComboBox(returnDateCB);
		rDCB.setBounds(215, 120, 60, 25);
		reserveP.add(rDCB);

		Integer[] returnYearCB = { 2019, 2020, 2021, 2022, 2022 };
		rYCB = new JComboBox(returnYearCB);
		rYCB.setBounds(280, 120, 60, 25);
		reserveP.add(rYCB);

		// ---------------------------------------------birth date section
		String[] birthMonthCB = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		bMCB = new JComboBox(birthMonthCB);
		bMCB.setBounds(150, 190, 60, 25);
		reserveP.add(bMCB);

		Integer[] birthDateCB = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
				25, 26, 27, 28, 29, 30, 31 };
		bDCB = new JComboBox(birthDateCB);
		bDCB.setBounds(215, 190, 60, 25);
		reserveP.add(bDCB);

		Integer[] birthYearCB = { 1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980, 1981, 1982, 1983,
				1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000,
				2001, 2002 };
		bYCB = new JComboBox(birthYearCB);
		bYCB.setBounds(280, 190, 60, 25);
		reserveP.add(bYCB);

		// ---------------------------------------------checker for date
		dateChecker = new JLabel("");
		dateChecker.setFont(new Font("Serif", Font.BOLD, 15));
		dateChecker.setBounds(350, 83, 100, 100);
		reserveP.add(dateChecker);

		ageChecker = new JLabel("");
		ageChecker.setFont(new Font("Serif", Font.BOLD, 15));
		ageChecker.setBounds(350, 153, 100, 100);
		reserveP.add(ageChecker);

		// --------------------------------------BUTTONS
		// -----------------------------------------------to go customer section
		ImageIcon dateNextImage = new ImageIcon("customer.GIF");
		reserveNextB = new JButton(dateNextImage);
		reserveNextB.setBackground(Color.WHITE);
		reserveNextB.addActionListener(new reserveNextButton());
		reserveNextB.setBounds(460, 300, 100, 50);
		reserveNextB.setActionCommand("NextToCustomer");
		reserveP.add(reserveNextB);

		// ---------------------------------------------------to go back welcome section
		// ImageIcon dateNextImage = new ImageIcon("../images/Arrow-Right-icon.GIF");
		ImageIcon dateBackImage = new ImageIcon("back.GIF");
		reserveBackB = new JButton(dateBackImage);
		reserveBackB.setBackground(Color.WHITE);
		reserveBackB.setBounds(330, 300, 100, 50);
		reserveBackB.addActionListener(new reserveBackButton());
		reserveBackB.setActionCommand("BackToWelcome");
		reserveP.add(reserveBackB);
		pane.add(reserveP, "reserveForm");

		////////////////////////////////////////////////////////// third Panel
		////////////////////////////////////////////////////////// "customer"
		////////////////////////////////////////////////////////// (customerP)/////////////////////////////////////
		// ---------------------------------------------LEBELS for customer details
		customerP = new JPanel(null);
		customerP.setBackground(Color.WHITE);

		customerL = new JLabel("Customer's Data");
		customerL.setFont(new Font("Verdana", Font.PLAIN, 18));
		customerL.setForeground(Color.BLACK);
		customerL.setBounds(50, 10, 250, 30);
		customerP.add(customerL);

		firstNameL = new JLabel("First Name:");
		firstNameL.setFont(new Font("Serif", Font.BOLD, 15));
		firstNameL.setForeground(Color.BLUE);
		firstNameL.setBounds(50, 60, 250, 30);
		customerP.add(firstNameL);

		lastNameL = new JLabel("Last Name:");
		lastNameL.setFont(new Font("Serif", Font.BOLD, 15));
		lastNameL.setForeground(Color.BLUE);
		lastNameL.setBounds(50, 95, 250, 30);
		customerP.add(lastNameL);

		genderL = new JLabel("Gender:");
		genderL.setFont(new Font("Serif", Font.BOLD, 15));
		genderL.setForeground(Color.BLUE);
		genderL.setBounds(50, 130, 250, 30);
		customerP.add(genderL);

		statusL = new JLabel("Status:");
		statusL.setFont(new Font("Serif", Font.BOLD, 15));
		statusL.setForeground(Color.BLUE);
		statusL.setBounds(50, 165, 250, 30);
		customerP.add(statusL);

		locationL = new JLabel("Location:");
		locationL.setFont(new Font("Serif", Font.BOLD, 15));
		locationL.setForeground(Color.BLUE);
		locationL.setBounds(50, 200, 250, 30);
		customerP.add(locationL);

		contactL = new JLabel("Contact:");
		contactL.setFont(new Font("Serif", Font.BOLD, 15));
		contactL.setForeground(Color.BLUE);
		contactL.setBounds(50, 235, 250, 30);
		customerP.add(contactL);

		ageL = new JLabel("Age:");
		ageL.setFont(new Font("Serif", Font.BOLD, 15));
		ageL.setForeground(Color.BLUE);
		ageL.setBounds(50, 270, 250, 30);
		customerP.add(ageL);

		showAgeL = new JLabel("");
		showAgeL.setFont(new Font("Serif", Font.PLAIN, 15));
		showAgeL.setHorizontalAlignment(JTextField.CENTER);
		showAgeL.setForeground(Color.BLUE);
		showAgeL.setBounds(145, 270, 60, 30);
		customerP.add(showAgeL);

		// -------------------------------------TEXT FIELD for customer details and get
		// data from keyboard section
		firstNameTF = new JTextField(" First Name ");
		firstNameTF.setHorizontalAlignment(JTextField.CENTER);
		firstNameTF.setForeground(Color.GRAY);
		firstNameTF.setBounds(150, 60, 250, 30);
		customerP.add(firstNameTF);

		lastNameTF = new JTextField(" Last Name ");
		lastNameTF.setHorizontalAlignment(JTextField.CENTER);
		lastNameTF.setForeground(Color.GRAY);
		lastNameTF.setBounds(150, 95, 250, 30);
		customerP.add(lastNameTF);

		genderTF = new JTextField("M/F");
		genderTF.setHorizontalAlignment(JTextField.CENTER);
		genderTF.setForeground(Color.GRAY);
		genderTF.setBounds(150, 130, 50, 30);
		customerP.add(genderTF);

		statusTF = new JTextField("S/Ma");
		statusTF.setHorizontalAlignment(JTextField.CENTER);
		statusTF.setForeground(Color.GRAY);
		statusTF.setBounds(150, 165, 50, 30);
		customerP.add(statusTF);

		locationTF = new JTextField(" Address ");
		locationTF.setHorizontalAlignment(JTextField.CENTER);
		locationTF.setForeground(Color.GRAY);
		locationTF.setBounds(150, 200, 250, 30);
		customerP.add(locationTF);

		contactTF = new JTextField(" Contact Number ");
		contactTF.setHorizontalAlignment(JTextField.CENTER);
		contactTF.setForeground(Color.GRAY);
		contactTF.setBounds(150, 235, 250, 30);
		customerP.add(contactTF);

		// -----------------checker customer

		firstNameChecker = new JLabel("");
		firstNameChecker.setFont(new Font("Serif", Font.BOLD, 15));
		firstNameChecker.setBounds(410, 25, 100, 100);
		customerP.add(firstNameChecker);

		lastNameChecker = new JLabel("");
		lastNameChecker.setFont(new Font("Serif", Font.BOLD, 15));
		lastNameChecker.setBounds(410, 60, 100, 100);
		customerP.add(lastNameChecker);

		genderChecker = new JLabel("");
		genderChecker.setFont(new Font("Serif", Font.BOLD, 15));
		genderChecker.setBounds(210, 95, 100, 100);
		customerP.add(genderChecker);

		statusChecker = new JLabel("");
		statusChecker.setFont(new Font("Serif", Font.BOLD, 15));
		statusChecker.setBounds(210, 130, 100, 100);
		customerP.add(statusChecker);

		locationChecker = new JLabel("");
		locationChecker.setFont(new Font("Serif", Font.BOLD, 15));
		locationChecker.setBounds(410, 165, 100, 100);
		customerP.add(locationChecker);

		contactChecker = new JLabel("");
		contactChecker.setFont(new Font("Serif", Font.BOLD, 15));
		contactChecker.setBounds(410, 200, 100, 100);
		customerP.add(contactChecker);

		// -------------------------------------------BUTTONS for customer
		// ----------------------------------------------to go pick a car section
		ImageIcon customerNextImage = new ImageIcon("car.GIF");
		customerNextB = new JButton(customerNextImage);
		customerNextB.setBackground(Color.WHITE);
		customerNextB.setBounds(460, 300, 100, 50);
		customerNextB.setRolloverEnabled(true);
		customerNextB.setRolloverIcon(customerNextImage);
		customerNextB.setPressedIcon(customerNextImage);
		customerNextB.addActionListener(new customerNextButton());
		customerNextB.setActionCommand("NextToPickCar");
		customerP.add(customerNextB);

		// --------------------------------------------to go back reserve section
		ImageIcon customerBackImage = new ImageIcon("customer_back.GIF");
		customerBackB = new JButton(customerBackImage);
		customerBackB.setBackground(Color.WHITE);
		customerBackB.setBounds(330, 300, 100, 50);
		customerBackB.setRolloverEnabled(true);
		customerBackB.setRolloverIcon(customerBackImage);
		customerBackB.setPressedIcon(customerBackImage);
		customerBackB.addActionListener(new customerBackButton());
		customerBackB.setActionCommand("backToReserve");
		customerP.add(customerBackB);
		pane.add(customerP, "customerForm");

		///////////////////////////////////////////////////// fourth Panel "pick a car"
		///////////////////////////////////////////////////// (carP)//////////////////////////////////////////
		// --------------------------------LABELS for pick a car
		carP = new JPanel(null);
		carP.setBackground(Color.WHITE);

		carL = new JLabel("Car Detail's");
		carL.setFont(new Font("Verdana", Font.PLAIN, 18));
		carL.setForeground(Color.BLACK);
		carL.setBounds(435, 4, 140, 30);
		carP.add(carL);

		// ------------------------------------BUTTONS for pick a car
		// ---------------------------------------------------------Pick Car Buttton]
		// -------------------------------------first car button
		ImageIcon firstCarImage = new ImageIcon("corolla.jpg");
		firstCarB = new JButton(firstCarImage);
		firstCarB.setBackground(Color.WHITE);
		firstCarB.addActionListener(new firstCarButton());
		firstCarB.setRolloverEnabled(true);
		firstCarB.setRolloverIcon(firstCarImage);
		firstCarB.setPressedIcon(firstCarImage);
		firstCarB.setBounds(10, 10, 190, 130);
		carP.add(firstCarB);

		// ---------------------------------second car button
		ImageIcon secondCarImage = new ImageIcon("hiace.jpg");
		secondCarB = new JButton(secondCarImage);
		secondCarB.setBackground(Color.WHITE);
		secondCarB.addActionListener(new secondCarButton());
		secondCarB.setRolloverEnabled(true);
		secondCarB.setRolloverIcon(secondCarImage);
		secondCarB.setPressedIcon(secondCarImage);
		secondCarB.setBounds(210, 10, 190, 130);
		carP.add(secondCarB);

		// ---------------------------------------third car button
		ImageIcon thirdCarImage = new ImageIcon("ambulance.jpg");
		thirdCarB = new JButton(thirdCarImage);
		thirdCarB.setBackground(Color.WHITE);
		thirdCarB.addActionListener(new thirdCarButton());
		thirdCarB.setRolloverEnabled(true);
		thirdCarB.setRolloverIcon(thirdCarImage);
		thirdCarB.setPressedIcon(thirdCarImage);
		thirdCarB.setBounds(10, 150, 190, 130);
		carP.add(thirdCarB);

		// ------------------------------------------fourth car button
		ImageIcon forthCarImage = new ImageIcon("allion.jpg");
		forthCarB = new JButton(forthCarImage);
		forthCarB.setBackground(Color.WHITE);
		forthCarB.addActionListener(new forthCarButton());
		forthCarB.setRolloverEnabled(true);
		forthCarB.setRolloverIcon(forthCarImage);
		forthCarB.setPressedIcon(forthCarImage);
		forthCarB.setBounds(210, 150, 190, 130);
		carP.add(forthCarB);

		// -------------------------------------------------to go receipt section (Final
		// step)
		ImageIcon carNextImage = new ImageIcon("submit.GIF");
		carNextB = new JButton(carNextImage);
		carNextB.setBackground(Color.WHITE);
		carNextB.setBounds(460, 300, 100, 50);
		carNextB.addActionListener(new finalStepButton());
		carNextB.setRolloverEnabled(true);
		carNextB.setRolloverIcon(carNextImage);
		carNextB.setPressedIcon(carNextImage);
		carP.add(carNextB);

		// --------------------------------------------------------------------to go
		// back customer section
		ImageIcon carBackImage = new ImageIcon("car_back.GIF");
		carBackB = new JButton(carBackImage);
		carBackB.setBackground(Color.WHITE);
		carBackB.addActionListener(new carBackButton());
		carBackB.setBounds(330, 300, 100, 50);
		carBackB.setRolloverEnabled(true);
		carBackB.setRolloverIcon(carBackImage);
		carBackB.setPressedIcon(carBackImage);
		carBackB.setActionCommand("BackToCustomer");
		carP.add(carBackB);

		// -----------------------------------TEXT AREA to pick a car putting details
		// for car when we click buttons over top
		carDetailsTA = new JTextArea(6, 25);
		carDetailsTA.setText(
				"=>01. Toyota | 2009 \n=>02. Hiace | 2012 \n=>03. Ambulance | 2010 \n=>04. Toyota Allion | 2018");
		carDetailsTA.setAutoscrolls(true);
		carDetailsTA.setEditable(false);
		carDetailsTA.setBounds(420, 40, 150, 240);
		carP.add(carDetailsTA);
		pane.add(carP, "pickCarForm");

		/////////////////////////////////////////////////////// last panel "receipt"
		/////////////////////////////////////////////////////// (finalP)/////////////////////////////////////
		finalP = new JPanel(null);

		receiptA = new JTextArea(2000, 2000);
		receiptA.setFont(new Font("Serif", Font.PLAIN, 15));
		receiptA.setForeground(Color.BLUE);
		receiptA.setEditable(false);
		receiptA.setBounds(80, 30, 400, 800); //
		finalP.add(receiptA);
		pane.add(finalP, "receipt");

	}

	//////////////////////////////////////////////////////////// CTROLLERS//////////////////////////////////////////////
	// -------------------------------------main (go to reserveForm)
	private class mainNextButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("NextToReserve")) {
				cL.show(pane, "reserveForm");
			}
		}
	}

	// ------------------------------------------------reserve
	// ---------------------------------------------------go to customerForm
	// -----------------------------------------------including the validation if
	// requirements are meet for Next Panel
	private class reserveNextButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("NextToCustomer")) {

				String currentMonth, pickUpMonth, returnMonth, birthMonth;
				int currentDate, currentYear, pickUpDate, pickUpYear, returnDate, returnYear, birthDate, birthYear;

				currentMonth = (String) cMCB.getSelectedItem();
				currentDate = (int) cDCB.getSelectedItem();
				currentYear = (int) cYCB.getSelectedItem();

				pickUpMonth = (String) pUMCB.getSelectedItem();
				pickUpDate = (int) pUDCB.getSelectedItem();
				pickUpYear = (int) pUYCB.getSelectedItem();

				returnMonth = (String) rMCB.getSelectedItem();
				returnDate = (int) rDCB.getSelectedItem();
				returnYear = (int) rYCB.getSelectedItem();

				birthMonth = (String) bMCB.getSelectedItem();
				birthDate = (int) bDCB.getSelectedItem();
				birthYear = (int) bYCB.getSelectedItem(); // saving dates for transaction, validation for date and age,
															// will prompt to WarningReserve

				aTrans.setTransaction(aCustomer, aCar, currentMonth, currentDate, currentYear, pickUpMonth, pickUpDate,
						pickUpYear, returnMonth, returnDate, returnYear, birthMonth, birthDate, birthYear);
				showAgeL.setText(aTrans.toStringAge()); // show the text of age from class

				if (!aTrans.toStringDateChecker().equals("TRUE")) { // check if valid or not to pick date and return
																	// date
					dateChecker.setForeground(Color.RED);
					dateChecker.setText("Invalid!");
				}

				else {
					dateChecker.setForeground(Color.GREEN);
					dateChecker.setText("Valid");
				}

				if (!aTrans.toStringAgeChecker().equals("TRUE")) { // for age validation
					ageChecker.setForeground(Color.RED);
					ageChecker.setText("Invalid!");
				}

				else {
					ageChecker.setForeground(Color.GREEN);
					ageChecker.setText("Valid");
				}

				if (aTrans.toStringDateChecker().equals("TRUE") && aTrans.toStringAgeChecker().equals("TRUE")) { // checker
																													// to
																													// proceed
																													// next
																													// panel
					cL.show(pane, "customerForm");
				}

				else { // pop up window for warning to customer
					if (openWarningReserve == null) {
						openWarningReserve = new WarningReserve();
						ImageIcon warningReserveImage = new ImageIcon("warning_top_icon.GIF");
						openWarningReserve.setIconImage(warningReserveImage.getImage());
						openWarningReserve.setTitle("WARNING !!");
						openWarningReserve.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						openWarningReserve.setSize(300, 150);
						openWarningReserve.setVisible(true);
						openWarningReserve.setResizable(false);
					}

					else {
						openWarningReserve.setVisible(!openWarningReserve.isVisible());
					}
				}
			}
		}
	}

	// -------------------------------------------------go back to welcomeForm
	private class reserveBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("BackToWelcome")) {
				cL.show(pane, "welcomeForm");
			}
		}
	}

	// ------------------------------------------customer
	// -----------------------------------------------go to pickCarForm
	// -----------------------------------------------including the validation if
	// requirements are meet for Next Panel
	private class customerNextButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("NextToPickCar")) {

				String firstName, lastName, gender, status, location, contact;

				firstName = firstNameTF.getText();
				lastName = lastNameTF.getText();
				gender = genderTF.getText();
				status = statusTF.getText();
				location = locationTF.getText();
				contact = contactTF.getText();

				aCustomer.setCustomer(firstName, lastName, gender, status, location, contact);

				if (aCustomer.getFirstName().equals(" First Name ")) { // checker for firstname if empty , its invalid
					firstNameChecker.setForeground(Color.RED);
					firstNameChecker.setText("Invalid!");
				}

				else {
					firstNameChecker.setForeground(Color.GREEN);
					firstNameChecker.setText("Valid");
				}

				if (aCustomer.getLastName().equals(" Last Name ")) { // for last name
					lastNameChecker.setForeground(Color.RED);
					lastNameChecker.setText("Invalid!");
				}

				else {
					lastNameChecker.setForeground(Color.GREEN);
					lastNameChecker.setText("Valid");
				}

				if (aCustomer.getGender().equals("M/F")) { // for gender
					genderChecker.setForeground(Color.RED);
					genderChecker.setText("Invalid!");
				}

				else {
					genderChecker.setForeground(Color.GREEN);
					genderChecker.setText("Valid");
				}

				if (aCustomer.getStatus().equals("S/Ma")) { // for status
					statusChecker.setForeground(Color.RED);
					statusChecker.setText("Invalid!");
				}

				else {
					statusChecker.setForeground(Color.GREEN);
					statusChecker.setText("Valid");
				}

				if (aCustomer.getLocation().equals(" Address ")) { // for location
					locationChecker.setForeground(Color.RED);
					locationChecker.setText("Invalid!");
				}

				else {
					locationChecker.setForeground(Color.GREEN);
					locationChecker.setText("Valid");
				}

				if (aCustomer.getContact().equals(" Contact Number ")) { // for contact
					contactChecker.setForeground(Color.RED);
					contactChecker.setText("Invalid!");
				}

				else {
					contactChecker.setForeground(Color.GREEN);
					contactChecker.setText("Valid");
				}

				if (!aCustomer.getFirstName().equals(" First Name ") && !aCustomer.getLastName().equals(" Last Name ")
						&& !aCustomer.getGender().equals("M/F") && !aCustomer.getStatus().equals("S/Ma")
						&& !aCustomer.getLocation().equals(" Address ")
						&& !aCustomer.getContact().equals(" Contact Number ")) {
					firstNameTF.setText(" First Name "); // if all of the above is valid , proceed to Car Form
					lastNameTF.setText(" Last Name ");
					genderTF.setText("M/F");
					statusTF.setText("S/Ma");
					locationTF.setText(" Complete Address ");
					contactTF.setText(" Contact Number ");
					cL.show(pane, "pickCarForm");
				}

				else { // if invalid, pop out window for warning
					if (openWarningCustomer == null) {
						openWarningCustomer = new WarningCustomer();
						ImageIcon warningCustomerImage = new ImageIcon("warning_top_icon.GIF");
						openWarningCustomer.setIconImage(warningCustomerImage.getImage());
						openWarningCustomer.setTitle("WARNING INVALID!!");
						openWarningCustomer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						openWarningCustomer.setSize(300, 150);
						openWarningCustomer.setVisible(true);
						openWarningCustomer.setResizable(false);
					}

					else {
						openWarningCustomer.setVisible(!openWarningCustomer.isVisible());
					}
				}
			}
		}
	}

	// ----------------------------------------------go back to reserveForm
	private class customerBackButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("backToReserve")) {
				cL.show(pane, "reserveForm");
			}
		}
	}

	// --------------------------------------------car
	// ----------------------------------------------------go back to customerForm
	private class firstCarButton implements ActionListener { // button to show car details
		public void actionPerformed(ActionEvent event) {

			carDetailsTA.setText("");
			carDetailsTA.setText(
					"Brand: Toytota Corolla X\nPlate #: Dhaka Metro ga \nType: Private car\nModel: 2009\nColor: white\nRental Price: BDT 2000.00\n\n.");
			carNextB.setActionCommand("Car1");
		}
	}

	private class secondCarButton implements ActionListener { // button to show car details
		public void actionPerformed(ActionEvent event) {

			carDetailsTA.setText("");
			carDetailsTA.setText(
					"Brand: Hi-ace\nPlate #: Dhaka Metro ba\nType: Micro-bus\nModel: 2012\nColor: Dirty White\nRental Price: BDT 7000.00\n\n.");
			carNextB.setActionCommand("Car2");
		}
	}

	private class thirdCarButton implements ActionListener { // button to show car details
		public void actionPerformed(ActionEvent event) {

			carDetailsTA.setText("");
			carDetailsTA.setText(
					"Brand: Mitsubishi\nPlate #: Dhaka metro ha\nType: Ambulance\nModel: 2010\nColor: Blue\nRental Price: BDT 1000.00\n\n.");
			carNextB.setActionCommand("Car3");
		}
	}

	private class forthCarButton implements ActionListener { // button to show car details
		public void actionPerformed(ActionEvent event) {

			carDetailsTA.setText("");
			carDetailsTA.setText(
					"Brand: Toyota Allion\nPlate #: Dhaka metro ga\nType: Private car\nModel: 2018\nColor: Red\nRental Price: BDT 4000.00\n\n.");
			carNextB.setActionCommand("Car4");
		}
	}

	private class finalStepButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("Car1")) { // passing the pick-up details to car details class and final
															// transactions.

				String carType = "Totyota Corolla", carModel = "2009";
				double carPrice = 2000.00;

				aCar.setCar(carType, carModel, carPrice);

				try { // to save in file Transaction_Inventory
					aTrans.saveToFile();
				} catch (IOException e) {
				}

				receiptA.setText(aTrans.toStringReceipt());
				cL.show(pane, "receipt");
			}

			else if (event.getActionCommand().equals("Car2")) { // pass the details of car.

				String carType = "Hiace", carModel = "2012";
				double carPrice = 7000.00;

				aCar.setCar(carType, carModel, carPrice);

				try { // to save in file Transaction_Inventory
					aTrans.saveToFile();
				} catch (IOException e) {
				}

				receiptA.setText(aTrans.toStringReceipt());
				cL.show(pane, "receipt");
			}

			else if (event.getActionCommand().equals("Car3")) { // pass the details to car.

				String carType = "Ambulance", carModel = "2010";
				double carPrice = 1000.00;

				aCar.setCar(carType, carModel, carPrice);

				try { // to save in file Transaction_Inventory
					aTrans.saveToFile();
				} catch (IOException e) {
				}

				receiptA.setText(aTrans.toStringReceipt());
				cL.show(pane, "receipt");
			}

			else if (event.getActionCommand().equals("Car4")) { // pass the details to car.

				String carType = "Toyota Allion", carModel = "2018";
				double carPrice = 4000.00;

				aCar.setCar(carType, carModel, carPrice);

				try { // to save in file Transaction_Inventory
					aTrans.saveToFile();
				} catch (IOException e) {
				}

				receiptA.setText(aTrans.toStringReceipt());
				cL.show(pane, "receipt");
			}

			else { // if customer haven't yet pick a car, show the warning information
				if (openWarningCar == null) {
					openWarningCar = new WarningCar();
					ImageIcon warningCarImage = new ImageIcon("warning_top_icon.GIF");
					openWarningCar.setIconImage(warningCarImage.getImage());
					openWarningCar.setTitle("WARNING INVALID!!");
					openWarningCar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					openWarningCar.setSize(300, 150);
					openWarningCar.setVisible(true);
					openWarningCar.setResizable(false);
				}

				else {
					openWarningCar.setVisible(!openWarningCar.isVisible());
				}
			}
		}
	}

	private class carBackButton implements ActionListener { // go back to customer form when it is clicked and performed
		public void actionPerformed(ActionEvent event) {
			CardLayout cL = (CardLayout) pane.getLayout();

			if (event.getActionCommand().equals("BackToCustomer")) {
				cL.show(pane, "customerForm");
			}
		}
	}
}