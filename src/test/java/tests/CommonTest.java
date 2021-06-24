package tests;

import salesforce.auth.Authentication;
import salesforce.entities.CreatedResponse;
import org.testng.annotations.BeforeSuite;

public class CommonTest {
    protected CreatedResponse createdResponse;

    @BeforeSuite
    public void getToken() {
        Authentication.getAuth();
    }
}
