/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.wso2.ballerina.docgen.docs.utils;

import org.wso2.ballerina.core.model.BLangPackage;
import org.wso2.ballerina.docgen.docs.BallerinaDocDataHolder;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BallerinaDocGenTestUtils {

    private static final PrintStream out = System.out;
    
    public static void printDocMap(Map<String, BLangPackage> docsMap) {
        for (Entry<String, BLangPackage> entry : docsMap.entrySet()) {
            out.println(entry.getValue().toString());
        }
    }
    
    public static void cleanUp() {
        BallerinaDocDataHolder.getInstance().setPackageMap(new HashMap<String, BLangPackage>());
    }

}
