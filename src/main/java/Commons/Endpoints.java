/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package Commons;

/**
 * Contains the values for the endpoints to be used.
 */
public class Endpoints {

    public static final String GET_FEED_ELEMENTS = "/chatter/feeds/record/{user_id}/feed-elements";
    public static final String POST_FEED_ELEMENT = "/chatter/feed-elements";
    public static final String CREATE_PRODUCT = "/sobjects/Product2";

    private Endpoints() {
    }
}
