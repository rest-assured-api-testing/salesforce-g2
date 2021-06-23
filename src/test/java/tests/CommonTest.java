package tests;

import auth.Authentication;
import entities.CreatedResponse;
import org.testng.annotations.BeforeSuite;

public class CommonTest {
    protected CreatedResponse createdResponse;

    @BeforeSuite
    public void getToken() {
        Authentication.getAuth();
    }
}
