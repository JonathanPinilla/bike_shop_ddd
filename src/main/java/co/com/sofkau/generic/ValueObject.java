package co.com.sofkau.generic;

import java.io.Serializable;

public interface ValueObject<T> extends Serializable {
    T value();
}