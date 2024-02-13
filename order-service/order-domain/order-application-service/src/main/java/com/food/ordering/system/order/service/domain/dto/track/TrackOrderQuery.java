package com.food.ordering.system.order.service.domain.dto.track;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TrackOrderQuery {
	
	private final UUID orderTrackingId;

}
