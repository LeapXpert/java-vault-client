/*
 * Copyright (c) 2017 Nike, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nike.vault.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

/**
 * Class to get the version of the current Cerberus client
 */
public class ClientVersion {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientVersion.class);

    protected static final String CLIENT_VERSION_PROPERTY_FILE = "java-vault-client.properties";

    private static final String VAULT_CLIENT_VERSION_PROPERTY = "java_vault_client.version";

    public static String getVersion() {

        String clientVersion = "unknown";
        try {
            InputStream propsStream = ClientVersion.class.getClassLoader().getResourceAsStream(CLIENT_VERSION_PROPERTY_FILE);
            Properties properties = new Properties();
            properties.load(propsStream);

            clientVersion = properties.getProperty(VAULT_CLIENT_VERSION_PROPERTY);
        } catch (Exception e) {
            LOGGER.error("Failed to load client properties file", e);
        }

        return clientVersion;
    }
}
