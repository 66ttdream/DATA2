module Data.conf {
    exports data.spring.conf;
    exports data.TimingTask.conf;
    requires Data.gateways;
    requires Data.usecase;
    requires Data.repository;
    requires lombok;
    requires com.github.davidmoten.rxjava2.jdbc;
    requires com.github.davidmoten.rxjava2.pool;
    requires mysql.connector.java;

}