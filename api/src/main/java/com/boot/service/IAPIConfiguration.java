package com.boot.service;
import org.joda.time.DateTime;

public interface IAPIConfiguration {
    static final String NASDAQ_API_ENDPOINT = "http://data.nasdaq.com/api/v3/";
    static final String DATA_SOURCE = "GOOG";
    static final DateTime DEFAULT_TO = new DateTime();
    static final DateTime DEFAULT_FROM = new DateTime(DEFAULT_TO.minusYears(1));

}
