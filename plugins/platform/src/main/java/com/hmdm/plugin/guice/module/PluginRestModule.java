/*
 *
 * Headwind MDM: Open Source Android MDM Software
 * https://h-mdm.com
 *
 * Copyright (C) 2019 Headwind Solutions LLC (http://h-sms.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.hmdm.plugin.guice.module;

import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.hmdm.plugin.rest.PluginResource;
import com.hmdm.rest.filter.AuthFilter;
import com.hmdm.rest.filter.PrivateIPFilter;
import com.hmdm.rest.filter.PublicIPFilter;

/**
 * <p>A <code>Guice</code> module for <code>Plugin Platform</code>.</p>
 *
 * @author isv
 */
public class PluginRestModule extends ServletModule {

    /**
     * <p>Constructs new <code>PluginRestModule</code> instance. This implementation does nothing.</p>
     */
    public PluginRestModule() {
    }

    /**
     * <p>Configures the resources for <code>Plugin Platform</code>.</p>
     */
    protected void configureServlets() {
        this.filter("/rest/plugin/main/private/*").through(AuthFilter.class);
        this.filter("/rest/plugin/main/private/*").through(PrivateIPFilter.class);
        this.filter("/rest/plugin/main/public/*").through(PublicIPFilter.class);
        this.bind(PluginResource.class);
    }

}
