package com.amazon.automation.Amazon_Automation;
//checking if a user can successfully edit their profile informations on amazon


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.amazon.automation.Amazon_Automation.Listeners_Class.class)

public class Amazon_EditProfileInfo extends LaunchQuit {
	@Test(retryAnalyzer=com.amazon.automation.Amazon_Automation.Retry_Logic.class)
	public void editProfileInfo() throws EncryptedDocumentException, IOException {
		

		Amazon_HomePage homepage = new Amazon_HomePage(driver);
		homepage.hoverover_accountandlists(driver);
		homepage.click_signin_button(driver);

		Amazon_SigninPage signin = new Amazon_SigninPage(driver);
		signin.enter_email_or_mobileNumber();
		signin.click_continue_button();
		signin.enter_password();
		signin.click_signin_button(driver);

		homepage.hoverover_accountandlists(driver);
		homepage.click_manage_profiles_button();
		homepage.click_view_button(driver);

		Amazon_ProfileHubPage profile_edit = new Amazon_ProfileHubPage(driver);
		//profile_edit.edit_profile_name(driver);

		// preferred department
		profile_edit.click_preferred_department(driver);
		profile_edit.add_men_preferred_department(driver);
		profile_edit.click_clear_button();
		profile_edit.add_women_preferred_department(driver);
		profile_edit.click_clear_button();
		profile_edit.click_preferred_department(driver);

		// height and weight
		profile_edit.click_height_and_weight();
		profile_edit.add_height_weight(driver);
		profile_edit.click_clear_button();
		profile_edit.click_height_and_weight();

		// age group
		profile_edit.click_age_group();
		profile_edit.add_age_group(driver);
		profile_edit.click_clear_button();
		profile_edit.click_age_group();

		// department preferences
		profile_edit.select_mens_department_preferences();
		profile_edit.click_fit_attributes_button();
		profile_edit.add_fit_attributes(driver);
		profile_edit.click_clear_button();
		profile_edit.click_fit_attributes_button();

		profile_edit.select_womens_department_preferences();
		profile_edit.click_fit_attributes_button();
		profile_edit.click_clear_button();
		profile_edit.add_fit_attributes(driver);
		profile_edit.click_clear_button();
		profile_edit.click_fit_attributes_button();

		//shoes
		profile_edit.click_shoes();
		profile_edit.add_shoes_details(driver);
		profile_edit.click_clear_button();
		profile_edit.click_shoes();

	}

}
