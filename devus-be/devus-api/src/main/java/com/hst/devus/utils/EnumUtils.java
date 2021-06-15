package com.hst.devus.utils;

import static java.util.stream.Collectors.*;

import java.util.EnumSet;
import java.util.Map;
import java.util.function.Function;

import com.hst.devus.common.type.PersistableType;

import lombok.experimental.UtilityClass;

/**
 * @author dlgusrb0808@gmail.com
 */
@UtilityClass
public class EnumUtils {

	public <E extends Enum<E>, K> Map<K, E> asMap(Class<E> enumClass, Function<E, K> keyFunction) {
		return EnumSet.allOf(enumClass).stream()
			.collect(toMap(keyFunction, Function.identity()));
	}

	public <E extends Enum<E> & PersistableType<K>, K> Map<K, E> asMap(Class<E> enumClass) {
		return EnumSet.allOf(enumClass).stream()
			.collect(toMap(e -> e.getCode(), Function.identity()));
	}
}
