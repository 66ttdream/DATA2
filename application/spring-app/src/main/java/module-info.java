module Data.spring{
    requires spring.web;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires Data.controller.main;
    requires Data.conf;
    requires Data.usecase;
    requires tomcat.embed.core;
    requires gson;


    //exports com.slalom.example.spring;
    //exports com.slalom.example.spring.config;
    opens data.spring to spring.core;

}