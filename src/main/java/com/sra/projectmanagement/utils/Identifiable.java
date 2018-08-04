package com.sra.projectmanagement.utils;

import java.io.Serializable;

public interface Identifiable<T extends Serializable> {

    T getId();
}
