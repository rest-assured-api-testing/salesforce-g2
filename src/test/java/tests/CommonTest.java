package tests;

import auth.Authentication;
import entities.ModifiedResponse;
import org.testng.annotations.BeforeSuite;

public class CommonTest {
    protected ModifiedResponse modifiedResponse;

    @BeforeSuite
    public void getToken() {
        Authentication.getAuth();
    }
}
