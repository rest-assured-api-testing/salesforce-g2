package endpointurl;

public class Endpoint {
    public static final String PEOPLE = "/" + Element.INDIVIDUAL;
    public static final String PERSON = PEOPLE + "/{" + ElementParam.ID + "}";
    public static final String ACCOUNTS = "/" + Element.ACCOUNT;
    public static final String ACCOUNT = PEOPLE + "/{" + ElementParam.ID + "}";
    public static final String ORDERS = "/" + Element.ORDER;
    public static final String ORDER = PEOPLE + "/{" + ElementParam.ID + "}";
    public static final String CONTACTS = "/" + Element.CONTACT;
    public static final String CONTACT = PEOPLE + "/{" + ElementParam.ID + "}";
    public static final String CONTRACTS = "/" + Element.CONTRACT;
    public static final String CONTRACT = PEOPLE + "/{" + ElementParam.ID + "}";
    public static final String PRODUCTS = "/" + Element.PRODUCT;
    public static final String PRODUCT = PEOPLE + "/{" + ElementParam.ID + "}";
}
