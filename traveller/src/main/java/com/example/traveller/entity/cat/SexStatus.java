package com.example.traveller.entity.cat;

import com.example.traveller.util.EnumUtil;

import javax.persistence.AttributeConverter;
import java.util.Map;

public enum SexStatus implements EnumCatalog {

	WOMAN(0),
	MAN(1);

	private static final Map<Integer, SexStatus> idMap = EnumUtil.reverseMapping(values(), SexStatus::getId);
	private final int id;

	SexStatus(Integer id) {
		this.id = id;
	}

	public static SexStatus byId(int id) {
		return EnumUtil.valueOf(idMap, id);
	}

	public Integer getId() {
		return id;
	}

	@SuppressWarnings("unused")
	@javax.persistence.Converter(autoApply = true)
	public static class Converter implements AttributeConverter<SexStatus, Integer> {
		@Override
		public Integer convertToDatabaseColumn(SexStatus SexStatus) {
			return SexStatus.getId();
		}

		@Override
		public SexStatus convertToEntityAttribute(Integer integer) {
			return byId(integer);
		}
	}
}
