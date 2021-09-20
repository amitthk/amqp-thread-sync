package com.boot.model;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface INasdaqDataApiModel {

    @GET("datasets.json?query=*&database_code=WIKI&per_page=100")
    public SymbolModel getSymbols(@Query("page") int page);

    @GET("datasets/{source}/{symbol}/data.json")
    public StockModel getStock(@Path("source") String source, @Path("symbol") String symbol, @Query("trim_start") String from, @Query("trim_end") String to);
}
