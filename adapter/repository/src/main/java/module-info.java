module Data.repository{
    exports data.repository.synparameter;
    exports data.repository.syndata;
    exports data.repository.log;
    exports data.repository.db;
    exports data.repository.dataanalyze;
    requires Data.usecase;
    requires Data.domain;
    requires com.github.davidmoten.rxjava2.jdbc;
    requires com.github.davidmoten.rxjava2.pool;
    requires lombok;
    requires io.reactivex.rxjava2;
    requires log4j;
    //requires mysql.connector.java;
    requires mysql.connector.java;
    requires Data.infrastructure;
    requires java.sql;

}