package com.prova.fileprocessor.factory;

public interface IFileFactory<T> {
    T getBuild(String [] linefile);
}
