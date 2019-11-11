package com.spartaglobal.SpaceXRestAssured;

import org.junit.BeforeClass;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class MultipleSpaceXTest {

    @BeforeClass
    public static void setup(){
        baseURI = "https://api.spacexdata.com/v3/capsules";
        basePath = "/v3/capsules";

    }
}
