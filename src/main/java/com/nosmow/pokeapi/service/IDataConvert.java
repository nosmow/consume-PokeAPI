package com.nosmow.pokeapi.service;

public interface IDataConvert {

    <T> T getData(String json, Class<T> tClass);
}
