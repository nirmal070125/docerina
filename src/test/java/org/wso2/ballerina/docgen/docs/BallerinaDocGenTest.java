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
package org.wso2.ballerina.docgen.docs;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.ballerina.core.model.BLangPackage;
import org.wso2.ballerina.docgen.docs.utils.BallerinaDocGenTestUtils;

import java.io.IOException;
import java.util.Map;

public class BallerinaDocGenTest {

    @BeforeClass()
    public void setup() {
    }

    @Test(description = "Test Single Bal file")
    public void testSingleBalFile() {
        try {
            Map<String, BLangPackage> docsMap = BallerinaDocGeneratorMain
                    .generatePackageDocsFromBallerina("src/test/resources/balFiles/helloWorld.bal");
            Assert.assertNotNull(docsMap);
            Assert.assertEquals(docsMap.size(), 1);
        } catch (IOException e) {
            Assert.fail();
        } finally {
            BallerinaDocGenTestUtils.cleanUp();
        }
    }

    @Test(description = "Test a folder with Bal files")
    public void testFolderWithBalFile() {
        try {
            Map<String, BLangPackage> docsMap = BallerinaDocGeneratorMain
                    .generatePackageDocsFromBallerina("src/test/resources/balFiles/balFolder");
            Assert.assertNotNull(docsMap);
            // this folder has 3 bal files. 2 bal files out of those are in same package.
            Assert.assertEquals(docsMap.size(), 2);
            // assert package names
            Assert.assertEquals(docsMap.containsKey("a.b"), true);
            Assert.assertEquals(docsMap.containsKey("a.b.c"), true);
        } catch (IOException e) {
            Assert.fail();
        } finally {
            BallerinaDocGenTestUtils.cleanUp();
        }
    }
}
