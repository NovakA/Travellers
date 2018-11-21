package com.example.traveller.util;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumUtil {

	private EnumUtil() {
	}

	public static <K, V> Map<K, V> reverseMapping(V[] values, Function<V, K> mapping) {
		return Collections.unmodifiableMap(
				Stream.of(values).collect(Collectors.toMap(mapping, i -> i))
		);
	}

	public static <V, K> V valueOf(Map<K, V> map, K key) {
		V value = map.get(key);
		if (value == null) {
			throw new IllegalStateException("There is no value for key " + key);
		}
		return value;
	}
}
