/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package Commons;

import org.aeonbits.owner.ConfigCache;

/**
 * Singleton for a GeneralConfig class.
 */
public class ConfigurationManager {

    private ConfigurationManager() {
    }

    /**
     * Returns an instance of the GeneralConfig class.
     * @return
     */
    public static GeneralConfig getConfiguration() {
        return ConfigCache.getOrCreate(GeneralConfig.class);
    }
}
