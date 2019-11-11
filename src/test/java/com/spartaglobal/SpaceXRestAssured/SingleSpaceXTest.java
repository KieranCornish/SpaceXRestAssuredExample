package com.spartaglobal.SpaceXRestAssured;

import static org.junit.Assert.assertTrue;

import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class SingleSpaceXTest {
    private static Response singleSpaceXResponse;

    @BeforeClass
    public static void setup() {
        baseURI = "https://api.spacexdata.com/v3";
        basePath = "/capsules";
        singleSpaceXResponse = get();
    }

    @Test
    public void spaceXRequestCapsuleSerial(){
        singleSpaceXResponse
                .then()
                .statusCode(200)
                .body("[0].capsule_serial", equalTo("C101"));
    }
    @Test
    public void spaceXRequestMissions(){
        singleSpaceXResponse
                .then()
                .statusCode(200)
                .body("[0].missions[0].name", equalTo("COTS 1"));
    }
    @Test
    public void spaceXRequestMissionsFlight(){
        singleSpaceXResponse
                .then()
                .statusCode(200)
                .body("[0].missions[0].flight", equalTo(7));
    }
    @Test
    public void spaceXRequestMissions2(){
        singleSpaceXResponse
                .then()
                .statusCode(200)
                .body("[1].missions[0].name", equalTo("COTS 2"));
    }
    @Test
    public void spaceXRequestMissions2Flight(){
        singleSpaceXResponse
                .then()
                .statusCode(200)
                .body("[1].missions[0].flight", equalTo(8));
    }
    @Test
    public void spaceXRequestCapsule1(){
        singleSpaceXResponse
                .then()
                .statusCode(200)
                .body("[0].capsule_serial" +
                        "[0].capsule_id"+
                        "[0].status"+
                        "[0].original_launch"+
                        "[0].original_launch_unix"+
                        "[0].missions[0].name"+
                                "missions[0].flight"+
                        "[0].landings"+
                        "[0].type"+
                        "[0].details"+
                        "[0].reuse_count"
                        , equalTo("C101"+"dragon1"+ "retired"+"2010-12-08T15:43:00.000Z"+ 1291822980 +"COTS 2"+7+0+"Dragon 1.0"+"Reentered after three weeks in orbit"+null));
    }

}
