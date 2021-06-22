/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package api;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfigurationFile {
    /**
     * Constant that refers path of environment variables file.
     */
    public static Dotenv dotenv = Dotenv.configure().filename(".env.develop").ignoreIfMalformed().ignoreIfMissing().load();
}
