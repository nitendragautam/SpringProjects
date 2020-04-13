package com.nitendratech.bankingapp.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nitendratech.bankingapp.model.BankAccount;
import com.nitendratech.bankingapp.service.BankAccountService;

@Controller
public class BankAccountController {

	// Instantiating object of BankAccountService Class
	private BankAccountService bankAccountService;

	@Autowired(required = true) // Injecting dependency from Config Class
	@Qualifier(value = "bankAccountService")
	public void setBankAccountService(BankAccountService ps) {
		this.bankAccountService = ps;
	}

	// Initial Page Mapping
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/bankAccount/listBankAccount.html", method = RequestMethod.GET)
	public ModelAndView listBankAcconts() {
		List listBankAccounts = Collections.emptyList();

		PagedListHolder pagedListHolder = new PagedListHolder(listBankAccounts);

		ModelAndView mav = new ModelAndView("bankAccountView");
		mav.addObject("pagedListHolder", pagedListHolder);
		return mav;

	}

	/*
	 * Search the Data Given Search term for last Name
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/bankAccount/searchBankAccounts.html")
	public ModelAndView searchData(@RequestParam(required = false) String searchString, HttpServletRequest request,
			HttpServletResponse response) {

		if (searchString != null) {
			if (!StringUtils.hasLength(searchString)) {
				List listLogs = Collections.emptyList();
				PagedListHolder pagedListHolder = new PagedListHolder(listLogs);
				ModelAndView mav = new ModelAndView("bankAccountView");
				mav.addObject("pagedListHolder", pagedListHolder);
				return mav;
			}
			PagedListHolder pagedListHolder = new PagedListHolder(
					this.bankAccountService.searchBankAccountByName(searchString.toLowerCase()));
			pagedListHolder.setPageSize(3);
			ModelAndView mav = new ModelAndView("bankAccountView");
			mav.addObject("pagedListHolder", pagedListHolder);
			mav.addObject("bankAct", new BankAccount());
			request.getSession().setAttribute("BankAccountController_pagedListHolder", pagedListHolder);
			return mav;
		} else {
			PagedListHolder pagedListHolder = (PagedListHolder) request.getSession()
					.getAttribute("BankAccountController_pagedListHolder");
			if (pagedListHolder == null) {
				return new ModelAndView("Error", "message", "Your session has timed out. Please start over again.");
			}

			int page = ServletRequestUtils.getIntParameter(request, "p", 0);
			pagedListHolder.setPage(page);

			ModelAndView mav = new ModelAndView("bankAccountView");
			mav.addObject("bankAct", new BankAccount());
			mav.addObject("pagedListHolder", pagedListHolder);

			return mav;

		}

	}

	// Method to Get Add Form
	@RequestMapping(value = "/bankAccount/add.html", method = RequestMethod.GET)
	public String addgBankAccount(@ModelAttribute("bankAct") BankAccount p, Model model) {
		return "add";
	}

	// For adding the BankAccount Table
	@RequestMapping(value = "/bankAccount/add.html", method = RequestMethod.POST)
	public String addBankAccount(@Valid @ModelAttribute("bankAct") BankAccount p, BindingResult result) {
		if (result.hasErrors()) {
			return "add";
		} else {
			System.out.println(p.getCurrentAccountBalance());
			this.bankAccountService.addBankAccountData(p);

			return "addSuccess";
		}
	}

	@RequestMapping(value = "/bankAccount/update.html", method = RequestMethod.GET)
	public String updategBankAccount(@ModelAttribute("bankAct") BankAccount p, Model model) {

		return "update";
	}

	// For Updating the Bank Account Table
	@RequestMapping(value = "/bankAccount/update.html", method = RequestMethod.POST)
	public String updateBankAccount(@Valid @ModelAttribute("bankAct") BankAccount p, BindingResult result) {
		if (result.hasErrors()) {
			return "update";
		} else {
			this.bankAccountService.updateBankAccountData(p);
			return "updateSuccess";
		}

	}

	// Mapping the Edit
	@RequestMapping("/edit/{id}")
	public String updateBankAccount(@ModelAttribute("bankAct") BankAccount p, @PathVariable("id") int id, Model model) {

		model.addAttribute("bankAct", bankAccountService.getBankAccountDataById(id));
	model.addAttribute("listBankAccounts", this.bankAccountService.listBankAccountData());

		return "update";
	}

	// GET method For Deleting the BankAccount Table
	@RequestMapping(value = "/bankAccount/delete.html",
			method = RequestMethod.GET)
	public String deleteBankAccount(@ModelAttribute("bankAct") BankAccount p) {

		return "deleteBankAccount";
	}

	// Post method For Disabling the Log Table
	@RequestMapping(value = "/bankAccount/delete.html",
			method = RequestMethod.POST)
	public String deleteBankAccountP(@ModelAttribute("bankAct") BankAccount p) {
		this.bankAccountService.deleteBankAccountData(p);
		return "deleteBankAccountSuccess";
	}

	// Mapping the Disable Button
	@RequestMapping(value = "/delete/{id}")
	public String deleteBankAccount(@ModelAttribute("bankAct") BankAccount p, @PathVariable("id") int id, Model model) {

		model.addAttribute("listBankAccounts", this.bankAccountService.listBankAccountData());
		model.addAttribute("bankAct", bankAccountService.getBankAccountDataById(id));

		return "deleteBankAccount";
	}

	

}