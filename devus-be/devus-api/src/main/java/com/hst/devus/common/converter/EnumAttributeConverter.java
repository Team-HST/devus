package com.hst.devus.common.converter;

import java.util.EnumSet;

import javax.persistence.AttributeConverter;

import com.hst.devus.common.type.PersistableType;

/**
 * @author dlgusrb0808@gmail.com
 */
public class EnumAttributeConverter<X extends Enum<X> & PersistableType<Y>, Y> implements AttributeConverter<X, Y> {

	private final Class<X> targetClass;
	private final boolean nullable;

	public EnumAttributeConverter(Class<X> targetClass, boolean nullable) {
		this.targetClass = targetClass;
		this.nullable = nullable;
	}

	@Override
	public X convertToEntityAttribute(Y code) {
		assertArgumentNotNull(code);
		return EnumSet.allOf(targetClass)
			.stream()
			.filter(e -> e.getCode().equals(code))
			.findAny()
			.orElseThrow(() ->
				new IllegalArgumentException(String.format("[%s] Can not convert value. %s", targetClass.getSimpleName(), code)));
	}

	@Override
	public Y convertToDatabaseColumn(X type) {
		assertArgumentNotNull(type);
		return type.getCode();
	}

	private void assertArgumentNotNull(Object value) {
		if (!nullable && value == null) {
			throw new IllegalArgumentException(String.format("[%s] NULL 값을 변환할 수 없습니다.", targetClass.getSimpleName()));
		}
	}

}
