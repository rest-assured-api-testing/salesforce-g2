package endpointurl;

public class Endpoint {
    public static final String PEOPLE = "/" + Element.INDIVIDUAL;
    public static final String PERSON = PEOPLE + "/{" + ElementParam.ID + "}";
    public static final String ACCOUNTS = "/" + Element.ACCOUNT;
    public static final String ACCOUNT = ACCOUNTS + "/{" + ElementParam.ID + "}";
    public static final String ORDERS = "/" + Element.ORDER;
    public static final String ORDER = ORDERS + "/{" + ElementParam.ID + "}";
    public static final String CONTACTS = "/" + Element.CONTACT;
    public static final String CONTACT = CONTACTS + "/{" + ElementParam.ID + "}";
    public static final String CAMPAIGNS = "/" + Element.CAMPAIGN;
    public static final String CAMPAIGN = CAMPAIGNS + "/{" + ElementParam.ID + "}";
    public static final String PRODUCTS = "/" + Element.PRODUCT;
    public static final String PRODUCT = PRODUCTS + "/{" + ElementParam.ID + "}";
}
