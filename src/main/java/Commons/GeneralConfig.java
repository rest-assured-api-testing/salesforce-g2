/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package Commons;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:general.properties"
})
public interface GeneralConfig extends Config{

    @Config.Key("app.username")
    String username();

    @Config.Key("app.password")
    String password();

    @Config.Key("app.client_id")
    String client_id();

    @Config.Key("app.client_secret")
    String client_secret();

    @Config.Key("app.security_token")
    String security_token();
}
