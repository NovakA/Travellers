package com.example.traveller.entity.cat;

import com.example.traveller.util.EnumUtil;

import javax.persistence.AttributeConverter;
import java.util.Map;

// table name cat_sex
public enum Sex implements EnumCatalog {

	WOMAN(0),
	MAN(1);

	private static final Map<Integer, Sex> idMap = EnumUtil.reverseMapping(values(), Sex::getId);
	private final int id;

	Sex(Integer id) {
		this.id = id;
	}

	public static Sex byId(int id) {
		return EnumUtil.valueOf(idMap, id);
	}

	public Integer getId() {
		return id;
	}

	@SuppressWarnings("unused")
	@javax.persistence.Converter(autoApply = true)
	public static class Converter implements AttributeConverter<Sex, Integer> {
		@Override
		public Integer convertToDatabaseColumn(Sex sex) {
			return sex.getId();
		}

		@Override
		public Sex convertToEntityAttribute(Integer integer) {
			return byId(integer);
		}
	}
}
