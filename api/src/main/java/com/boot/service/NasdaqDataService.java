package com.boot.service;
import com.boot.model.NasdaqDataApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NasdaqDataService implements IAPIConfiguration{
    private NasdaqDataService _instance;

    @Autowired
    private NasdaqDataApiModel nasdaqDataApiModel;


}
