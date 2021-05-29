package com.dive.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import commonUtils.BaseTest;
import commonUtils.GenericUtility;

public class diveAssignmentPage extends BaseTest {

	/**
	 * created object of GenericUtility class
	 */
	GenericUtility genericUtility = new GenericUtility();

	/**
	 * declared webelement of page
	 */

	@FindBy(xpath = "//*[.='START A RUME']")
	private WebElement startARume;

	@FindBy(xpath = "//*[@name='displayName']")
	private WebElement enterName;

	@FindBy(xpath = "//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained Mu')]")
	private WebElement joinRume;

	@FindBy(xpath = "(//*[@class='sc-bYoCmx iazfkw']")
	private List<WebElement> allParticipantsTabDisplaying;

	@FindBy(xpath = "(//*[@stroke='currentColor'])[2]")
	private WebElement enableAudio;

	@FindBy(xpath = "(//*[@stroke='currentColor'])[3]")
	private WebElement disableAudio;

	@FindBy(xpath = "(//*[@stroke='currentColor'])[3]")
	private WebElement enableVideo;

	@FindBy(xpath = "(//*[@stroke='currentColor'])[4]")
	private WebElement disableVideo;

	@FindBy(xpath = "(//*[@stroke='white'])[2]")
	private WebElement sharelink;

	@FindBy(xpath = "(//*[@data-icon='copy'])")
	private WebElement copyLinkIcon;

	@FindBy(xpath = "(//*[@aria-hidden='true'])[7]")
	private WebElement closeIcon;

	public GenericUtility getGenericUtility() {
		return genericUtility;
	}

	public WebElement getStartARume() {
		return startARume;
	}

	public WebElement getEnterName() {
		return enterName;
	}

	public WebElement getJoinRume() {
		return joinRume;
	}

	public WebElement getSharelink() {
		return sharelink;
	}

	public WebElement getCopyLinkIcon() {
		return copyLinkIcon;
	}

	public WebElement getCloseIcon() {
		return closeIcon;
	}

	public WebElement getEnableAudio() {
		return enableAudio;
	}

	public WebElement getDisableAudio() {
		return disableAudio;
	}

	public List<WebElement> getAllParticipantsTabDisplaying() {
		return allParticipantsTabDisplaying;
	}

	public WebElement getEnableVideo() {
		return enableVideo;
	}

	public WebElement getDisableVideo() {
		return disableVideo;
	}

	/**
	 * @Initilize the webelement
	 */
	public diveAssignmentPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @verify startRumeButton
	 */
	public void startRumeButton() throws Exception {
		boolean startRume = genericUtility.validateElementDisplayed(getStartARume());
		Assert.assertTrue(startRume);
		genericUtility.JseHighlightTheElement(getStartARume());
		genericUtility.JseClick(getStartARume());

	}

	/**
	 * @verify enterHostName
	 */
	public void enterHostName() throws Exception {

		genericUtility.sendToTextBox(getEnterName(), "KumarHost");
		genericUtility.wait(5);
	}

	/**
	 * @verify join rume
	 */
	public void joinRume() throws Exception {
		genericUtility.WaitForTheVisibilityOfElement(getJoinRume(), 80);
		genericUtility.JseHighlightTheElement(getJoinRume());
		genericUtility.JseClick(getJoinRume());
		genericUtility.wait(5);
	}

	/**
	 * @verify audioVideo
	 */
	public void audioVideo() throws Exception {
		genericUtility.JseHighlightTheElement(getEnableAudio());
		genericUtility.clickElement(getEnableAudio());
		genericUtility.wait(5);
		genericUtility.JseHighlightTheElement(getDisableAudio());
		genericUtility.wait(5);
		genericUtility.clickElement(getDisableAudio());

		genericUtility.JseHighlightTheElement(getEnableVideo());
//		genericUtility.clickElement(getEnableVideo());
//		genericUtility.wait(5);
//		genericUtility.JseHighlightTheElement(getDisableVideo());
//		genericUtility.wait(5);
//		genericUtility.clickElement(getDisableVideo());

	}
	/**
	 * @verify navigation to 8 tab & switch back to host
	 */

	public void openEightTab() throws Exception {

		genericUtility.wait(2);
		((JavascriptExecutor) driver)
				.executeScript("window.open('https://rume.video/r/36b1ad6b-580d-445d-bb72-07c19105f620')");
		genericUtility.switchtoNewWindow();
		genericUtility.WaitForTheVisibilityOfElement(getJoinRume(), 60);
		genericUtility.clearText(getEnterName());
		genericUtility.sendToTextBox(getEnterName(), genericUtility.getRandomText(5));
		genericUtility.JseHighlightTheElement(getJoinRume());
		genericUtility.JseClick(getJoinRume());
		genericUtility.wait(3);

		genericUtility.wait(2);
		((JavascriptExecutor) driver)
				.executeScript("window.open('https://rume.video/r/36b1ad6b-580d-445d-bb72-07c19105f620')");
		genericUtility.switchtoNewWindow();
		genericUtility.WaitForTheVisibilityOfElement(getJoinRume(), 60);
		genericUtility.clearText(getEnterName());
		genericUtility.sendToTextBox(getEnterName(), genericUtility.getRandomText(2));
		genericUtility.JseHighlightTheElement(getJoinRume());
		genericUtility.JseClick(getJoinRume());
		genericUtility.wait(3);

		genericUtility.wait(2);
		((JavascriptExecutor) driver)
				.executeScript("window.open('https://rume.video/r/36b1ad6b-580d-445d-bb72-07c19105f620')");
		genericUtility.switchtoNewWindow();
		genericUtility.WaitForTheVisibilityOfElement(getJoinRume(), 60);
		genericUtility.clearText(getEnterName());
		genericUtility.sendToTextBox(getEnterName(), genericUtility.getRandomText(5));
		genericUtility.JseHighlightTheElement(getJoinRume());
		genericUtility.JseClick(getJoinRume());
		genericUtility.wait(3);

		genericUtility.wait(2);
		((JavascriptExecutor) driver)
				.executeScript("window.open('https://rume.video/r/36b1ad6b-580d-445d-bb72-07c19105f620')");
		genericUtility.switchtoNewWindow();
		genericUtility.WaitForTheVisibilityOfElement(getJoinRume(), 60);
		genericUtility.clearText(getEnterName());
		genericUtility.sendToTextBox(getEnterName(), genericUtility.getRandomText(5));
		genericUtility.JseHighlightTheElement(getJoinRume());
		genericUtility.JseClick(getJoinRume());
		genericUtility.wait(3);

		genericUtility.wait(2);
		((JavascriptExecutor) driver)
				.executeScript("window.open('https://rume.video/r/36b1ad6b-580d-445d-bb72-07c19105f620')");
		genericUtility.switchtoNewWindow();
		genericUtility.WaitForTheVisibilityOfElement(getJoinRume(), 60);
		genericUtility.clearText(getEnterName());
		genericUtility.sendToTextBox(getEnterName(), genericUtility.getRandomText(5));
		genericUtility.JseHighlightTheElement(getJoinRume());
		genericUtility.JseClick(getJoinRume());
		genericUtility.wait(3);

		genericUtility.wait(2);
		((JavascriptExecutor) driver)
				.executeScript("window.open('https://rume.video/r/36b1ad6b-580d-445d-bb72-07c19105f620')");
		genericUtility.switchtoNewWindow();
		genericUtility.WaitForTheVisibilityOfElement(getJoinRume(), 60);
		genericUtility.clearText(getEnterName());
		genericUtility.sendToTextBox(getEnterName(), genericUtility.getRandomText(5));
		genericUtility.JseHighlightTheElement(getJoinRume());
		genericUtility.JseClick(getJoinRume());
		genericUtility.wait(3);

		genericUtility.wait(2);
		((JavascriptExecutor) driver)
				.executeScript("window.open('https://rume.video/r/36b1ad6b-580d-445d-bb72-07c19105f620')");
		genericUtility.switchtoNewWindow();
		genericUtility.WaitForTheVisibilityOfElement(getJoinRume(), 60);
		genericUtility.clearText(getEnterName());
		genericUtility.sendToTextBox(getEnterName(), genericUtility.getRandomText(5));
		genericUtility.JseHighlightTheElement(getJoinRume());
		genericUtility.JseClick(getJoinRume());
		genericUtility.wait(3);

		genericUtility.SwitchtoparentTab();
		genericUtility.parentTab();
		genericUtility.wait(80);

	}

	

}
