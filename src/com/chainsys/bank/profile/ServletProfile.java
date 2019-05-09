package com.chainsys.bank.profile;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.bank.model.Account;
import com.chainsys.bank.model.City;
import com.chainsys.bank.model.CurrentAddress;
import com.chainsys.bank.model.PermanentAddress;
import com.chainsys.bank.model.Profile;
import com.chainsys.bank.model.Users;
import com.chainsys.bank.service.KnowYourCustomerService;
import com.chainsys.bank.service.impl.KnowYourCustomerServiceImpl;

/**
 * Servlet implementation class ServletProfile
 */
@WebServlet("/ServletProfile")
public class ServletProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		KnowYourCustomerService kycService = new KnowYourCustomerServiceImpl();
		City findcity = null;
		CurrentAddress curntaddress = null;
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String surname = request.getParameter("surName");
		char gender = request.getParameter("gender").charAt(0);
		String email = request.getParameter("email");
		long phoneno = Long.parseLong(request.getParameter("Phoneno"));
		LocalDate dateofbirth = LocalDate.parse(request
				.getParameter("DateofBirth"));
		String occupation = request.getParameter("occupation");
		long aadharno = Long.parseLong(request.getParameter("aadharNumber"));
		String pancard = request.getParameter("panNumber");
		String accounttype = request.getParameter("accounttype");
		String permenantaddress1 = request.getParameter("permenantAddress1");
		String permenantaddress2 = request.getParameter("permenantAddress2");
		String permenantcity = request.getParameter("city");
		String permenantpincode = request.getParameter("Pincode");
		// Find Pincode and City
		if (permenantpincode.isEmpty() || permenantpincode.equals(null)) {
			City citypin = new City();
			citypin.setLocation(permenantcity);
			citypin.setPinCode((long) 0);
			findcity = kycService.findCity(citypin);
		} else if (permenantcity.isEmpty() || permenantcity.equals(null)) {
			City citypin = new City();
			citypin.setLocation(null);
			citypin.setPinCode(Long.parseLong(permenantpincode));
			findcity = kycService.findCity(citypin);
		} else {
			findcity = new City();
			findcity.setLocation(permenantcity);
			findcity.setPinCode(Long.parseLong(permenantpincode));
		}

		PermanentAddress prmtaddress = new PermanentAddress();
		prmtaddress.setAddressLineone(permenantaddress1);
		prmtaddress.setAddressLinetwo(permenantaddress2);
		prmtaddress.setCityId(findcity );
		String addresssameas = request.getParameter("addresssameas");
		// Same as Communication Copy current address from permanent address
		if ("address".equals(addresssameas)) {
			curntaddress = new CurrentAddress();
			curntaddress.setAddressLineone(prmtaddress.getAddressLineone());
			curntaddress.setAddressLinetwo(prmtaddress.getAddressLinetwo());
			curntaddress.setCityId(prmtaddress.getCityId());
		} else {
			curntaddress = new CurrentAddress();
			curntaddress.setAddressLineone(request
					.getParameter("currentAddress1"));
			curntaddress.setAddressLinetwo(request
					.getParameter("currentAddress2"));
			curntaddress.setCityId(findcity);
		}
		Users user = new Users();
		user.setFirstName(firstname);
		user.setMiddleName(lastname);
		user.setSurName(surname);
		user.setEmail(email);
		user.setPhoneNumber(phoneno);
		Profile profile = new Profile();
		profile.setGender(gender);
		profile.setDateOfBirth(dateofbirth);
		profile.setOccupdation(occupation);
		profile.setAadharNo(aadharno);
		profile.setPancard(pancard);
		Account accounts = new Account();
		accounts.setAccountType(accounttype);
		Profile profileobj = kycService.findProfile(profile);
		try {
			Profile userExists = kycService.checkExistingProfile(profile,
					accounttype);
			// check Aadharno/Pancard/Acocunt type to restrict duplication
			if (userExists != null) {
				String failed = "<p style='color:red';'font-style: italic;'>Account Already Exists</p>";
				request.setAttribute("MESSAGE", failed);
				RequestDispatcher rd = request
						.getRequestDispatcher("kycForm.jsp");
				rd.forward(request, response);
			} else {
				if ("Savings".equalsIgnoreCase(accounts.getAccountType())) {
					if (kycService.addKYCForm(user, prmtaddress, curntaddress,
							profile, accounts)) {
						String sucess = "<p style='color:green';'font-style: italic;'>Registration Sucessfully</p>";
						request.setAttribute("MESSAGE", sucess);
						RequestDispatcher rd = request
								.getRequestDispatcher("kycForm.jsp");
						rd.forward(request, response);
					} else {
						String failed = "<p style='color:red';'font-style: italic;'>Registration Failed</p>";
						request.setAttribute("MESSAGE", failed);
						RequestDispatcher rd = request
								.getRequestDispatcher("kycForm.jsp");
						rd.forward(request, response);
					}
				} else {
					kycService.createCurrentAccount(profileobj.getUserId(),
							accounts);
					String sucess = "<p style='color:green';'font-style: italic;'>Registration Sucessfully</p>";
					request.setAttribute("MESSAGE", sucess);
					RequestDispatcher rd = request
							.getRequestDispatcher("kycForm.jsp");
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			String error = "<p style='color:red';'font-style: italic;'>"
					+ e.getMessage() + "</p>";
			request.setAttribute("MESSAGE", error);
			RequestDispatcher rd = request.getRequestDispatcher("kycForm.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}

	}

}
