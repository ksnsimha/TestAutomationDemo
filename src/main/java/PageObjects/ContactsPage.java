package PageObjects;

import org.openqa.selenium.By;


import Common.UIModule;


public class ContactsPage extends UIModule {
	
	private By FORENAMEFIELD = By.id("forename");
    public By getFORENAMEFIELD() {
		return FORENAMEFIELD;
	}

	public void setFORENAMEFIELD(By fORENAMEFIELD) {
		FORENAMEFIELD = fORENAMEFIELD;
	}

	public By getEMAIlFIELD() {
		return EMAIlFIELD;
	}

	public void setEMAIlFIELD(By eMAIlFIELD) {
		EMAIlFIELD = eMAIlFIELD;
	}

	public By getMESSAGEFILED() {
		return MESSAGEFILED;
	}

	public void setMESSAGEFILED(By mESSAGEFILED) {
		MESSAGEFILED = mESSAGEFILED;
	}

	public By getSUBMITLINK() {
		return SUBMITLINK;
	}

	public void setSUBMITLINK(By sUBMITLINK) {
		SUBMITLINK = sUBMITLINK;
	}

	public By getFORENAMEFIELDERROR() {
		return FORENAMEFIELDERROR;
	}

	public void setFORENAMEFIELDERROR(By fORENAMEFIELDERROR) {
		FORENAMEFIELDERROR = fORENAMEFIELDERROR;
	}

	public By getEMAIlFIELDERROR() {
		return EMAIlFIELDERROR;
	}

	public void setEMAIlFIELDERROR(By eMAIlFIELDERROR) {
		EMAIlFIELDERROR = eMAIlFIELDERROR;
	}

	public By getMESSAGEFILEDERROR() {
		return MESSAGEFILEDERROR;
	}

	public void setMESSAGEFILEDERROR(By mESSAGEFILEDERROR) {
		MESSAGEFILEDERROR = mESSAGEFILEDERROR;
	}
	private By EMAIlFIELD = By.id("email");
    private By MESSAGEFILED = By.id("message");
    private By SUBMITLINK = By.linkText("Submit");
    private By FORENAMEFIELDERROR = By.id("forename-err");
    private By EMAIlFIELDERROR = By.id("email-err");
    private By MESSAGEFILEDERROR = By.id("message-err");
    


  
    public void submit() throws Exception {
        click(getSUBMITLINK());
    }


    
    public void enterForeNameField(String text) {
    	 try {
			enterText(getFORENAMEFIELD(), text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void enterEmailField(String text) {
   	 try {
			enterText(getEMAIlFIELD(), text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
    public void enterMessageField(String text) {
   	 try {
			enterText(getMESSAGEFILED(), text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
    public String getForeNameFieldErrorText() {
    	String resultText=null;
    	try {
    		resultText= getText(getFORENAMEFIELD());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	return resultText;
		
    }
    
    public String getEmailFieldErrorText() {
    	String resultText=null;
    	try {
    		resultText= getText(getEMAIlFIELD());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	return resultText;
    }
    public String getMessageFieldErrorText() {
    	String resultText=null;
    	try {
    		resultText= getText(getMESSAGEFILED());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	return resultText;
    }
    
}
