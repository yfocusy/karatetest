package com.yulikarate.test;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class StartServer {

    private static WireMockServer wireMockServer = new WireMockServer(8088);

    public static void startServer(){

        configureFor("localhost", 8088);
        wireMockServer.start();
        System.out.println(wireMockServer.port());
        System.out.println("-------------------------");
        stubFor(
                get(urlEqualTo("/user/get"))
                        .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody("{ \"id\": \"user1\", \"name\": \"Anna\" }")));

        stubFor(
                post(urlEqualTo("/user/create"))
                        .withHeader("content-type", equalTo("application/json"))
                        .withRequestBody(containing("id"))
                        .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody("{ \"id\": \"user1\", \"name\": \"Anna\" }")));

    }

    public static void main(String... args){
        startServer();
    }
}
