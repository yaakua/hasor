/*
 * Copyright 2008-2009 the original 赵永春(zyc@hasor.net).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.test.hasor.web;
import javax.servlet.ServletContext;
import net.hasor.plugins.resource.ResourceLoader;
import net.hasor.plugins.resource.loader.ZipResourceLoader;
import net.hasor.web.WebApiBinder;
import net.hasor.web.WebModule;
import net.test.hasor.web._02_servlet.MyServletModule;
/**
 * 
 * @version : 2015年12月25日
 * @author 赵永春(zyc@hasor.net)
 */
public class MyModule extends WebModule {
    @Override
    public void loadModule(WebApiBinder apiBinder) throws Throwable {
        apiBinder.installModule(new MyServletModule());
        //
        //resource插件用法
        ServletContext sc = apiBinder.getServletContext();
        apiBinder.bindType(ResourceLoader.class).toInstance(new ZipResourceLoader(sc.getRealPath("/static/jquery-2.1.4.zip")));
        apiBinder.bindType(ResourceLoader.class).toInstance(new ZipResourceLoader(sc.getRealPath("/static/Semantic-UI-v2.0.0.zip")));
        //
        //
    }
}
